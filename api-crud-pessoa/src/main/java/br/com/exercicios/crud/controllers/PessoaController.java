package br.com.exercicios.crud.controllers;

import br.com.exercicios.crud.model.Pessoa;
import br.com.exercicios.crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa){
        Pessoa pessoa1 = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(pessoa1, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable (value = "idPessoa") Long idPessoa){
        Pessoa pessoa1 = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<Pessoa>(pessoa1, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa){
        Pessoa pessoa1 = pessoaRepository.save(pessoa);
        return new ResponseEntity<Pessoa>(pessoa1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> deletar(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Registro deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public ResponseEntity<List<Pessoa>> getPessoaByName(@RequestParam String nome){
        List<Pessoa> pessoas = pessoaRepository.getPessoaByName(nome);
        return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
    }

}
