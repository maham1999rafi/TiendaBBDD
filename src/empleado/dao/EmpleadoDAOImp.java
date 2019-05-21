
package empleado.dao;

import conexion.*;
import empleado.dominio.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO{

    @Override
    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados= new ArrayList<>();
        String query = "SELECT * FROM empleado";
        
        try (var conexion = ConexionBBDD.conectar();
            var sentencia = conexion.createStatement();
            var resultado = sentencia.executeQuery(query);){
            //capturar los resultados
            while(resultado.next()){
                var codigo = resultado.getInt("e_codigo");
                var nombre = resultado.getString("e_nombre");
                var apellido = resultado.getString("e_apellido");
                var password = resultado.getString("e_password");
                
                empleados.add(new Empleado(codigo, nombre, apellido, password));
            }
           
        } catch (SQLException e) {
            System.out.println("Error al leer los empleados");
        }
        return empleados;
    }
    
    @Override
    public Empleado obtenerEmpleado(int codigo) {
        Empleado empleado = null;
        String query = "SELECT * FROM empleado where e_codigo = " + codigo;

        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query)) {

            resultado.next();
            var code = resultado.getInt("e_codigo");
            var nombre = resultado.getString("e_nombre");
            var apellidos = resultado.getString("e_apellido");
            var password = resultado.getString("e_password");
            empleado = new Empleado(codigo, nombre, apellidos, password);

        } catch (SQLException e) {
            System.out.println("Error al cargar empleado con el codigo " + codigo);
        }
        return empleado;
    }

    @Override
    public boolean modificarContraseña(String contra, int codigo) {
        boolean modificado = false;
        String query = "UPDATE empleado set e_password=" + contra + " where e_codigo=" +codigo;
        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement()){ 
            
            var resultado = sentencia.executeUpdate(query);  
            modificado =true;  

        } catch (SQLException e) {
            System.out.println("Error al modificar la contraseña del empleado.");
        }   
        return modificado;
    }
    
}
