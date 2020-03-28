/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import modelo.dto.Persona;

/**
 *
 * @author USER
 */
public class AspiranteDAO extends Persona{
    private String numero_documento, celular, telefono_fijo, fecha_nacimiento, foto, descripcion, hoja_de_vida, profesion;	
    private int nacionalidad, tipo_documento, sexo, formacion, ciudad_residencia;

    public AspiranteDAO() {
        super();
    }    

    public AspiranteDAO(String numero_documento, String celular, String telefono_fijo, String fecha_nacimiento, String foto, String descripcion, String hoja_de_vida, String profesion, int nacionalidad, int tipo_documento, int sexo, int formacion, int ciudad_residencia, String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String clave, byte[] salt) {
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
    }

    

    public AspiranteDAO(String numero_documento, String celular, String telefono_fijo, int nacionalidad, int tipo_documento, int sexo, int formacion, int ciudad_residencia, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String clave) {
        super(primerNombre, segundoNombre, primerApellido, segundoApellido, correo, clave);
        this.numero_documento = numero_documento;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.nacionalidad = nacionalidad;
        this.tipo_documento = tipo_documento;
        this.sexo = sexo;
        this.formacion = formacion;
        this.ciudad_residencia = ciudad_residencia;
    }

    

    public AspiranteDAO(String correo) {
        super();
        this.correo = correo;
    }
    
    
    
    public String registrar(){
        return "INSERT INTO aspirante (uuid, primer_nombre, segundo_nombre, primer_apellido, "
                + "segundo_apellido, numero_documento, telefono, telefono_fijo, correo, clave, "
                + "salt, tipo_documento, nacionalidad, ciudad_residencia, sexo, formacion)"
                + "VALUES (UNHEX(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }
    
    public String consultarCorreo(){
        return "SELECT * FROM aspirante WHERE CORREO LIKE ?";
    }
    
}
