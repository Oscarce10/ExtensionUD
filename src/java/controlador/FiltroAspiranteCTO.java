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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.AspiranteDTO;

/**
 *
 * @author USER
 */
public class FiltroAspiranteCTO extends HttpServlet {

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
        System.out.println("PARAMETRO RECIBIDO: " + request.getParameter("filtro"));
        AspiranteDTO aspirante = new AspiranteDTO();
        ArrayList<AspiranteDTO> aspirantes = aspirante.filtroAspirante(request.getParameter("filtro"));
        System.out.println(aspirantes.size());
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            
            out.println("<div class=\"card\">");
            out.println("<div class=\"card-header bg-primary text-white\">Resultado Aspirantes");
            out.println("</div>");
            out.println("<div class=\"card-body\">");
            out.println("<table class=\"table table-striped table-hover\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">Id</th>");
            out.println("<th scope=\"col\">Nombres</th>");
            out.println("<th scope=\"col\">Apellidos</th>");
            out.println("<th scope=\"col\">Correo</th>");
            out.println("<th scope=\"col\">Foto</th>");
            out.println("<th scope=\"col\">Opciones</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            if (aspirantes != null) {
                for (AspiranteDTO a : aspirantes) {
                    System.out.println(a.getId());
                    out.println("<tr id=" + a.getId());
                    out.println("<th scope=\"row\">" + a.getId() + "</th>");
                    out.println("<td>" + a.getPrimerNombre() + " " + a.getSegundoNombre() + "</td>");
                    out.println("<td>" + a.getPrimerApellido() + " " + a.getSegundoApellido() + "</td>");
                    out.println("<tr id=" + a.getCorreo());
                    if (a.getFoto() != null && !a.getFoto().equals("") && new File("D:\\Users\\USER\\Documents\\NetBeansProjects\\proyecto\\images\\" + a.getFoto()).exists()) {
                        out.println("<img src=\"images/" + a.getFoto() + "\" alt=\"Foto aspirante\" class=\"rounded-full h-192 w-306 flex items-center justify-center \" id=\"foto-aspirante\">");
                    } else {
                        out.println("<i class='fas fa-user-circle fa-8x'></i>");
                    }

                }
            }
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
