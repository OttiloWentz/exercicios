package br.com.exercicios.dto.service;

import br.com.exercicios.dto.model.FormaPagamento;
import br.com.exercicios.dto.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento getFormaPagamentoById(Long idFormaPagamento){
        return formaPagamentoRepository.findById(idFormaPagamento).get();
    }
}
