/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Operaciones;

import com.mycompany.Entities.Producto;
import com.mycompany.Interfaces.IOperProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author georg
 */
public class OperProducto implements IOperProducto {
    
    CalculadoraDbManager db = null;
    
    public OperProducto()
    {
        db = new CalculadoraDbManager();
    }

    @Override
    public void InsertarProducto(Producto prod) throws Exception{
        try {
            Connection con = db.conectarse();
            if(con != null)
            {
                PreparedStatement ps = con.prepareStatement("INSERT INTO producto (nombre, categoria, precio) values (?, ? ,?)");
                ps.setString(1, prod.getNombre());
                ps.setString(2, prod.getCategoria());
                ps.setDouble(3, prod.total());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperProducto.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
}
