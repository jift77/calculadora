/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entities;

/**
 *
 * @author georg
 */
public class Producto {
    
    private String Nombre;
    private double Valor;
    private String Categoria;
    
    public Producto() {}
    
    public Producto(String nombre, double valor, String categoria)
    {
        this.Nombre = nombre;
        this.Valor = valor;
        this.Categoria = categoria;
    }
    
    public double total()
    {
        return this.getValor();
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return Categoria;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
}
