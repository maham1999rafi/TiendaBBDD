package factura;

import empleado.dominio.Empleado;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import producto.dominio.Producto;

public class Factura implements FacturaDAO {

    private final List<Producto> productos;
    private final Empleado empleadoAutenticado;
    private double total;
    private final String facturaArchivo;

    public Factura(List<Producto> producto, Empleado empleadoAutenticado) {
        this.productos = producto;
        this.empleadoAutenticado = empleadoAutenticado;
        this.facturaArchivo = "factura.txt";
        this.total = 0;

    }

    @Override
    public void imprimir() {
        System.out.println("**********************************************************************************");
        System.out.println("Factura simplificada:");
        System.out.println("-------------------------------------------------------------------------------");
        for (Producto producto : productos) {

            System.out.format("%-15s%d%n%-15s%s%n%-15s%s%n%-15s%.2f%n%n",
                    "Código:", producto.getCodigo(),
                    "Nombre:", producto.getNombre(),
                    "Descripción:", producto.getDescripcion(),
                    "Precio:", producto.getPrecio());
        }
        System.out.println("-------------------------------------------------------------------------------");
        for (Producto producto : productos) {
            total = total + producto.getPrecio();
        }
        System.out.println("El precio TOTAL es:\t" + total + " €");
        System.out.println("Atendido por:\t\t" + empleadoAutenticado.getNombre());
        System.out.println("**********************************************************************************");

    }

    @Override
    public void guardar() {
        try ( var file = Files.newBufferedWriter(Paths.get(facturaArchivo), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            file.write(String.format("*****************************************************************************\n"));
            file.write(String.format("\t\t Factura Simlificada\n"));
            for (Producto producto : productos) {
                file.write(String.format("%-15s%d%n%-15s%s%n%-15s%s%n%-15s%.2f%n%n",
                        "Código:", producto.getCodigo(),
                        "Nombre:", producto.getNombre(),
                        "Descripción:", producto.getDescripcion(),
                        "Precio:", producto.getPrecio()));
            }
            file.write(String.format("*****************************************************************************\n"));
            for (Producto producto : productos) {
                total = total + producto.getPrecio();
            }
            file.write(String.format("El precio TOTAL es:\t" + total + " €El precio TOTAL es:\t" + total + " €\n"));
            file.write(String.format("Atendido por:\t\t" + empleadoAutenticado.getNombre()));
        } catch (IOException ex) {
            System.out.println("No se ha podido guardar el archivo " + facturaArchivo);
        }
    }

}
