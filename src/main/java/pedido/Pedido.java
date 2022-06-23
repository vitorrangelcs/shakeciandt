package pedido;

import ingredientes.Adicional;
import java.util.ArrayList;

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
        double total= 0;
        double totalItemPedido;

        for(ItemPedido itemPedido:itens){
            totalItemPedido = 0;
            totalItemPedido+= cardapio.buscarPreco(itemPedido.getShake().getBase()) * itemPedido.getShake().getTipoTamanho().multiplicador ;
            for(Adicional adicional: itemPedido.getShake().getAdicionais())
                totalItemPedido+=cardapio.buscarPreco(adicional);
            totalItemPedido = totalItemPedido * itemPedido.getQuantidade();

            total += totalItemPedido;
        }

        return total;
    }

    public void adicionarItemPedido(ItemPedido itemPedidoAdicionado){
        if(this.itens.contains(itemPedidoAdicionado)){
            for(ItemPedido itemPedido:this.itens){
                if(itemPedidoAdicionado.equals(itemPedido))
                    itemPedido.setQuantidade(itemPedido.getQuantidade()+itemPedidoAdicionado.getQuantidade());
            }
        }
        else {
            itens.add(itemPedidoAdicionado);
        }
    }

    public boolean removeItemPedido(ItemPedido itemPedidoRemovido) {
        if (this.itens.contains(itemPedidoRemovido)) {
            for (ItemPedido itemPedido : this.itens) {
                if (itemPedidoRemovido.equals(itemPedido)) {
                    if (itemPedido.getQuantidade() - 1 == 0)
                        this.itens.remove(itemPedido);
                    else
                        itemPedido.setQuantidade(itemPedido.getQuantidade() - 1);
                    return true;
                }
            }
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