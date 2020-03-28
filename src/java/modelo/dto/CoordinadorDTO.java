/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import conexion.ConexionMysql;
import hash.Pbkdf2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.CoordinadorDAO;

/**
 *
 * @author USER
 */
public class CoordinadorDTO extends Persona{
    
    private static final ConexionMysql con = ConexionMysql.getInstance();
    private CoordinadorDAO dao;

    public CoordinadorDTO() {
        super();
        dao = new CoordinadorDAO();
    }

    public CoordinadorDTO(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt,clave);
        dao = new CoordinadorDAO(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
    }

    public CoordinadorDTO(String correo, String clave) {
        super();
        this.correo = correo;
        this.clave = clave;
        this.dao = new CoordinadorDAO(correo, clave);
    }
    
     public CoordinadorDTO(String id) {
        super();
        this.id = id;
        this.dao = new CoordinadorDAO(id);
    }   
    
    
    public boolean crear(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.crear());
            ps.setString(1, this.id);
            ps.setString(2, primerNombre);
            ps.setString(3, segundoNombre);
            ps.setString(4, primerApellido);
            ps.setString(5, segundoApellido);
            ps.setString(6, correo);
            ps.setString(7, clave);
            ps.setBytes(8, salt);            
            if(ps.executeUpdate()>0){
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public CoordinadorDTO autenticar(){
        CoordinadorDTO coordinador = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.autenticar());
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = Pbkdf2.bytesToString(rs.getBytes(2));
                String primerNombre = rs.getString(3);
                String segundoNombre = rs.getString(4);
                String primerApellido = rs.getString(5);
                String segundoApellido = rs.getString(6);
                String correo = rs.getString(7);
                String clave = rs.getString(8);
                byte[] salt = rs.getBytes(9);
                coordinador = new CoordinadorDTO(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return coordinador;
    }
    
    public void consultar(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultar());
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.primerNombre = rs.getString(1);
                this.primerApellido = rs.getString(2);
                this.correo = rs.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        
    }
    
    public ArrayList<CoordinadorDTO> consultarTodos(){
        ArrayList<CoordinadorDTO> lista = null;
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultarTodos());
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CoordinadorDTO ob = new CoordinadorDTO(Pbkdf2.bytesToString(rs.getBytes(1)), 
                        rs.getString(2), rs.getString(3), "", rs.getString(5), rs.getString(6), "".getBytes(), "");
                lista.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordinadorDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
        
}
