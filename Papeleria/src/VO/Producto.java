/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author 57310
 */
public class Producto {
    private int codigo;
    private String categoria;
    private String descripcion;
    private Integer valor;
    private Integer stock;

    public Producto() {
    }

    public Producto(int codigo, String categoria, String descripcion, Integer valor, Integer stock) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.valor = valor;
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "**Informacion Del Producto " + "Codigo:" + codigo + "** \nCategoria    ---> " + categoria + "\ndescripcion --> " + descripcion +"\nPrecio   --->" + valor ;
    }
    
}
