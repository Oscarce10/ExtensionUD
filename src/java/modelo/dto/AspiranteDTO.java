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
public class AspiranteDTO extends Persona{
    
    private String numero_documento, celular, telefono_fijo, fecha_nacimiento, foto, descripcion, hoja_de_vida;	
    private int nacionalidad, tipo_documento, sexo, profesion, formacion, ciudad_residencia;

    public AspiranteDTO() {
        super();        
    }    

    public AspiranteDTO(String numero_documento, String celular, String telefono_fijo, String fecha_nacimiento, String foto, String descripcion, String hoja_de_vida, int nacionalidad, int tipo_documento, int sexo, int profesion, int formacion, int ciudad_residencia, String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
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

    public int getProfesion() {
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
    
     
}
