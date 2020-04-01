package com.sergioruy.algamoneyapi.repository;

import com.sergioruy.algamoneyapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
