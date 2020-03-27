/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelo.dto.CoordinadorDTO;

/**
 *
 * @author USER
 */
public class pruebas {
    
    public static final ConexionMysql con = ConexionMysql.getInstance();
    
    public static void main(String[] args) {
        ArrayList<CoordinadorDTO> lista = null;
        CoordinadorDTO ob = new CoordinadorDTO();
        lista = ob.consultarTodos();
        if(lista != null){
            for (CoordinadorDTO c : lista) {
                System.out.println(c.toString());
            }
        }else{
            System.out.println("Coordinadores no encontrados");
        }
    }
    
}
