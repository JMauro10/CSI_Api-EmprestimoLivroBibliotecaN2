package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service;


import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Usuario;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarByIdUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
