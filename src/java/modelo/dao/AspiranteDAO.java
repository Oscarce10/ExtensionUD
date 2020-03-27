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
    private String numero_documento, celular, telefono_fijo, fecha_nacimiento, foto, descripcion, hoja_de_vida;	
    private int nacionalidad, tipo_documento, sexo, profesion, formacion, ciudad_residencia;

    public AspiranteDAO() {
        super();
    }    

    public AspiranteDAO(String numero_documento, String celular, String telefono_fijo, String fecha_nacimiento, String foto, String descripcion, String hoja_de_vida, int nacionalidad, int tipo_documento, int sexo, int profesion, int formacion, int ciudad_residencia, String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
        this.numero_documento = numero_documento;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.foto = foto;
        this.descripcion = descripcion;
        this.hoja_de_vida = hoja_de_vida;
        this.nacionalidad = nacionalidad;
        this.tipo_documento = tipo_documento;
        this.sexo = sexo;
        this.profesion = profesion;
        this.formacion = formacion;
        this.ciudad_residencia = ciudad_residencia;
    }

    
    
    
    
}
