package com.sergioruy.algamoneyapi.repository.lancamento;

import com.sergioruy.algamoneyapi.model.Lancamento;
import com.sergioruy.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
}
