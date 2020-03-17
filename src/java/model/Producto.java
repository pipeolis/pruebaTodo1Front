/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author felip
 */
public class Producto {
    private int idProducto;	
	
    private int idTipo;
    private int idOrigen;
    private String descripcion;
    private Double porcVenta;
    private String origen;
    private String tipo;

    public int getIdProducto() {
            return idProducto;
    }
    public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
    }
    public int getIdTipo() {
            return idTipo;
    }
    public void setIdTipo(int idTipo) {
            this.idTipo = idTipo;
    }
    public String getDescripcion() {
            return descripcion;
    }
    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }

    public Double getPorcVenta() {
            return porcVenta;
    }
    public void setPorcVenta(Double porcVenta) {
            this.porcVenta = porcVenta;
    }

    public int getIdOrigen() {
            return idOrigen;
    }
    public void setIdOrigen(int idOrigen) {
            this.idOrigen = idOrigen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }       
        
}
