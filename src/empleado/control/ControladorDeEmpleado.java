package empleado.control;

import empleado.dao.*;
import empleado.dominio.Empleado;
import java.util.List;


public class ControladorDeEmpleado {

    public List<Empleado> leerEmpleados(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImp();
        return empleadoDAO.leerEmpleados();
    }
    
    public Empleado obtenerEmpleado(int codigo){
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImp();
        return empleadoDAO.obtenerEmpleado(codigo);
    }
    
    public boolean modificarContra(String contra, int codigo){
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImp();
        return empleadoDAO.modificarContraseña(contra, codigo);
    }

    
}
