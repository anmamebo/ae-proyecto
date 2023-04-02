/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ae.ae.proyecto;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anmam
 */
public class GenerarPDFServlet extends HttpServlet {

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
        
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String verificacionIdentidad = request.getParameter("verificacionIdentidad");
            
            // Se crea una ubicación temporal y se guarda un objeto Path
            Path pdfPath = Files.createTempFile("temp_", ".pdf").toAbsolutePath();
            
            // Se crea para escribir el archivo PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            
            // Se crea el responsable de escribir el contenido en el PDF
            PdfWriter writer = new PdfWriter(outputStream);
            // Se crea el objeto que representa el contenido del archivo PDF
            PdfDocument pdf = new PdfDocument(writer);
            
            // Se crea el documento PDF en sí
            try (Document document = new Document(pdf)) {
                document.add(new Paragraph(nombre + " " + apellidos + " " + dni + " " + verificacionIdentidad));
            }
            
            // Se convierte el contenido del ByteArrayOutputStream en un vector de bytes.
            byte[] pdfBytes = outputStream.toByteArray();
            // Los bytes del archivo PDF se escriben en el archivo temporal.
            Files.write(pdfPath, pdfBytes);
            
            // Se redirige al usuario al servlet donde se firmará el archivo pdf
            String urlFirma = request.getContextPath() + "/FirmarPDFServlet?pdf=" + pdfPath.toString().replace("\\", "/");
            response.sendRedirect(urlFirma);
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
