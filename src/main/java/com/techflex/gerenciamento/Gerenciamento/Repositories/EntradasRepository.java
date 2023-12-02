package com.techflex.gerenciamento.Gerenciamento.Repositories;

import com.techflex.gerenciamento.Gerenciamento.Entities.EntradasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EntradasRepository extends JpaRepository<EntradasEntity, Long> {
}
