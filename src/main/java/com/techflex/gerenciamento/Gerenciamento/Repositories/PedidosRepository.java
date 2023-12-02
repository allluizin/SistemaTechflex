package com.techflex.gerenciamento.Gerenciamento.Repositories;

import com.techflex.gerenciamento.Gerenciamento.Entities.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity, Long> {
}
