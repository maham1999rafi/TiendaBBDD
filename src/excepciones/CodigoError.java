
package excepciones;

public enum CodigoError {
    ERROR_USUARIO_INCORRECTA(111),
    ERROR_CONTRA_INCORRECTA(222);
    
    private int codigo;
    
    private CodigoError(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigoError(){
        return codigo;
    }
}
