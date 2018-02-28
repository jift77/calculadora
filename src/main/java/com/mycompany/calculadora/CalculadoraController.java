/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora;

import com.mycompany.Entities.CanastaFamiliar;
import com.mycompany.Entities.FincaRaiz;
import com.mycompany.Entities.Otro;
import com.mycompany.Entities.Producto;
import com.mycompany.Entities.Tecnologia;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author georg
 */
@Path("/calculadora")
public class CalculadoraController {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void InsertarProducto(Producto pro)
    {
        Producto prod = Tecnologia.resolver(pro);
        prod.total();
    }
   
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Categoria> ObtenerCategorias() {
        List<Categoria> cat = new ArrayList<>();
        cat.add(new Categoria(CanastaFamiliar.CATEGORIA, CanastaFamiliar.IMPUESTO));
        cat.add(new Categoria(FincaRaiz.CATEGORIA, FincaRaiz.IMPUESTO));
        cat.add(new Categoria(Otro.CATEGORIA, Otro.IMPUESTO));
        cat.add(new Categoria(Tecnologia.CATEGORIA, Tecnologia.IMPUESTO));
        return cat;
    }
}
