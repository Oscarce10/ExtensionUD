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
import modelo.dao.FormacionDAO;

/**
 *
 * @author USER
 */
public class FormacionDTO {
    
    private int id;
    private String Formacion;
    private FormacionDAO dao;
    private static final ConexionMysql con = ConexionMysql.getInstance();

    public FormacionDTO(int id, String Formacion) {
        this.id = id;
        this.Formacion = Formacion;
        dao = new FormacionDAO(id, Formacion);        
    }

    public FormacionDTO() {
        dao = new FormacionDAO();  
    }

    public int getId() {
        return id;
    }

    public String getFormacion() {
        return Formacion;
    }
    
    public ArrayList<FormacionDTO> consultar(){
        ArrayList<FormacionDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultar());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                FormacionDTO ob = new FormacionDTO(rs.getInt(1), rs.getString(2));
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
