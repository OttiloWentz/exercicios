package br.com.exercicios.dto.repository;

import br.com.exercicios.dto.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {


}
