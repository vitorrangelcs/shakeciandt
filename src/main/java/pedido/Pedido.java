package pedido;

import ingredientes.Adicional;
import produto.Shake;

import java.util.ArrayList;

public class Pedido {

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
        double total= 0.0;
        for (ItemPedido item:itens) {
            Shake shake = item.getShake();
            double base = cardapio.buscarPreco(shake.getBase()) * (shake.getTipoTamanho().multiplicador);
            double adicionaTotal = 0.0;
            if (shake.getAdicionais() != null) {
                for (Adicional adicional : shake.getAdicionais()) {
                    adicionaTotal += cardapio.buscarPreco(adicional);
                }
            }
            total += (base + adicionaTotal) * item.getQuantidade();
        }
        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        for (ItemPedido item:itens) {
            if (item.getShake().equals(itemPedidoAdicionado.getShake())) {
                item.setQuantidade(item.getQuantidade() + itemPedidoAdicionado.getQuantidade());
                return;
            }
        }

        this.itens.add(itemPedidoAdicionado);
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {

        boolean foiRemovido = this.itens.remove(itemPedidoRemovido);

        if (foiRemovido) {
            return true;
        } else {
            throw new IllegalArgumentException("Item nao existe no pedido.");
        }
    }

    @Override
    public String toString() {
        return this.itens + " - " + this.cliente;
    }
}
