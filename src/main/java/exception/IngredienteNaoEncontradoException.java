package exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException{
    private static String msg = "Ingrediente nao existe no cardapio.";

    public IngredienteNaoEncontradoException() {
        super(msg);
    }
}
