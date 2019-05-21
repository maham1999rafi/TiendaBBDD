package excepciones;

public class UsuarioIncorrectoException extends RuntimeException{
    private int codigoError;
    
    public UsuarioIncorrectoException(String mensaje){
        super(mensaje);
    }
    
    public UsuarioIncorrectoException(String mensaje, Throwable causa){
        super(mensaje, causa);
    } 
    
    public UsuarioIncorrectoException(String mensaje, Throwable causa, CodigoError codigoError){
        super(mensaje, causa);
        this.codigoError = codigoError.getCodigoError();
    }

    public UsuarioIncorrectoException(String message, CodigoError codigoError) {
        super(message);
        this.codigoError = getCodigoError();
    }
    
    public int getCodigoError(){
        return codigoError;
    }
}
