/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.dto.AspiranteDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author USER
 */
@MultipartConfig
public class ActualizarHojaDeVidaCTO extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        response.setContentType("text/html;charset=UTF-8");

        if (ServletFileUpload.isMultipartContent(request)) {
            AspiranteDTO aspirante = new AspiranteDTO(sesion.getAttribute("id").toString());
            aspirante.consultarInicio();
            aspirante.consultarHojaDeVida();
            if (request.getPart("pdf").getSize() != 0) {
                Part pdf = request.getPart("pdf");
                if (pdf.getSize() > 10000000) {
                    request.setAttribute("action", "subirpdf");
                    request.setAttribute("fail", "El archivo no debe pesar mas de 10 MB");
                    request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarhojadevida.jsp".getBytes())).forward(request, response);
                    return;
                }

                String nombre = Paths.get(pdf.getSubmittedFileName()).getFileName().toString(); // MSIE fix.      
                String[] extensionArchivo = nombre.split("\\.");
                if (extensionArchivo[1].equals("pdf")) {

                    if (aspirante.getFoto() != null && !aspirante.getFoto().equals("")) {
                        File file = new File("D:\\Users\\USER\\Documents\\NetBeansProjects\\proyecto\\pdf\\" + aspirante.getHoja_de_vida());
                        file.delete();
                    }
                    File uploads = new File("D:\\Users\\USER\\Documents\\NetBeansProjects\\proyecto\\pdf");
                    String filename = "hojadevida" + aspirante.getId() + ".pdf";
                    File file = new File(uploads, filename);
                    try (InputStream fileContent = pdf.getInputStream()) {
                        Files.copy(fileContent, file.toPath());
                    }

                    aspirante.setHoja_de_vida(filename);

                } else {
                    request.setAttribute("action", "actualizarpdf");
                    request.setAttribute("fail", "Extension no permitada, escoja un archivo con extension PDF.");
                    request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarhojadevida.jsp".getBytes())).forward(request, response);
                    return;
                }

            }
            aspirante.setFecha_nacimiento(request.getParameter("fechaNacimiento"));
            aspirante.setDescripcion(request.getParameter("descripcion"));
            aspirante.setProfesion(request.getParameter("profesion"));
            aspirante.setHoja_de_vida(aspirante.getHoja_de_vida());
            if (aspirante.actualizarDatos()) {
                request.setAttribute("actualizarInfo", "success");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                System.out.println("File Not uploaded");
            }

        } else {

            System.out.println("ENTRA A HOJA DE VIDA");
            request.setAttribute("action", "actualizarhojadevida");
            request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarhojadevida.jsp".getBytes())).forward(request, response);
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
