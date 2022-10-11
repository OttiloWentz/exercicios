package br.com.exercicios.api.M3S2E5.controllers;

import br.com.exercicios.api.M3S2E5.model.Produto;
import br.com.exercicios.api.M3S2E5.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     *
     * @param nome the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "mostrarnome/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String nome) {
        return "Olá " + nome + "! Estamos começando nosso trabalho com Springboot.";
    }

    @GetMapping(value = "valores/{num1}/{num2}")
    @ResponseStatus(HttpStatus.OK)
    public double mostraValores(@PathVariable double num1, @PathVariable double num2){
        return Double.parseDouble(("valores: "+num1+" "+num2+" "+(num1+num2)/2));
        //não consegui obter a resposta :(
    }
    @RequestMapping(value = "/produto/{descricao}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String inserir(@PathVariable String descricao){
        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produtoRepository.save(produto);

        return "Produto "+descricao+ " inserido";
    }
}
