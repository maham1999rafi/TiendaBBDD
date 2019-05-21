package empleado.dao;

import empleado.dominio.Empleado;
import java.util.List;

public interface EmpleadoDAO {

    List<Empleado> leerEmpleados();

    Empleado obtenerEmpleado(int codigo);

    boolean modificarContraseña(String contra, int codigo);

}
