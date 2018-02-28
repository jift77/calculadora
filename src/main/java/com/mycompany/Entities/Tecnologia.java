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
public class Tecnologia extends Producto {
    
    public static final double IMPUESTO = 0.19;
    public static final String CATEGORIA = "Tecnologia";

    public Tecnologia(String nombre, double valor) {
        super(nombre, valor, CATEGORIA);
    }
    
    public static Producto resolver(Producto prod)
    {
        if(prod.getCategoria().equals(CATEGORIA))
            return new Tecnologia(prod.getNombre(), prod.getValor());
        else
            return CanastaFamiliar.Resolver(prod);
    }
    
    @Override
    public double total()
    {
        return this.getValor() * (1 + IMPUESTO);
    }
}
