/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.AspiranteDTO;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author USER
 */
public class RegistroUsuario extends HttpServlet {

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
            AspiranteDTO aspirante = new AspiranteDTO(request.getParameter("correo"));
            System.out.println(aspirante.consultarCorreo());
            if (aspirante.consultarCorreo()) {
                request.setAttribute("fail", "correo");
                request.setAttribute("action", "signup");
                request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("registrousuario.jsp".getBytes())).forward(request, response);
                return;
            } else {
                String pnombre = request.getParameter("pnombre");
                String snombre = request.getParameter("snombre");
                String papellido = request.getParameter("papellido");
                String sapellido = request.getParameter("sapellido");
                String correo = request.getParameter("correo");
                String clave = request.getParameter("clave");
                String telefono = request.getParameter("telefono");
                String celular = request.getParameter("celular");
                String numdoc = request.getParameter("numdoc");
                int tipodocumento = Integer.parseInt(request.getParameter("tipodocumento"));
                int nacionalidad = Integer.parseInt(request.getParameter("nacionalidad"));
                int residencia = Integer.parseInt(request.getParameter("residencia"));
                int formacion = Integer.parseInt(request.getParameter("formacion"));
                int sexo = Integer.parseInt(request.getParameter("sexo"));
                aspirante = new AspiranteDTO(numdoc, celular, telefono, nacionalidad, tipodocumento, sexo, formacion, residencia, pnombre, snombre, papellido, sapellido, correo, clave);
                if(aspirante.registrar()){
                    request.setAttribute("action", "registro");
                    request.setAttribute("registro", "success");
                    request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("inicio.jsp".getBytes())).forward(request, response);
                }
            }
        }else{
        
        request.setAttribute("action", "registro");
        request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("registrousuario.jsp".getBytes())).forward(request, response);
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
