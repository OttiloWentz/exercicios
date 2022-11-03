package br.com.exercicios.dto.repository;

import br.com.exercicios.dto.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("select p from Produto p where p.descricao like %?1%")
    List<Produto> getProdutoByDescricao(String descricao);

}
