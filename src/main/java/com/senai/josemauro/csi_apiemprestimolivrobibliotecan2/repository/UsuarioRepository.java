package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
