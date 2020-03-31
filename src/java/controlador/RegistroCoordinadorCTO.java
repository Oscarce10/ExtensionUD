/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hash.Pbkdf2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.CoordinadorDTO;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author USER
 */
public class RegistroCoordinadorCTO extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("registrar") != null) {
            try {
                String id = UUID.randomUUID().toString();
                String primerNombre = request.getParameter("pnombre");
                String segundoNombre = request.getParameter("snombre");
                String primerApellido = request.getParameter("papellido");
                String segundoApellido = request.getParameter("sapellido");
                String correo = request.getParameter("correo");
                byte[] salt = Pbkdf2.generateSalt();
                String password = request.getParameter("clave");
                String clave;
                clave = Pbkdf2.generateHash(password.toCharArray(), salt);
                CoordinadorDTO coordinador = new CoordinadorDTO(id, primerNombre, segundoNombre, primerApellido, segundoApellido, correo, salt, clave);
                if (coordinador.consultarCorreo()) {
                    request.setAttribute("fail", "correo");
                    request.setAttribute("action", "signup");
                    request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("coordinador/registrocoordinador.jsp".getBytes())).forward(request, response);
                    return;
                }
                if (coordinador.crear()) {
                    System.out.println("COORDINADOR CREADO");
                } else {
                    System.out.println("COORDINADOR NO CREADO");
                }
                System.out.println(coordinador.toString());
                request.setAttribute("action", "registrocordinador");
                request.setAttribute("created", "Coordinador");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            } catch (Exception e) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {

            request.setAttribute("action", "registro");
            request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("coordinador/registrocoordinador.jsp".getBytes())).forward(request, response);
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
