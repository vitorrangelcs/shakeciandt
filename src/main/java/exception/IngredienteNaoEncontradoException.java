package exception;

public class IngredienteNaoEncontradoException extends IllegalArgumentException{
    private static final String MSG = "Ingrediente nao existe no cardapio.";

    public IngredienteNaoEncontradoException() {
        super(MSG);
    }
}
