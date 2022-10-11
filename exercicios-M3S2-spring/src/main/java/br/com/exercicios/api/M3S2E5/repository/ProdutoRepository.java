package br.com.exercicios.api.M3S2E5.repository;

import br.com.exercicios.api.M3S2E5.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
