/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aquí implementaremos el patrón Singleton, que permite obtener una objeto único de la clase ConexionMsql, se realiza de una
 * forma muy sencilla, dejando el constructor privado y creando un método estático y sincronizado para obtener la única instancia.
 * @author USER
 */
public class ConexionMysql {
    
    public static ConexionMysql instance; // singleton
    private Connection con;
    
    private ConexionMysql(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); // driver
            try{
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/extension", "root", "");
                System.out.println("Conexion establecida con BD");
            } catch (SQLException ex) {
                Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized ConexionMysql getInstance(){
        if(instance == null)
            instance = new ConexionMysql();
        
        return instance;
    }
    
    public Connection getCon(){
        return this.con;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
    
}