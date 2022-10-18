package br.com.exercicios.crud.repository;

import br.com.exercicios.crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = " select p from Pessoa p where p.nome like %?1% ")
    ArrayList<Pessoa> getPessoaByName(String nome);
}
