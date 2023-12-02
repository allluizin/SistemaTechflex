package com.techflex.gerenciamento.Gerenciamento.Repositories;

import com.techflex.gerenciamento.Gerenciamento.Entities.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

}
