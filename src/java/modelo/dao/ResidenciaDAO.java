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
public class ResidenciaDAO {
    private int id;
    private String Residencia;

    public ResidenciaDAO(int id, String Residencia) {
        this.id = id;
        this.Residencia = Residencia;
    }
    
    public ResidenciaDAO() {
    }

   
    
    public String consultar(){
        return "SELECT * FROM ciudad_residencia;";
    }

    
    
}
