package pedido;

import produto.Shake;

public class ItemPedido {
    private Shake shake;
    private int quantidade;

    public ItemPedido(Shake shake, int quantidade) {
        this.shake = shake;
        this.quantidade = quantidade;
    }

    public Shake getShake() {
        return shake;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;

        ItemPedido that = (ItemPedido) o;

        return shake.equals(that.shake);
    }

    @Override
    public int hashCode() {
        return shake.hashCode();
    }

    @Override
    public String toString() {
        return this.shake + " / x" + this.quantidade;
    }
}