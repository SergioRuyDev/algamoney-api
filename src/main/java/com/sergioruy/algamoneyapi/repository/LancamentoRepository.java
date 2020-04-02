package com.sergioruy.algamoneyapi.repository;

import com.sergioruy.algamoneyapi.model.Lancamento;
import com.sergioruy.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
