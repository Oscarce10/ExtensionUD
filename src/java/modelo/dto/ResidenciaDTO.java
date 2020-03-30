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
import modelo.dao.ResidenciaDAO;

/**
 *
 * @author USER
 */
public class ResidenciaDTO {
    
    private int id;
    private String Residencia;
    private ResidenciaDAO dao;
    private static final ConexionMysql con = ConexionMysql.getInstance();

    public ResidenciaDTO(int id, String Residencia) {
        this.id = id;
        this.Residencia = Residencia;
        dao = new ResidenciaDAO(id, Residencia);        
    }

    public ResidenciaDTO() {
        dao = new ResidenciaDAO();  
    }

    public int getId() {
        return id;
    }

    public String getResidencia() {
        return Residencia;
    }
    
    public ArrayList<ResidenciaDTO> consultar(){
        ArrayList<ResidenciaDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultar());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                ResidenciaDTO ob = new ResidenciaDTO(rs.getInt(1), rs.getString(2));
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
