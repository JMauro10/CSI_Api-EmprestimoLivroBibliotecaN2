package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.repository;

import com.senai.josemauro.csi_apiemprestimolivrobibliotecan2.entity.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
}
