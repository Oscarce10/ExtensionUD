/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hash.Pbkdf2;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.AspiranteDTO;
import modelo.dto.CoordinadorDTO;

/**
 *
 * @author USER
 */
public class ValidarCTO extends HttpServlet {

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
        if (request.getParameter("ingresar") != null) {
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
            CoordinadorDTO coordinador = new CoordinadorDTO(correo, clave);
            coordinador = coordinador.autenticar();
            AspiranteDTO aspirante = new AspiranteDTO(correo, clave);
            aspirante = aspirante.autenticar();
            if (coordinador != null) {
                try {
                    if (coordinador.getClave().equals(Pbkdf2.generateHash(clave.toCharArray(), coordinador.getSalt()))) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("tipo", "coordinador");
                        sesion.setAttribute("id", coordinador.getId());
                        response.sendRedirect("coordinador");
                        return;
                        //request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("coordinador/inicio.jsp".getBytes()) + "&id="+sesion.getAttribute("id").toString() + "&tipo="+sesion.getAttribute("tipo").toString()).forward(request, response);
                    } else {
                        request.setAttribute("login", "fail");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (aspirante != null) {
                try {
                    if (aspirante.getClave().equals(Pbkdf2.generateHash(clave.toCharArray(), aspirante.getSalt()))) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("tipo", "aspirante");
                        sesion.setAttribute("id", aspirante.getId());
                        response.sendRedirect("aspirante");
                        return;
                    } else {
                        request.setAttribute("login", "fail");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("login", "fail");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
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
