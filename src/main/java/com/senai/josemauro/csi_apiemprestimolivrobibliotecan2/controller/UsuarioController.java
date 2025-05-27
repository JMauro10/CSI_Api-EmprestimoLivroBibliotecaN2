package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.controller;


import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Usuario;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioService.listarTodosUsuarios();
    }

    @PostMapping
    public Usuario incluirUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping
    public Usuario alterarUsuarioByID(@RequestBody Usuario usuario) {
        return usuarioService.alterarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioById(@PathVariable Long id){
        usuarioService.deletarByIdUsuario(id);
    }

}
