package br.com.exercicios.dto.repository;

import br.com.exercicios.dto.model.FormaPagamento;
import org.springframework.data.repository.CrudRepository;

public interface FormaPagamentoRepository extends CrudRepository<FormaPagamento, Long> {
}
