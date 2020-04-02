package com.sergioruy.algamoneyapi.repository.lancamento;

import com.sergioruy.algamoneyapi.model.Lancamento;
import com.sergioruy.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
