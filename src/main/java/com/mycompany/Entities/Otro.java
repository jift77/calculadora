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
public class Otro extends Producto{
 
    public static final double IMPUESTO = 0.09;
    public static final String CATEGORIA = "Otro";

    public Otro(String nombre, double valor) {
        super(nombre, valor, CATEGORIA);
    }
    
    public static Producto Resolver(Producto prod)
    {
        if(prod.getCategoria().equals(CATEGORIA))
            return new Otro(prod.getNombre(), prod.getValor());
        else
            return prod;
    }
    
    @Override
    public double total()
    {
        return this.getValor() * (1 + IMPUESTO);
    }
}
