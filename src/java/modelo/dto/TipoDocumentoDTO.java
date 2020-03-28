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
import modelo.dao.TipoDocumentoDAO;

/**
 *
 * @author USER
 */
public class TipoDocumentoDTO {
    
    private int id;
    private String documento;
    private TipoDocumentoDAO dao;
    private static final ConexionMysql con = ConexionMysql.getInstance();

    public TipoDocumentoDTO(int id, String documento) {
        this.id = id;
        this.documento = documento;
        dao = new TipoDocumentoDAO(id, documento);        
    }

    public TipoDocumentoDTO() {
        dao = new TipoDocumentoDAO();  
    }

    public int getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }
    
    public ArrayList<TipoDocumentoDTO> consultar(){
        ArrayList<TipoDocumentoDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultar());
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                TipoDocumentoDTO ob = new TipoDocumentoDTO(rs.getInt(1), rs.getString(2));
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
