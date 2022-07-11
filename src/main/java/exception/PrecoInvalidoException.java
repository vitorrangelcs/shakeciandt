package exception;

public class PrecoInvalidoException extends IllegalArgumentException {
    private static String msg = "Preco invalido.";
    public PrecoInvalidoException() {
        super(msg);
    }
}
