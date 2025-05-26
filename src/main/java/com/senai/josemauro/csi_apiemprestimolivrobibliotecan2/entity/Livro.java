package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;
    private String editora;
    private LocalDate anoPublicacao;

}
