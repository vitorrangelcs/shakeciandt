package exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException{
    private static final String msg = "Ingrediente nao existe no cardapio.";

    public IngredienteNaoEncontradoException() {
        super(msg);
    }
}
