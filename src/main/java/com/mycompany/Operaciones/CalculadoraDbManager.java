/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Operaciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.sql.DataSource;

/**
 *
 * @author georg
 */
public class CalculadoraDbManager {
    Connection con = null;
    private final String jndi = "jndi/calculadora";
    
    public Connection conectarse()
    {        
        try {
            InitialContext icontext = new InitialContext();
            Context context = (Context)icontext.lookup("java:comp/env");
            DataSource data = (DataSource)context.lookup(jndi);
            if(data != null)
            {
                 this.con = data.getConnection();
            }
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(CalculadoraDbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.con;
    }
}
