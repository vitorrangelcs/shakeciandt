package exception;

public class ItemNaoEncontradoException extends IllegalArgumentException{
    private static String msg = "Item nao existe no pedido.";
    public ItemNaoEncontradoException() {
        super(msg);
    }
}
