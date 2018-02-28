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
public class FincaRaiz extends Producto {
    
    public static final double IMPUESTO = 0.20;
    public static final String CATEGORIA = "Finca Raiz";

    public FincaRaiz(String nombre, double valor) {
        super(nombre, valor, CATEGORIA);
    }
    
    public static Producto Resolver(Producto prod)
    {
        if(prod.getCategoria().equals(CATEGORIA))
            return new FincaRaiz(prod.getNombre(), prod.getValor());
        else
            return Otro.Resolver(prod);
    }
    
    @Override
    public double total()
    {
        return this.getValor() * (1 + IMPUESTO);
    }
}
