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
import java.util.ArrayList;
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

    public AspiranteDTO(String numero_documento, String foto, String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
        this.numero_documento = numero_documento;
        this.foto = foto;
    }

    public AspiranteDTO(String numero_documento, String id, String foto, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo) {
        this.id = id;
        this.numero_documento = numero_documento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.foto = foto;
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

    public AspiranteDTO(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
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
    
    public AspiranteDTO(String id) {
        super(id);        
        this.id = id;
        dao = new AspiranteDAO(id);
    }    

    
    
    public AspiranteDTO(String correo, String clave) {
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

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHoja_de_vida(String hoja_de_vida) {
        this.hoja_de_vida = hoja_de_vida;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setTipo_documento(int tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void setFormacion(int formacion) {
        this.formacion = formacion;
    }

    public void setCiudad_residencia(int ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }

    public void setDao(AspiranteDAO dao) {
        this.dao = dao;
    }
    
    

    @Override
    public String toString() {
        return "AspiranteDTO{" + super.toString() + "numero_documento=" + numero_documento + ", celular=" + celular + ", telefono_fijo=" + telefono_fijo + ", fecha_nacimiento=" + fecha_nacimiento + ", foto=" + foto + ", descripcion=" + descripcion + ", hoja_de_vida=" + hoja_de_vida + ", profesion=" + profesion + ", nacionalidad=" + nacionalidad + ", tipo_documento=" + tipo_documento + ", sexo=" + sexo + ", formacion=" + formacion + ", ciudad_residencia=" + ciudad_residencia + ", dao=" + dao + '}';
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
            ps.setString(2, correo);
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
    
    public AspiranteDTO autenticar(){
        AspiranteDTO aspirante = null;
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(dao.autenticar());
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String id = Pbkdf2.bytesToString(rs.getBytes(2));
                String primer_nombre = rs.getString(3);
                String segundo_nombre = rs.getString(4);
                String primer_apellido = rs.getString(5);
                String segundo_apellido = rs.getString(6);
                String correo = rs.getString("correo");
                String clave = rs.getString("clave");
                byte[] salt = rs.getBytes("salt");
                aspirante = new AspiranteDTO(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return aspirante;        
    }
    
    public void consultarInicio(){
        
        try {
            PreparedStatement ps = con.getCon().prepareStatement((dao.consultarInicio()));
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                celular = rs.getString("telefono");
                telefono_fijo = rs.getString("telefono_fijo");
                numero_documento = rs.getString("numero_documento");
                primerNombre = rs.getString("primer_nombre");
                segundoNombre = rs.getString("segundo_nombre");
                primerApellido = rs.getString("primer_apellido");
                segundoApellido = rs.getString("segundo_apellido");
                correo = rs.getString("correo");                
                foto = rs.getString("foto");
                tipo_documento = rs.getInt("tipo_documento");
                nacionalidad = rs.getInt("nacionalidad");
                ciudad_residencia = rs.getInt("ciudad_residencia");
                sexo = rs.getInt("sexo");
                formacion = rs.getInt("formacion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
    }
    
    public boolean subirFoto(){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(dao.subirFoto());
            ps.setString(1, foto);
            ps.setString(2, id.replace("-", ""));
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
    
    public void consultarHojaDeVida(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.consultarHojaDeVida());
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.fecha_nacimiento = rs.getString(1);
                this.descripcion = rs.getString(2);
                this.hoja_de_vida = rs.getString(3);
                this.profesion = rs.getString(4);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
    }
    
    public boolean actualizarDatos(){
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.actualizarDatos());
            ps.setString(1, fecha_nacimiento);
            ps.setString(2, descripcion);
            ps.setString(3, hoja_de_vida);
            ps.setString(4, profesion);
            ps.setString(5, id.replace("-", ""));
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public ArrayList<AspiranteDTO> filtroAspirante(String filtro){
        ArrayList<AspiranteDTO> lista = new ArrayList<>();
        try {            
            PreparedStatement ps = con.getCon().prepareStatement(dao.filtroAspirante());
            ps.setString(1, "%" + filtro + "%");
            ps.setString(2, "%" + filtro + "%");
            ps.setString(3, "%" + filtro + "%");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AspiranteDTO aspirante = new AspiranteDTO();
                aspirante.setNumero_documento(rs.getString(1));
                aspirante.setId(Pbkdf2.bytesToString(rs.getBytes(2)));
                aspirante.setFoto(rs.getString(3));
                aspirante.setPrimerNombre(rs.getString(4));
                aspirante.setSegundoNombre(rs.getString(5));
                aspirante.setPrimerApellido(rs.getString(6));
                aspirante.setSegundoApellido(rs.getString(7));
                aspirante.setCorreo(rs.getString(8));               
                //AspiranteDTO aspirante = new AspiranteDTO(numero_documento, id, foto, primerNombre, segundoNombre, primerApellido, segundoApellido, correo);                
                System.out.println(aspirante.toString());
                lista.add(aspirante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return lista;
    }
    
    public String tipoDocumento(){
        String res = "";
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.tipoDocumento());
            ps.setString(1, id.replace("-", ""));
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return res;
    }
    
    public String nacionalidad(){
        String res = "";
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.nacionalidad());
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return res;
    }
    
    public String ciudad_residencia(){
        String res = "";
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.ciudad_residencia());
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return res;
    }
    
    public String genero(){
        String res = "";
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.genero());
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return res;
    }
    
    public String formacion(){
        String res = "";
        try {
            PreparedStatement ps = con.getCon().prepareStatement(dao.formacion());
            ps.setString(1, id.replace("-", ""));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AspiranteDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return res;
    }
     
}
