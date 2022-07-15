package pedido;

import ingredientes.Ingrediente;

import java.util.Map;
import java.util.TreeMap;

public class Cardapio {
    private TreeMap<Ingrediente,Double> precos;

    public Cardapio(){
        this.precos= new TreeMap<>();
    }

    public TreeMap<Ingrediente, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente ingrediente,Double preco){
        if(preco <= 0)
            throw new IllegalArgumentException("Preço inválido");
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        if(!precos.containsKey(ingrediente))
            throw new IllegalArgumentException("Ingrediente não existe no cardapio");
        precos.replace(ingrediente, preco);
        return true;
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
        boolean foiRemovido = false;

        for(Ingrediente item : this.precos.keySet()) {
            if (item.equals(ingrediente)) {
                this.precos.remove(ingrediente);
                foiRemovido = true;
            }
        }

        if (foiRemovido) {
            return true;
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio");
        }
    }

    public Double buscarPreco(Ingrediente ingrediente){
        Double precoEncontrado = null;

        for(Map.Entry<Ingrediente, Double> entry : this.precos.entrySet()) {
            Ingrediente ingrediente1 = entry.getKey();
            Double preco = entry.getValue();
            if (ingrediente1.equals(ingrediente)) {
                precoEncontrado = preco;
            }
        }

        if (precoEncontrado != null) {
            return precoEncontrado;
        } else {
            throw new IllegalArgumentException("Ingrediente nao existe no cardapio");
        }
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
