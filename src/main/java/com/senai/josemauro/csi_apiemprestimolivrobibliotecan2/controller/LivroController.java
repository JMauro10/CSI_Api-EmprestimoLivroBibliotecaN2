package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.controller;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Livro;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livro")
@CrossOrigin("*")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivro() {
        return livroService.listarTodosLivros();
    }

    @PostMapping
    public Livro incluirLivro(@RequestBody Livro livro){
        return livroService.salvarLivro(livro);
    }

    @PutMapping
    public Livro alterarLivroByID(@RequestBody Livro livro) {
        return livroService.alterarLivro(livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivroById(@PathVariable Long id){
        livroService.deletarByIdLivro(id);
    }
}
