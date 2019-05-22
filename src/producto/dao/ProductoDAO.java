package producto.dao;

import java.util.List;
import producto.dominio.Producto;

public interface ProductoDAO {

    List<Producto> leerProductos();

    Producto obtenerProducto(int codigo);

    boolean modificarProductoCodigo(int codigoOld, int codigoNew);

    boolean modificarProductoNombre(String nombre, int codigo);

    boolean modificarProductoPrecio(double precio, int codigo);
    
    
}
