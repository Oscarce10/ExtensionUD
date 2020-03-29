/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
public class ActualizarFotoCTO extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        if (ServletFileUpload.isMultipartContent(request)) {
            Part foto = request.getPart("foto"); // Retrieves <input type="file" name="file">
            if (foto.getSize() > 3000000) {
                request.setAttribute("action", "actualizarfoto");
                request.setAttribute("fail", "El archivo no debe pesar mas de 2 MB");
                request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarfoto.jsp".getBytes())).forward(request, response);
                return;
            }
            String nombre = Paths.get(foto.getSubmittedFileName()).getFileName().toString(); // MSIE fix.       

            String[] extensiones = {"jpeg", "jpg", "png"};
            String[] extensionArchivo = nombre.split("\\.");
            System.out.println("nombre: " + nombre);
            System.out.println("extensionArchivo: " + extensionArchivo[1]);
            for (String item : extensiones) {
                System.out.println("ITEM: " + item);
                if (extensionArchivo[1].equals(item)) {

                    AspiranteDTO aspirante = new AspiranteDTO(sesion.getAttribute("id").toString());
                    aspirante.consultarInicio();

                    if (aspirante.getFoto() != null && !aspirante.getFoto().equals("")) {
                        File file = new File("D:\\Users\\USER\\Documents\\NetBeansProjects\\proyecto\\images\\" + aspirante.getFoto());
                        if (file.delete()) {
                            System.out.println("FILE DELETED");
                        } else {
                            System.out.println("FAIL TO DELETE FAIL");
                        }
                    }
                    File uploads = new File("D:\\Users\\USER\\Documents\\NetBeansProjects\\proyecto\\images");
                    String filename = new Date().getTime() + ".jpg";
                    File file = new File(uploads, filename);
                    try (InputStream fileContent = foto.getInputStream()) {
                        Files.copy(fileContent, file.toPath());
                    }

                    aspirante.setFoto(filename);
                    if (aspirante.subirFoto()) {
                        request.setAttribute("upload", "success");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        System.out.println("File Not uploaded");
                    }
                }
            }
            request.setAttribute("action", "actualizarfoto");
            request.setAttribute("fail", "Extension no permitada, escoja un archivo con extension JPEG, PNG o JPG.");
            request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarfoto.jsp".getBytes())).forward(request, response);
            return;

        } else {
            request.setAttribute("action", "actualizarfoto");
            request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("aspirante/actualizarfoto.jsp".getBytes())).forward(request, response);
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
