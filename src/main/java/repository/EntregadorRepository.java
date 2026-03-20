package com.douglassantos.smartdelivery.repository;

import com.douglassantos.smartdelivery.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    // buscar apenas disponíveis
    List<Entregador> findByDisponivelTrue();
}