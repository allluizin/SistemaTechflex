package com.techflex.gerenciamento.Gerenciamento.Repositories;

import com.techflex.gerenciamento.Gerenciamento.Entities.ProducaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<ProducaoEntity, Long> {

}
