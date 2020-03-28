/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author USER
 */
public class Persona {
    
    protected String id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, clave;
    protected byte[] salt;

    public Persona() {
    }

    public Persona(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave ) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.clave = clave;
        this.salt = salt;
    }

    

    public Persona(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, String clave) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.clave = clave;
    }
    
    

    public Persona(String correo) {
        this.correo = correo;
    }   
    
    public String getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", correo=" + correo + ", salt=" + salt + ", clave=" + clave + '}';
    }

    
    
    
    
}
