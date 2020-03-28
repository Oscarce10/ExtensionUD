/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author USER
 */
public class FormacionDAO {
    
     private int id;
     private String Formacion;

    public FormacionDAO(int id, String Formacion) {
        this.id = id;
        this.Formacion = Formacion;
    }

     public FormacionDAO() {
     }
    
    
    
    public String consultar(){
        return "SELECT * FROM formacion;";
    }
}
