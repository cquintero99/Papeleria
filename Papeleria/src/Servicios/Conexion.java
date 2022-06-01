/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 57310
 */
public class Conexion {
    private static Connection cn=null;
    public static Connection obtener() throws SQLException, CloneNotSupportedException{
        
            if(cn==null){
                try{
                    /*
                     Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost/museo","root","");
                    */
                    Class.forName("com.mysql.jdbc.Driver");
                    cn=DriverManager.getConnection("jdbc:mysql://localhost/papeleria","root","");
                    System.out.println("conecta");
                }catch(SQLException e){
                    System.out.println("E 1");
                    throw new SQLException(e);
                }catch(ClassNotFoundException e){
                    System.out.println("E 2");
                    throw new CloneNotSupportedException(e.getMessage());
                }
            }
            return cn;
       
    }
}
