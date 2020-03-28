/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import conexion.ConexionMysql;
import hash.Pbkdf2;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.AspiranteDAO;

/**
 *
 * @author USER
 */
public class AspiranteDTO extends Persona{
    
    private String numero_documento, celular, telefono_fijo, fecha_nacimiento, foto, descripcion, hoja_de_vida, profesion;	
    private int nacionalidad, tipo_documento, sexo, formacion, ciudad_residencia;
    private static final ConexionMysql con = ConexionMysql.getInstance();
    private AspiranteDAO dao;

    public AspiranteDTO() {
        super();        
        dao = new AspiranteDAO();
    }    

    public AspiranteDTO(String numero_documento, String celular, String telefono_fijo, String fecha_nacimiento, String foto, String descripcion, String hoja_de_vida, String profesion, int nacionalidad, int tipo_documento, int sexo, int formacion, int ciudad_residencia, AspiranteDAO dao, String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String clave, byte[] salt) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
        this.numero_documento = numero_documento;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.foto = foto;
        this.descripcion = descripcion;
        this.hoja_de_vida = hoja_de_vida;
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
        this.tipo_documento = tipo_documento;
        this.sexo = sexo;
        this.formacion = formacion;
        this.ciudad_residencia = ciudad_residencia;
        this.dao = dao;
    }

    

    public AspiranteDTO(String numero_documento, String celular, String telefono_fijo, int nacionalidad, int tipo_documento, int sexo, int formacion, int ciudad_residencia, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String clave) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, correo, clave);
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.numero_documento = numero_documento;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.nacionalidad = nacionalidad;
        this.tipo_documento = tipo_documento;
        this.sexo = sexo;
        this.formacion = formacion;
        this.ciudad_residencia = ciudad_residencia;
        this.salt = Pbkdf2.generateSalt();
        try {
            this.clave = Pbkdf2.generateHash(clave.toCharArray(), salt);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao = new AspiranteDAO(numero_documento, celular, telefono_fijo, nacionalidad, tipo_documento, sexo, formacion, ciudad_residencia, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, clave);
    }

    
    
    public AspiranteDTO(String correo) {
        super();       
        this.correo = correo;
        dao = new AspiranteDAO(correo);
    }  

    

    public String getNumero_documento() {
        return numero_documento;
    }

    public String getCelular() {
        return celular;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHoja_de_vida() {
        return hoja_de_vida;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public int getTipo_documento() {
        return tipo_documento;
    }

    public int getSexo() {
        return sexo;
    }

    public String getProfesion() {
        return profesion;
    }

    public int getFormacion() {
        return formacion;
    }

    public int getCiudad_residencia() {
        return ciudad_residencia;
    }

    @Override
    public String toString() {
        return "AspiranteDTO{" + "numero_documento=" + numero_documento + ", celular=" + celular + ", telefono_fijo=" + telefono_fijo + ", fecha_nacimiento=" + fecha_nacimiento + ", foto=" + foto + ", descripcion=" + descripcion + ", hoja_de_vida=" + hoja_de_vida + ", nacionalidad=" + nacionalidad + ", tipo_documento=" + tipo_documento + ", sexo=" + sexo + ", profesion=" + profesion + ", formacion=" + formacion + ", ciudad_residencia=" + ciudad_residencia + '}';
    }
    
    public boolean registrar(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.registrar());
            ps.setString(1, id);
            ps.setString(2, primerNombre);
            ps.setString(3, segundoNombre);
            ps.setString(4, primerApellido);
            ps.setString(5, segundoApellido);
            ps.setString(6, numero_documento);
            ps.setString(7, celular);
            ps.setString(8, telefono_fijo);
            ps.setString(9, correo);
            ps.setString(10, clave);
            ps.setBytes(11, salt);
            ps.setInt(12, tipo_documento);
            ps.setInt(13, nacionalidad);
            ps.setInt(14, ciudad_residencia);
            ps.setInt(15, sexo);
            ps.setInt(16, formacion);
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();            
        }
        return false;
    }
    
    public boolean consultarCorreo(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultarCorreo());
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
     
}
