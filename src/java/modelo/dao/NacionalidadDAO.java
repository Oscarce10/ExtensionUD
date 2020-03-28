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
public class NacionalidadDAO {    
    private int id;
    private String nacionalidad;

    public NacionalidadDAO() {
    }

    public NacionalidadDAO(int id, String nacionalidad) {
        this.id = id;
        this.nacionalidad = nacionalidad;
    }
    
    public String consultar(){
        return "SELECT * FROM nacionalidad;";
    }
    
}
