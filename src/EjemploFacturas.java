import org.CCristian.AppFacturas.modelo.*;

import javax.swing.*;
import java.util.Scanner;

public class EjemploFacturas {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("1234-56789");
        cliente.setNombre("Cristian Cristaldo");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la descripción de la factura: ");
        Factura factura = new Factura(scanner.nextLine(),cliente);

        Producto producto;

        for (int i = 0; i < 5; i++) {
            producto = new Producto();

            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            producto.setNombre(scanner.nextLine());

            System.out.print("Ingrese el precio del producto: ");
            producto.setPrecio(scanner.nextFloat());

            System.out.print("Ingrese la cantidad del producto: ");

            factura.addItemFactura(new ItemFactura(scanner.nextInt(),producto));

            System.out.println();
            scanner.nextLine();
        }

        System.out.println(factura);

    }
}
