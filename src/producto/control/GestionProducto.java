package producto.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import producto.dominio.Producto;
import util.Color;


public class GestionProducto {
    
    private static ControladorProducto controlador;
    private static Producto productoAutenticado;

    public GestionProducto() {
        controlador = new ControladorProducto();
        productoAutenticado = null;
    }
    
    public void listarProductos(){
        List<Producto> productos = new ArrayList<>();
        productos = controlador.leerProducto();
        for (Producto producto : productos) {
            System.out.printf("%d %s %s %.2f", 
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getDescripcion(),
                    producto.getPrecio());
        } 
    }
    
    public int modificarProducto(){
        Scanner scan = new Scanner(System.in);
        System.out.println("******************************************************");
        listarProductos();
        System.out.println("******************************************************");
        System.out.println("Introduzca el codigo del producto que desea modificar");
        while(!scan.hasNextInt()){
            System.out.println(Color.ERROR + "Debe escribir un valor numerico" + Color.DEFAULT);
            System.out.println("Introduzca el codigo del producto que desea modificar");
        }
        int codigoEntrada = scan.nextInt();
        
        return codigoEntrada;
        
    }
    public void modificarProductoPorCodigo(int codigo){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el nuevo codigo del producto");
        while(!scan.hasNextInt()){
            System.out.println(Color.ERROR + "Debe escribir un valor numerico" + Color.DEFAULT);
            System.out.println("Introduzca el nuevo codigo del producto");
        }
        int codigoEntrada = scan.nextInt();
        var actualizacionOK = controlador.modificarProductoCodigo(codigo, codigoEntrada);
        if(actualizacionOK){
            System.out.println("Se ha cambiado el codigo del producto");
        } else{
            System.out.println("No se ha podido cambiado el codigo del producto");
        }
        
    }
    
    public void modificarProductoPorNombre(int codigo){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el nuevo nombre del producto");
        while(!scan.hasNext()){
            System.out.println(Color.ERROR + "Debe ser un nombre valido" + Color.DEFAULT);
            System.out.println("Introduzca el nuevo nombre del producto");
        }
        String nombre = scan.next();
        var actualizacionOK = controlador.modificarProductoNombre(nombre, codigo);
        if(actualizacionOK){
            System.out.println("Se ha cambiado el nombre del producto");
        } else{
            System.out.println("No se ha podido cambiado el nombre del producto");
        }
    }
    
    public void modificarProductoPorPrecio(int codigo){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el nuevo precio del producto");
        while(!scan.hasNextDouble()){
            System.out.println(Color.ERROR + "Debe ser un valor numerico" + Color.DEFAULT);
            System.out.println("Introduzca el nuevo precio del producto");
        }
        double precio = scan.nextDouble();
        var actualizacionOK = controlador.modificarProductoPrecio(precio, codigo);
        if(actualizacionOK){
            System.out.println("Se ha cambiado el precio del producto");
        } else{
            System.out.println("No se ha podido cambiado el precio del producto");
        }
    }
    
    public void hacerPedido(List<Producto> cesta){
        cesta = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean esProductoValido = false;
        listarProductos();
        System.out.println("Intriduzca el codigo del producto que desea añadir a la cesta");
        while(!scan.hasNextInt()){
            System.out.println(Color.ERROR + "Debe escribir un valor numerico" + Color.DEFAULT);
            System.out.println("Introduzca el codigo del producto que desea añadir a la cesta");
        }
        int codigoEntrada = scan.nextInt();
        productoAutenticado = controlador.obtenerProducto(codigoEntrada);
        cesta.add(productoAutenticado);   
    }
    
    public double precioTotalCesta(List<Producto> lista){
        double total = 0;
        for (Producto producto : lista) {
            total += producto.getPrecio();
        }
        return total;
    }
    
}
