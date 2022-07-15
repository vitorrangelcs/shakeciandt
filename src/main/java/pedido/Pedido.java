package pedido;

import exception.ItemNaoEncontradoException;
import produto.Shake;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pedido{

    private int id;
    private Map<Shake, ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, Collection<ItemPedido> itens, Cliente cliente){
        this.id = id;
        this.itens=new LinkedHashMap<>(itens.stream()
                                            .collect(Collectors.toMap(ItemPedido::getShake,
                                                                    itemPedido -> itemPedido)));
        this.cliente=cliente;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens.values());
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        return itens.values()
                .stream()
                                        .map(pedido -> {
                                                        final var shake = pedido.getShake();
                                                        final var adicionais = shake.getAdicionais();
                                                        final var precoBase = cardapio.buscarPreco(shake.getBase());
                                                        final var precoAdicionais = adicionais.stream()
                                                                                                        .map(cardapio::buscarPreco)
                                                                                                        .reduce(0.0, Double::sum);
                                                        final var acrescimo = shake.getTipoTamanho().multiplicador * precoBase;
                                                        final var valorTotalShake = precoBase + acrescimo + precoAdicionais;
                                                        return valorTotalShake * pedido.getQuantidade();
                                        })
                                        .reduce(0.0, Double::sum);
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        final var shake = itemPedidoAdicionado.getShake();
        final var itemExistente = itens.get(shake);

        if (itemExistente != null){
            final var quantidadeFinal = itemExistente.getQuantidade() + itemPedidoAdicionado.getQuantidade();
            itemExistente.setQuantidade(quantidadeFinal);
            itens.put(shake, itemExistente);
        }else {
            itens.put(shake, itemPedidoAdicionado);
        }
    }

    public void removeItemPedido(ItemPedido itemPedidoRemovido) throws ItemNaoEncontradoException{
        final var shake = itemPedidoRemovido.getShake();
        final var itemExistente = itens.get(shake);

        if (itemExistente == null){
            throw new ItemNaoEncontradoException();
        }

        var quantidade = itemExistente.getQuantidade();

        if (quantidade > 1){
            itemExistente.setQuantidade(quantidade - 1);
            itens.put(shake, itemExistente);
        }else{
            itens.remove(shake);
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
