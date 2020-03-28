/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.CoordinadorDTO;
import modelo.dto.NacionalidadDTO;

/**
 *
 * @author USER
 */
public class pruebas {
    
    public static final ConexionMysql con = ConexionMysql.getInstance();
    
    
   
    
    public static void main(String[] args) {
        ArrayList<NacionalidadDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement("SELECT * FROM nacionalidad");
            System.out.println(ps.toString());
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
