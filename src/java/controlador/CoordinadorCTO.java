/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hash.Pbkdf2;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.CoordinadorDTO;

/**
 *
 * @author USER
 */
public class CoordinadorCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("registr") != null && request.getParameter("registro").equals("coordinador")) {
            try {
                String id = UUID.randomUUID().toString();
                String primerNombre = "Oscar";
                String segundoNombre = "";
                String primerApellido = "Cely";
                String segundoApellido = "";
                String correo = "1@c.com";
                byte[] salt = Pbkdf2.generateSalt();
                String password = "1";
                String clave;
                clave = Pbkdf2.generateHash(password.toCharArray(), salt);
                CoordinadorDTO coordinador = new CoordinadorDTO(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
                if(coordinador.crear()){
                    System.out.println("COORDINADOR CREADO");
                }else{
                   System.out.println("COORDINADOR NO CREADO"); 
                }
                System.out.println(coordinador.toString());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CoordinadorCTO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeySpecException ex) {
                Logger.getLogger(CoordinadorCTO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
            response.sendRedirect("index.jsp");
            return;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
