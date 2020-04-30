package com.sergioruy.algamoneyapi.service;

import com.sergioruy.algamoneyapi.model.Lancamento;
import com.sergioruy.algamoneyapi.model.Pessoa;
import com.sergioruy.algamoneyapi.repository.LancamentoRepository;
import com.sergioruy.algamoneyapi.repository.PessoaRepository;
import com.sergioruy.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
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

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo).get();
        if(!lancamento.getPessoa().equals(lancamentoSalvo.getPessoa())) {
            validarPessoa(lancamento);
        }

        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");

        return lancamentoRepository.save(lancamentoSalvo);
    }

    private void validarPessoa(Lancamento lancamento) {
        Optional<Pessoa> pessoa = null;
        if (lancamento.getPessoa().getCodigo() != null) {
            pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        }

        if (pessoa==null || !pessoa.isPresent()) {
            throw new PessoaInexistenteOuInativaException();
        }
    }

    private Optional<Lancamento> buscarLancamentoExistente(Long codigo) {
        Optional<Lancamento> lancamentoSalvo = this.lancamentoRepository.findById(codigo);
        if (!lancamentoSalvo.isPresent() ) {
            throw new IllegalArgumentException();
        }
        return lancamentoSalvo;
    }
}
