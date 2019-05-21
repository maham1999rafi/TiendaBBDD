
package empleado.control;

import java.util.Scanner;
import empleado.dominio.Empleado;
import excepciones.CodigoError;
import util.Color;

public class GestionEmpleados {
    
    private ControladorDeEmpleado controlador;
    private Empleado empleadoAutenticador;

    public GestionEmpleados() {
        controlador = new ControladorDeEmpleado();
        empleadoAutenticador = null;
    }
    
    public void login(){
        Scanner scan = new Scanner(System.in);
        boolean esEmpleadoValido = false;
        boolean esPasswordValido = false;
        
        System.out.println("Bienvenido a la tienda");
        System.out.println("****************************************");
        
        System.out.print("Introduzca el codigo de tu usuario");
        while(!scan.hasNextInt()){
            System.out.print(Color.ERROR + "Debe escribir un valor numerioco" + Color.DEFAULT);
            System.out.print("Introduzca el codigo de tu usuario: ");
        }
        int codigoEntrada = scan.nextInt();
        
        System.out.print("Introduzca tu contra: ");
        String passwordEntrada = scan.next();
        
        System.out.println("***********************************************");
        System.out.println("");
        empleadoAutenticador = controlador.obtenerEmpleado(codigoEntrada);
        
        if(empleadoAutenticador != null){
            esEmpleadoValido = true;
            if(passwordEntrada.equals(empleadoAutenticador.getPassword())){
                esPasswordValido = true;
            }
        }
        if (!esEmpleadoValido){
           throw new excepciones.UsuarioIncorrectoException("Usuario incorrecto", CodigoError.ERROR_CONTRA_INCORRECTA);
            
        }
        else if (!esPasswordValido){
            throw new excepciones.ContraIncorrectaException("Contraseña incorrecta", CodigoError.ERROR_CONTRA_INCORRECTA);
            
        }
        
    }
    
    public Empleado getEmpleadoAutenticado() {
        return empleadoAutenticador;
    }
    
    
    public void cambiarContraseña(){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca nueva contraseña");
        while(!scan.hasNext()){
            System.out.println(Color.ERROR + "debe ser valida" + Color.DEFAULT);
            System.out.println("Introduzca nueva contraseña");
        }
        String contra = scan.next();
        var actualizacionOK = controlador.modificarContra(contra, empleadoAutenticador.getCodigo());
        if(actualizacionOK){
            System.out.println("Se ha cambiado la contraseña correctamente");
        } else{
            System.out.println("No se ha podido cambiado la contraseña");
        }
        
    }

}
