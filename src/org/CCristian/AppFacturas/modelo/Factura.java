package org.CCristian.AppFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    //===========================================================//
    //--------------------ATRIBUTOS----------------------------//

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    //===========================================================//
    //--------------------CONSTRUCTOR----------------------------//

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    //===========================================================//
    //--------------------MÉTODOS----------------------------//

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float CalcularTotal(){
        float total = 0.0f;
        for (int i = 0; i < indiceItems;i++) {
            total += this.items[i].CalcularImporte();
        }
        return total;
    }

    public String GenerarDetalle(){
        SimpleDateFormat df = new SimpleDateFormat("dd'/'MMMM'/'yyyy");
        StringBuilder Detalle = new StringBuilder();

        Detalle.append("____________________________________________________________________________________________________________\n");

        Detalle.append("Factura N°: ").append(this.folio).append("\t\tFecha:").append(df.format(this.fecha)).append("\n")
                .append("Cliente: ").append(this.cliente.getNombre()).append("\n")
                .append("NIF: ").append(this.cliente.getNif()).append("\n")
                .append("Descripción: ").append(this.descripcion).append("\n").

        append("____________________________________________________________________________________________________________\n")

                .append("Código\tNombre\t\tPrecio\tCantidad\tImporte\n").

        append("____________________________________________________________________________________________________________\n");

        for (int i = 0; i < indiceItems; i++) {
            Detalle.append(this.items[i].toString()).append("\n");
        }

        Detalle.append("____________________________________________________________________________________________________________\n");

        Detalle.append("TOTAL: $").append(CalcularTotal());

        return Detalle.toString();
    }

    @Override
    public String toString() {
        return GenerarDetalle();
    }

    //===========================================================//
    //--------------------RELACIONES----------------------------//

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){
        if (indiceItems < MAX_ITEMS){
        this.items[indiceItems++] = item;
        }
    }
}
