package pedido;

import exception.IngredienteNaoEncontradoException;
import exception.PrecoInvalidoException;
import ingredientes.Ingrediente;

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
        validarPreco(preco);
        precos.put(ingrediente, preco);
    }

    public boolean atualizarIngrediente(Ingrediente ingrediente,Double preco){
        validarPreco(preco);
        return precos.replace(ingrediente, buscarPreco(ingrediente), preco);
    }

    public boolean removerIngrediente(Ingrediente ingrediente){
       return precos.remove(ingrediente, buscarPreco(ingrediente));
    }

    public Double buscarPreco(Ingrediente ingrediente){
        final var preco = precos.get(ingrediente);
        if (preco != null){
            return preco;
        }
        throw new IngredienteNaoEncontradoException();
    }

    public void validarPreco(Double preco){
        if (preco <= 0){
            throw new PrecoInvalidoException();
        }
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
