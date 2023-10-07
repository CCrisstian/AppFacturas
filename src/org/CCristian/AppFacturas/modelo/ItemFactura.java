package org.CCristian.AppFacturas.modelo;

public class ItemFactura {
    //===========================================================//
    //--------------------ATRIBUTOS----------------------------//

    private int cantidad;
    private Producto producto;

    //===========================================================//
    //--------------------CONSTRUCTOR----------------------------//

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    //===========================================================//
    //--------------------MÉTODOS----------------------------//

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float CalcularImporte(){
        return (this.cantidad) * (this.producto.getPrecio());
    }

    @Override
    public String toString() {
        return producto.toString() +"\t"+ cantidad +"\t"+ CalcularImporte();
    }

    //===========================================================//
    //--------------------RELACIONES----------------------------//

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
