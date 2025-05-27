package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Emprestimo;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Livro;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Status;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Usuario;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository.EmprestimoRepository;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository.LivroRepository;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Emprestimo criarEmprestimo(Emprestimo emprestimo) throws Exception {
        Livro livro = livroRepository.findById(emprestimo.getLivro().getId())
                .orElseThrow(() -> new Exception("Livro não encontrado"));

        Usuario usuario = usuarioRepository.findById(emprestimo.getUsuario().getId())
                .orElseThrow(() -> new Exception("Usuário não encontrado"));

        long emprestimosAtivos = emprestimoRepository.countByUsuarioAndStatus(usuario, Status.EMPRESTADO);
        if (emprestimosAtivos >= 3) {
            throw new Exception("Usuário já possui 3 livros emprestados.");
        }

        boolean livroJaEmprestado = emprestimoRepository.existsByLivroAndStatus(livro, Status.EMPRESTADO);
        if (livroJaEmprestado) {
            throw new Exception("Livro já está emprestado.");
        }

        emprestimo.setStatus(Status.EMPRESTADO);
        emprestimo.setDataEmprestimo(LocalDate.now());
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverLivro(Long emprestimoId) throws Exception {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new Exception("Empréstimo não encontrado"));

        if (emprestimo.getStatus() == Status.EMPRESTADO) {
            emprestimo.setStatus(Status.DEVOLVIDO);
            return emprestimoRepository.save(emprestimo);
        } else {
            throw new Exception("O livro já foi devolvido.");
        }
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }


}
