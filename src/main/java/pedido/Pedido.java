package pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pedido{

    private int id;
    private  ArrayList<ItemPedido> itens;
    private Cliente cliente;

    public Pedido(int id, ArrayList<ItemPedido> itens,Cliente cliente){
        this.id = id;
        this.itens=itens;
        this.cliente=cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public int getId(){
        return this.id;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public double calcularTotal(Cardapio cardapio){
        return cardapio.getPrecos()
                .values()
                .stream()
                .mapToDouble(v -> v)
                .sum();
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        if (!itens.isEmpty()) {
            for (int i = 0; i < itens.size(); i++) {
                ItemPedido item = itens.get(i);
                if (item.getShake() == itemPedidoAdicionado.getShake()){
                    item.setQuantidade(itemPedidoAdicionado.getQuantidade());
                }
                else {
                    itens.add(new ItemPedido(itemPedidoAdicionado.getShake(), itemPedidoAdicionado.getQuantidade()));
                }
            }
        }
        else {
           itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        //substitua o true por uma condição
        if (true) {
            //TODO
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
        return false;
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
