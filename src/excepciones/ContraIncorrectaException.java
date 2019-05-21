package excepciones;

public class ContraIncorrectaException extends RuntimeException{
    
    private int codigoError;

    public ContraIncorrectaException(String messaje) {
        super(messaje);
    }

    public ContraIncorrectaException(String messaje, Throwable cause) {
        super(messaje, cause);
    }

    public ContraIncorrectaException(String messaje, Throwable cause, CodigoError codigoError) {
        super(messaje, cause);
        this.codigoError = codigoError.getCodigoError();
    }

    public ContraIncorrectaException(String message, CodigoError codigoError) {
        super(message);
        this.codigoError = getCodigoError();
    }
    
    
    public int getCodigoError(){
        return codigoError;
    }
    
    
}
