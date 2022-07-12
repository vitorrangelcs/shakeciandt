package exception;

public class PrecoInvalidoException extends IllegalArgumentException {
    private static final String msg = "Preco invalido.";
    public PrecoInvalidoException() {
        super(msg);
    }
}
