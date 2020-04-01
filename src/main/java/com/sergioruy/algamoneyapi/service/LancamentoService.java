package com.sergioruy.algamoneyapi.service;

import com.sergioruy.algamoneyapi.model.Lancamento;
import com.sergioruy.algamoneyapi.model.Pessoa;
import com.sergioruy.algamoneyapi.repository.LancamentoRepository;
import com.sergioruy.algamoneyapi.repository.PessoaRepository;
import com.sergioruy.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa == null || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
}
