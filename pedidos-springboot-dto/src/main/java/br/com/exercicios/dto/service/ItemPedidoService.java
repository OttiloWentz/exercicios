package br.com.exercicios.dto.service;

import br.com.exercicios.dto.model.ItemPedido;
import br.com.exercicios.dto.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public void deleteItemPedidoById(Long idItemPedido){
        itemPedidoRepository.deleteById(idItemPedido);
    }


    public ItemPedido getItemPedidoById(Long idItemPedido){
        return itemPedidoRepository.findById(idItemPedido).get();
    }

    @Transactional
    public void deleteItemPedido(ItemPedido itemPedido){
        itemPedidoRepository.delete(itemPedido);
    }
}
