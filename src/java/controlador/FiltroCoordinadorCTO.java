/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.CoordinadorDTO;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author USER
 */
@WebServlet(name = "FiltroCoordinadorCTO", urlPatterns = {"/filtrocoordinador"})
public class FiltroCoordinadorCTO extends HttpServlet {

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
        CoordinadorDTO coordinador = new CoordinadorDTO();
        ArrayList<CoordinadorDTO> coordinadores = new ArrayList<>();
        coordinadores.addAll(coordinador.filtroCoordinador(request.getParameter("filtro")));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
            out.print("<script type=\"text/javascript\" src=\"js/script.js\"></script>");
            out.println("<div class=\"card\" style=\"margin-top: 20px;\">");
            out.println("<div class=\"card-header bg-primary text-white\">Resultado Aspirantes");
            out.println("</div>");
            out.println("<div class=\"card-body\">");
            out.println("<table class=\"table table-striped table-hover\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">Nombres</th>");
            out.println("<th scope=\"col\">Apellidos</th>");
            out.println("<th scope=\"col\">Correo</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            if (coordinadores != null) {
                for (CoordinadorDTO a : coordinadores) {
                    out.println("<tr id=" + a.getId() + ">");
                    out.println("<td>" + a.getPrimerNombre() + " " + a.getSegundoNombre() + "</td>");
                    out.println("<td>" + a.getPrimerApellido() + " " + a.getSegundoApellido() + "</td>");
                    out.println("<td>" + a.getCorreo() + "</td>");
                                      
                    
                }
            }
            out.print("<tr><td colspan='6' class=\"text-center\">" + coordinadores.size() + " registros encontrados</td></tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
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
