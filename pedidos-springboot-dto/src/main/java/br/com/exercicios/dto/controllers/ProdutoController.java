package br.com.exercicios.dto.controllers;

import br.com.exercicios.dto.dto.ProdutoRepresentation;
import br.com.exercicios.dto.input.ProdutoInput;
import br.com.exercicios.dto.model.Produto;
import br.com.exercicios.dto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ProdutoRepresentation> cadastrar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = toDomainObject(produtoInput);
        produtoService.salvar(produto);
        return new ResponseEntity<ProdutoRepresentation>(toModel(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProdutoRepresentation> atualizar(@RequestBody ProdutoInput produtoInput) {
        Produto produto = produtoService.salvar(toDomainObject(produtoInput));
        return new ResponseEntity<ProdutoRepresentation>(toModel(produto), HttpStatus.OK);
    }



    @DeleteMapping
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto) {
        produtoService.deleteById(idProduto);
        return new ResponseEntity<String>("Produto ID: " + idProduto + ": deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/{idProduto}")
    public ResponseEntity<ProdutoRepresentation> getProdutoById(@PathVariable(value = "idProduto") Long idProduto) {
        ProdutoRepresentation produtoRepresentation = toModel(produtoService.getProdutoById(idProduto));
        return new ResponseEntity<ProdutoRepresentation>(produtoRepresentation, HttpStatus.OK);
    }

    @GetMapping(value = "/{descricao}")
    public ResponseEntity<List<ProdutoRepresentation>> getProdutosByName(
            @PathVariable(name = "descricao") String descricao) {

        // obtem a lista de produtos do Model, nossas entidades
        List<Produto> produtos = produtoService.getProdutosByDescricao(descricao);

        // convertemos o lista Model para Representation Model nosso DTO de saída
        List<ProdutoRepresentation> produtosRepresentation = toCollectionModel(produtos);

        return new ResponseEntity<List<ProdutoRepresentation>>(produtosRepresentation, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProdutoRepresentation>> getProdutos() {

        List<Produto> produtos = produtoService.getProdutos();

        // convertemos o lista Model para Representation Model nosso DTO de saída
        List<ProdutoRepresentation> produtosRepresentation = toCollectionModel(produtos);

        return new ResponseEntity<List<ProdutoRepresentation>>(produtosRepresentation, HttpStatus.OK);


    }


    private Produto toDomainObject(ProdutoInput produtoInput) {
        Produto produto = new Produto();
        produto.setId(produtoInput.getIdProduto());
        produto.setDescricao(produtoInput.getDescricao());
        produto.setPrecoCompra(produtoInput.getPrecoCompra());
        produto.setPrecoVenda(produtoInput.getPrecoVenda());
        return produto;
    }

    private ProdutoRepresentation toModel(Produto produto) {
        ProdutoRepresentation produtoRepresentation = new ProdutoRepresentation();
        produtoRepresentation.setId(produto.getId());
        produtoRepresentation.setDescricao(produto.getDescricao());
        produtoRepresentation.setPrecoCompra(produto.getPrecoCompra());
        produtoRepresentation.setPrecoVenda(produto.getPrecoVenda());
        return produtoRepresentation;
    }

    // Converte uma lista de objetos do tipo Produto para uma lista de objetos do tipo ProdutoRepresentationModel
    private List<ProdutoRepresentation> toCollectionModel(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto -> toModel(Produto))
                .collect(Collectors.toList());

    }

//    @Autowired
//    private ProdutoService produtoService;
//
//    @PostMapping(value = "/", produces = "application/json")
//    public ResponseEntity<ProdutoRepresentation> cadastrar(@RequestBody ProdutoInput produtoInput){
//        Produto produto = toDomainObject(produtoInput);
//        produtoService.salvar(produto);
//        return new ResponseEntity<ProdutoRepresentation>(toModel(produto), HttpStatus.CREATED);
//
//    }
//
//    @PutMapping
//    public ResponseEntity<ProdutoRepresentation> atualizar(@RequestBody ProdutoInput produtoInput){
//        Produto produto = produtoService.salvar(toDomainObject(produtoInput));
//        return new ResponseEntity<ProdutoRepresentation>(toModel(produto), HttpStatus.OK);
//
//    }
//
//    public ResponseEntity<String> delete(@RequestParam Long idProduto){
//        produtoService.deleteById(idProduto);
//        return new ResponseEntity<String>("Produto ID: " + idProduto + " deletado com sucesso!", HttpStatus.OK);
//
//    }
//
//    private Produto toDomainObject(ProdutoInput produtoInput){
//        Produto produto = new Produto();
//        produto.setId(produtoInput.getId());
//        produto.setDescricao(produtoInput.getDescricao());
//        produto.setPrecoCompra(produtoInput.getPrecoCompra());
//        produto.setPrecoVenda(produtoInput.getPrecoVenda());
//        return produto;
//    }
//
//    private ProdutoRepresentation toModel(Produto produto){
//
//        ProdutoRepresentation produtoRepresentation = new ProdutoRepresentation();
//        produtoRepresentation.setId(produto.getId());
//        produtoRepresentation.setDescricao((produto.getDescricao()));
//        produtoRepresentation.setPrecoCompra(produto.getPrecoCompra());
//        produtoRepresentation.setPrecoVenda(produto.getPrecoVenda());
//        return produtoRepresentation;
//    }
}
