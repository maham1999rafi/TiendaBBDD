
package producto.control;

import java.util.List;
import producto.dao.*;
import producto.dominio.Producto;

public class ControladorProducto {
    
    public List<Producto> leerProducto(){
        ProductoDAO productoDAO = new ProductoDAOImp();
        return productoDAO.leerProductos();
    }
    
    public Producto obtenerProducto(int codigo){
        ProductoDAO productoDAO = new ProductoDAOImp();
        return productoDAO.obtenerProducto(codigo);
    }
    
    public boolean modificarProductoCodigo(int codigoOld, int codigoNew){
        ProductoDAO productoDAO = new ProductoDAOImp();
        return productoDAO.modificarProductoCodigo(codigoOld, codigoNew);
    }
    
    public boolean modificarProductoNombre(String nombre, int codigo){
        ProductoDAO productoDAO = new ProductoDAOImp();
        return productoDAO.modificarProductoNombre(nombre, codigo);
    }
    
    public boolean modificarProductoPrecio(double precio, int codigo){
        ProductoDAO productoDAO = new ProductoDAOImp();
        return productoDAO.modificarProductoPrecio(precio, codigo);
    }
    

}
//    public boolean actualizarProducto(Producto productos){
//        ProductoDAO productoDAO = new ProductoDAOImp();
//        return productoDAO.actualizarProducto(productos);
//    }