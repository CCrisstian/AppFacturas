package org.CCristian.AppFacturas.modelo;

public class Producto {
    //===========================================================//
    //--------------------ATRIBUTOS----------------------------//

    private int codigo;
    private String nombre;
    private float precio;
    public static int UltimoCodigo;

    //===========================================================//
    //--------------------CONSTRUCTOR----------------------------//

    public Producto() {
        this.codigo = ++UltimoCodigo;
    }

    //===========================================================//
    //--------------------MÉTODOS----------------------------//

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t" + precio;
    }
}
