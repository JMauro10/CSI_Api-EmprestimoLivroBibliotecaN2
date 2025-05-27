package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Emprestimo;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Livro;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Status;
import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    long countByUsuarioAndStatus(Usuario usuario, Status status);

    boolean existsByLivroAndStatus(Livro livro, Status status);
}
