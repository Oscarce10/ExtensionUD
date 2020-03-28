/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.NacionalidadDAO;

/**
 *
 * @author USER
 */
public class NacionalidadDTO {
    
    private int id;
    private String nacionalidad;
    private NacionalidadDAO dao;
    private static final ConexionMysql con = ConexionMysql.getInstance();

    public NacionalidadDTO(int id, String nacionalidad) {
        this.id = id;
        this.nacionalidad = nacionalidad;
        dao = new NacionalidadDAO(id, nacionalidad);        
    }

    public NacionalidadDTO() {
        dao = new NacionalidadDAO();  
    }

    public int getId() {
        return id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public ArrayList<NacionalidadDTO> consultar(){
        ArrayList<NacionalidadDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultar());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                NacionalidadDTO ob = new NacionalidadDTO(rs.getInt(1), rs.getString(2));
                lista.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NacionalidadDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return lista;
    }
        
    
}
