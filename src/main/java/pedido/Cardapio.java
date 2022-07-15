package pedido;

import exception.IngredienteNaoEncontradoException;
import exception.PrecoInvalidoException;
import ingredientes.Ingrediente;

import java.util.Map;
import java.util.TreeMap;

public class Cardapio {
    private final Map<Ingrediente<?>,Double> precos;

    public Cardapio(){
        this.precos = new TreeMap<>();
    }

    public Map<Ingrediente<?>, Double> getPrecos(){
        return this.precos;
    }

    public void adicionarIngrediente(Ingrediente<?> ingrediente,Double preco) throws PrecoInvalidoException{
        validarPreco(preco);
        precos.put(ingrediente, preco);
    }

    public void atualizarIngrediente(Ingrediente<?> ingrediente,Double preco) throws PrecoInvalidoException, IngredienteNaoEncontradoException{
        validarPreco(preco);

        final var isIngredienteAtualizado = precos.replace(ingrediente, buscarPreco(ingrediente), preco);
        if (!isIngredienteAtualizado){
            throw new IngredienteNaoEncontradoException();
        }
    }


    public void removerIngrediente(Ingrediente<?> ingrediente){
       final var isIngredienteRemovido = precos.remove(ingrediente, buscarPreco(ingrediente));
       if (!isIngredienteRemovido){
           throw new IngredienteNaoEncontradoException();
       }
    }

    public Double buscarPreco(Ingrediente<?> ingrediente) throws IngredienteNaoEncontradoException{
        final var preco = precos.get(ingrediente);

        if (preco != null){
            return preco;
        }
        
        throw new IngredienteNaoEncontradoException();
    }

    public void validarPreco(Double preco) throws PrecoInvalidoException{
        if (preco <= 0){
            throw new PrecoInvalidoException();
        }
    }

    @Override
    public String toString() {
        return this.precos.toString();
    }

}
