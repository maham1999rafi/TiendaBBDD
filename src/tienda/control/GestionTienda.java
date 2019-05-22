package tienda.control;

import empleado.control.GestionEmpleados;
import empleado.dominio.Empleado;
import factura.Factura;
import java.util.ArrayList;
import java.util.List;
import producto.control.GestionProducto;
import producto.dominio.Producto;
import tienda.vista.*;

public class GestionTienda {

    private Empleado empleadoAutenticado;
    private List<Producto> cesta;
    private GestionEmpleados gestionEmpleados;
    private GestionProducto gestionProductos;
    private Factura factura;

    public GestionTienda() {
        empleadoAutenticado = null;
        cesta = new ArrayList<>();
        gestionEmpleados = new GestionEmpleados();
        gestionProductos = new GestionProducto();
        factura = new Factura(cesta, empleadoAutenticado);
    }

    public void iniciar() {
        boolean continuarAplicacion = true;
        while (continuarAplicacion) {
            boolean esLoginCorrecto = false;
            while (!esLoginCorrecto) {
                try {
                    gestionEmpleados.login();
                    esLoginCorrecto = true;
                } catch (excepciones.UsuarioIncorrectoException eU) {
                    System.out.println(eU.getMessage());
                    System.out.println("Causa: " + eU.getCause());
                    System.out.println("Codigo: " + eU.getCodigoError());
                } catch (excepciones.ContraIncorrectaException eC) {
                    System.out.println(eC.getMessage());
                    System.out.println("Causa: " + eC.getCause());
                    System.out.println("Codigo: " + eC.getCodigoError());
                }
            }
            empleadoAutenticado = gestionEmpleados.getEmpleadoAutenticado();
            System.out.println("Bienvenido " + empleadoAutenticado.getNombre());

            //imprimir un menu principal
            boolean cerrarSesion = false;
            while (cerrarSesion) {
                switch (VistaTienda.elegirMenuPrincipal()) {

                    case HACER_PEDIDO:
                        boolean terminarPedido = false;
                        while (!terminarPedido) {

                            //menu de hacer pedido
                            switch (VistaTienda.elegirMenuPedirProducto()) {
                                case AÑADIR_PRODUCTO_A_LA_CESTA:
                                    gestionProductos.hacerPedido(cesta);
                                    break;
                                case VISUALIZAR_PRECIO_TOTAL_DE_LA_CESTA:
                                    gestionProductos.precioTotalCesta(cesta);
                                    break;
                                case IMPRIMIR_FACTURA:
                                    factura.imprimir();
                                    factura.guardar();
                                    break;
                                case TERMINAR_PEDIDO:
                                    terminarPedido = true;
                                    break;
                            }
                        }
                        break;

                    case MODIFICAR_PRODUCTO:
                        int codigoProducto = gestionProductos.modificarProducto();

                        //menu modificar codigo
                        switch (VistaTienda.elegirMenuModificarProducto()) {
                            case MODIFICAR_CODIGO:
                                gestionProductos.modificarProductoPorCodigo(codigoProducto);
                                break;
                            case MODIFICAR_NOMBRE:
                                gestionProductos.modificarProductoPorNombre(codigoProducto);
                                break;
                            case MODIFICAR_PRECIO:
                                gestionProductos.modificarProductoPorPrecio(codigoProducto);
                                break;
                            default:
                                System.out.println("Porfavor elige una opcion valida");
                        }
                        break;

                    case CAMBIAR_CONTRA:
                        gestionEmpleados.cambiarContraseña();
                        break;

                    case CERRAR_SESION:
                        empleadoAutenticado = null;
                        cerrarSesion = true;
                        break;
                }
            }
        }
    }
}
