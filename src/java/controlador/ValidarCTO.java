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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.CoordinadorDTO;
import org.apache.tomcat.util.codec.binary.Base64;

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
        response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate, max-age=0, proxy-revalidate, s-maxage=0"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("ingresar") != null){
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
            CoordinadorDTO coordinador = new CoordinadorDTO(correo, clave);
            coordinador = coordinador.autenticar();
            if(coordinador != null){                
                try {
                    if(coordinador.getClave().equals(Pbkdf2.generateHash(clave.toCharArray(), coordinador.getSalt()))){
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("tipo", "coordinador");
                        sesion.setAttribute("id", coordinador.getId());
                        request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("coordinador/inicio.jsp".getBytes()) + "&id="+sesion.getAttribute("id").toString() + "&tipo="+sesion.getAttribute("tipo").toString()).forward(request, response);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("index.jsp?login=fail").forward(request, response);
        } else{
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
