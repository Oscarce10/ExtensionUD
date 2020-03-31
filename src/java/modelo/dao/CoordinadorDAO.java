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
public class CoordinadorDAO extends Persona{
    
    public CoordinadorDAO() {
        super();
    }

    public CoordinadorDAO(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo, byte[] salt, String clave) {
        super(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
    }
    
    
    public CoordinadorDAO(String correo, String clave) {
        super();
        this.correo = correo;
        this.clave = clave;
    } 
    
    public CoordinadorDAO(String id) {
        super();
        this.id = id;
    } 
    
           
     public String crear(){
         return "INSERT INTO coordinador (uuid, primer_nombre, segundo_nombre, primer_apellido, "
                 + "segundo_apellido, correo, clave, salt) VALUES (unhex(replace(?, '-', '')), ?, ?, ?, ?, ?, ?, ?)";
     }  
     
     
     public String autenticar(){
         return "SELECT * FROM coordinador WHERE correo like ?";
     }
     
     public String consultar(){
         return "SELECT primer_nombre, primer_apellido, correo FROM coordinador WHERE uuid LIKE unhex(?)";
     }
     
     public String consultarTodos(){
         return "SELECT * FROM coordinador";
     }
     
     public String consultarCorreo(){
        return "SELECT correo FROM aspirante WHERE CORREO LIKE ? UNION SELECT correo FROM coordinador WHERE CORREO LIKE ?";
    }
     
     public String filtroCoordinador(){
        return "SELECT primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, correo " +
                " FROM coordinador " +
                " WHERE CONCAT(primer_nombre, ' ', segundo_nombre, ' ', primer_apellido, ' ', segundo_apellido) LIKE ?  OR correo LIKE ?";
    }
}
