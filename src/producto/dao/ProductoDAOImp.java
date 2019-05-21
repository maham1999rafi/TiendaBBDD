package producto.dao;

import conexion.ConexionBBDD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;


public class ProductoDAOImp implements ProductoDAO{
    
    
    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        String quary = "SELECT * FROM producto";
        
        try (var conexion = ConexionBBDD.conectar();
            var sentencia = conexion.createStatement();
            var resultado = sentencia.executeQuery(quary);){
            //capturar los resultados
            while(resultado.next()){
                var codigo = resultado.getInt("p_codigo");
                var nombre = resultado.getString("p_nombre");
                var descripcion = resultado.getString("p_descripcion");
                var precio = resultado.getDouble("p_precio");
                
                productos.add(new Producto(codigo, nombre, descripcion, precio));
            }
           
        } catch (SQLException e) {
            System.out.println("Error al leer los productos");
        }

        return productos;
    }

    
    @Override
    public Producto obtenerProducto(int codigo) {
        Producto producto = null;
        String query = "SELECT * from producto where p_codigo =" + codigo;
        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query)) {

            resultado.next();
            var code = resultado.getInt("p_codigo");
            var nombre = resultado.getString("p_nombre");
            var descripcion = resultado.getString("p_descripcion");
            var precio = resultado.getDouble("p_precio");
            producto = new Producto(codigo, nombre, descripcion, precio);

        } catch (SQLException e) {
            System.out.println("Error al cargar producto con el codigo " + codigo);
        }
        return producto;   
    }

    
    @Override
    public boolean modificarProductoCodigo(int codigoOld, int codigoNew) {
        boolean modificado = false;
        String query = "UPDATE producto set p_codigo=" + codigoNew + " where p_codigo=" +codigoOld;
        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement()) { 
            
            var resultado = sentencia.executeUpdate(query);
            
            modificado = true;  

        } catch (SQLException e) {
            System.out.println("Error al modificar el codigo del producto.");
        }   
        return modificado;
    }

    
    @Override
    public boolean modificarProductoNombre(String nombre, int codigo) {
        boolean modificado = false;
        String query = "UPDATE producto set p_nombre=" + nombre + " where p_codigo=" +codigo;
        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement()) { 
            
            var resultado = sentencia.executeUpdate(query);
            
            modificado =true;  

        } catch (SQLException e) {
            System.out.println("Error al modificar el nombre del producto");
        }   
        return modificado; 
    }

   
    @Override
    public boolean modificarProductoPrecio(double precio, int codigo) {
        boolean modificado = false;
        String query = "UPDATE producto set p_precio=" + precio + " where p_codigo=" +codigo;
        try (
                var conexion = ConexionBBDD.conectar();
                var sentencia = conexion.createStatement()) { 
                var resultado = sentencia.executeQuery(query);
            modificado =true;  

        } catch (SQLException e) {
            System.out.println("Error al modificar el precio del producto");
        }   
        return modificado; 
    }


    
 
}
