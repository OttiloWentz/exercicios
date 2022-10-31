package br.com.exercicios.dto.service;

import br.com.exercicios.dto.model.Produto;
import br.com.exercicios.dto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto){

        //regras de negócio, qdo existirem

        return produtoRepository.save(produto);


    }

    public void deleteById(Long idProduto){
        produtoRepository.deleteById(idProduto);
    }

    public Produto getProdutoById(Long idProduto){
        return produtoRepository.findById(idProduto).get();
    }

    public List<Produto> getProdutosByDescricao(String descricao){
        List<Produto> produtos = produtoRepository.getProdutoByDescricao(descricao);
        return produtos;
    }

    public List<Produto> getProdutos(){
        return (List<Produto>) produtoRepository.findAll();
    }

}
