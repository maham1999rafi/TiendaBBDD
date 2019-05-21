package tienda.vista;

import java.util.Scanner;
import util.Color;

public class VistaTienda {
    
    
    public static MenuPrincipal elegirMenuPrincipal(){
        
            System.out.println("Menu Principal -------------------------");
            System.out.println("  1. Hacer pedido");
            System.out.println("  2. Modificar producto");
            System.out.println("  3. Cambiar contraseña a empleado");
            System.out.println("  4. Cerrar sesion");
            System.out.println("--------------------------------------");
        
            
            int opcion = pedirOpcionRango(1, 4);
            MenuPrincipal menu = null;

            switch(opcion){
                case 1:
                    menu = MenuPrincipal.HACER_PEDIDO;
                    break;
                case 2:
                    menu = MenuPrincipal.MODIFICAR_PRODUCTO;
                    
                    break;
                case 3:
                    menu = MenuPrincipal.CAMBIAR_CONTRA;
                    break;
                case 4:
                    menu = MenuPrincipal.CERRAR_SESION;
                    break;
                default:
                    System.out.println("Porfavor eliga una opcion valida");
            }
        return menu;               
    }
    public static MenuPedirProducto elegirMenuPedirProducto(){
        System.out.println("Hacer pedido ---------------------------");
        System.out.println(" 1.1 Añadir producto a la cesta");
        System.out.println(" 1.2 Visualizar precio total de la cesta");
        System.out.println(" 1.3 Imprimir factura");
        System.out.println(" 1.4 Terminar pedido");
        System.out.println("----------------------------------------------");
        
        int opcion = pedirOpcionRango(4, 1);
        MenuPedirProducto menu = null;
        
        switch(opcion){
            case 1:
                menu = MenuPedirProducto.AÑADIR_PRODUCTO_A_LA_CESTA;
                break;
            case 2:
                menu = MenuPedirProducto.VISUALIZAR_PRECIO_TOTAL_DE_LA_CESTA;
                break;
            case 3:
                menu = MenuPedirProducto.IMPRIMIR_FACTURA;
                break;
            case 4:
                menu = MenuPedirProducto.TERMINAR_PEDIDO;
                break;
            default:
                System.out.println("Porfavor elige una opcion valida");       
        }
        return menu;      
    }
    
    public static MenuModificarProducto elegirMenuModificarProducto(){
        
        System.out.println("Modificar producto ---------------------------");
        System.out.println(" 2.1 Modificar nombre de producto");
        System.out.println(" 2.2 Modificar precio de producto");
        System.out.println(" 2.3 Modificar codigo de producto");
        System.out.println("----------------------------------------------");
        
        int opcion = pedirOpcionRango(3, 1);
        MenuModificarProducto menu = null;
        
        switch(opcion){
            case 1: 
                menu = MenuModificarProducto.MODIFICAR_CODIGO;
                break;
            case 2:
                menu = MenuModificarProducto.MODIFICAR_NOMBRE;
                break;
            case 3:
                menu = MenuModificarProducto.MODIFICAR_PRECIO;
                break;
            default:
                System.out.println("Porfavor elige una opcion valida");
        }
        return menu;
    }
    
    public static void muestraMensaje(String mensaje, Color color){
        System.out.println(color + mensaje + Color.DEFAULT);
    }
    
    public static void muestraMensaje(String mensaje){
        muestraMensaje(mensaje, Color.DEFAULT);
    }
    
    private static int pedirOpcionRango(int max, int min){
        Scanner scan = new Scanner(System.in);
        boolean hayError = false;
        int opcion =0;
        
        while(!hayError){
            System.out.println("Selecione una opcion: ");
            if(scan.hasNextInt()){
                opcion = scan.nextInt();
                hayError = opcion < min || opcion > max;
                if(hayError){
                    muestraMensaje("Error, opcion no valida. Debe ser entre [" + min + max + "]");
                }
            } else {
                muestraMensaje("Error, opcion no valida. Debe ser entre [" + min + max + "]");
                scan.next();
            }       
        }
        return opcion;
    }
    
    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
