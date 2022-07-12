package exception;

public class ItemNaoEncontradoException extends IllegalArgumentException{
    private static final String MSG = "Item nao existe no pedido.";
    public ItemNaoEncontradoException() {
        super(MSG);
    }
}
