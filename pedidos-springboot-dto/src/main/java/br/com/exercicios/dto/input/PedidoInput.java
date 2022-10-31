package br.com.exercicios.dto.input;

import br.com.exercicios.dto.model.Cliente;
import br.com.exercicios.dto.model.FormaPagamento;
import br.com.exercicios.dto.model.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoInput {

    private Long idPedido;

    private Long idCliente;

    private Long idFormaPagamento;

    private List<ItemPedidoInput> itensPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public List<ItemPedidoInput> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedidoInput> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
