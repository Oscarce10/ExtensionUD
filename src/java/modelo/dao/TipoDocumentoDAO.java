/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author USER
 */
public class TipoDocumentoDAO {
    private int id;
    private String documento;

    public TipoDocumentoDAO() {
    }

    public TipoDocumentoDAO(int id, String documento) {
        this.id = id;
        this.documento = documento;
    }
    
    public String consultar(){
        return "SELECT * FROM tipo_documento;";
    }
}
