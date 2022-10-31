package br.com.exercicios.dto.service;

import br.com.exercicios.dto.model.Cliente;
import br.com.exercicios.dto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente getClienteById(Long idCliente){
        return clienteRepository.findById(idCliente).get();
    }

}
