package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.controller;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Emprestimo;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@CrossOrigin("*")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<Emprestimo> pegarTodosEmprestimos() {
        return emprestimoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<?> createEmprestimo(@RequestBody Emprestimo emprestimo) {
        try {
            Emprestimo novoEmprestimo = emprestimoService.criarEmprestimo(emprestimo);
            return ResponseEntity.ok(novoEmprestimo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/devolucao/{id}")
    public ResponseEntity<?> devolverLivro(@PathVariable Long id) {
        try {
            Emprestimo emprestimo = emprestimoService.devolverLivro(id);
            return ResponseEntity.ok(emprestimo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}