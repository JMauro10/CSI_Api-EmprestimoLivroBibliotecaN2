package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String matricula;
    private String curso;
}
