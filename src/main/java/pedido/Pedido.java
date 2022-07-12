package pedido;

import exception.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Pedido{

    private int id;
    private List<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, List<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        final var total = itens.stream()
                                        .map(pedido -> {
                                                        final var shake = pedido.getShake();
                                                        final var adicionais = shake.getAdicionais();
                                                        final var precoBase = cardapio.buscarPreco(shake.getBase());
                                                        final var precoAdicionais = adicionais.stream()
                                                                                                        .map(adicional -> cardapio.buscarPreco(adicional))
                                                                                                        .reduce(0.0, Double::sum);
                                                        final var acrescimo = shake.getTipoTamanho().multiplicador * precoBase;
                                                        final var valorTotalShake = precoBase + acrescimo + precoAdicionais;
                                                        return valorTotalShake * pedido.getQuantidade();
                                        })
                                        .reduce(0.0, Double::sum);

        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        final var itemIdx = itens.indexOf(itemPedidoAdicionado);
        if (itemIdx != -1){
            final var item = itens.get(itemIdx);
            final var quantidade = item.getQuantidade();
            item.setQuantidade(quantidade+itemPedidoAdicionado.getQuantidade());
            itens.set(itemIdx, item);
        }else {
            itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        try {
            final var itemIdx = itens.indexOf(itemPedidoRemovido);
            final var item = itens.get(itemIdx);
            final var quantidade = item.getQuantidade() - 1;
            item.setQuantidade(quantidade);
            if (quantidade > 0){
                itens.set(itemIdx, item);
            }else{
                itens.remove(itemIdx);
            }
            return true;
        }
        catch (Exception itemNaoEncontrado){
            throw new ItemNaoEncontradoException();
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
