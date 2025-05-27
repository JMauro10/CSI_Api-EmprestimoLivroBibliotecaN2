package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Livro;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro alterarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletarByIdLivro(Long id) {
        livroRepository.deleteById(id);
    }


}
