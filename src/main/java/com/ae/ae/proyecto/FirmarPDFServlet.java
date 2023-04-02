/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ae.ae.proyecto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.viafirma.cliente.ViafirmaClient;
import org.viafirma.cliente.ViafirmaClientFactory;
import org.viafirma.cliente.exception.InternalException;
import org.viafirma.cliente.firma.Policy;
import org.viafirma.cliente.firma.TypeFile;
import org.viafirma.cliente.firma.TypeFormatSign;
import org.viafirma.cliente.firma.TypeSign;
import org.viafirma.cliente.vo.Documento;
import org.viafirma.cliente.vo.UsuarioGenericoViafirma;

/**
 *
 * @author anmam
 */
public class FirmarPDFServlet extends HttpServlet {

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

        if (request.getMethod().equalsIgnoreCase("GET")) {
            // Obtener la ruta del archivo PDF generado en GenerarPDFServlet
            String pdfPath = request.getParameter("pdf");

            // Recuperar los bytes del PDF
            byte[] pdfBytes = Files.readAllBytes(Paths.get(pdfPath));

            ViafirmaClientFactory.init("https://testservices.viafirma.com/viafirma/", "https://testservices.viafirma.com/viafirma/", null, "xnoccio", "12345");
            // Instanciamos el cliente
            ViafirmaClient viafirmaClient = ViafirmaClientFactory.getInstance();

            // Tipo de formato de firma
            TypeFormatSign format = TypeFormatSign.PDF_PKCS7;
            // Tipo de fichero a firmar
            TypeFile typeFile = TypeFile.PDF;
            // Tipo de firma
            TypeSign typeSign = TypeSign.ENVELOPED;

            // Datos a firmar
            byte[] datosAFirmar = pdfBytes;

            // Creamos la política de firma definiendo los valores obligatorios mínimos
            Policy policy = new Policy();
            policy.setTypeFormatSign(format);
            policy.setTypeSign(typeSign);

            // Generamos nombre pdf
            String nombrePdf = generarNombrePdf(request);

            // Generamos el objeto documento, donde incluiremos el byte[] del fichero a firmar
            Documento documento = new Documento(nombrePdf, datosAFirmar, typeFile, format);

            try {

                // Este método será el encargado de avisar a viafirma plattform de que estamos preparando una firma, donde le pasamos las políticas de la misma y el documento a firmar
                // Este identificador temporal no es necesario que sea almacenado ya que sólo tiene validez durante el proceso de firma.
                String idTemporalFirma = viafirmaClient.prepareSignWithPolicy(policy, documento);
                // Iniciamos la firma enviando al usuario a Viafirma indicando la uri de retorno.
                viafirmaClient.solicitarFirma(idTemporalFirma, request, response, "/RespuestaViafirmaServlet");

            } catch (InternalException e) {
                throw new ServerException(e.getMessage());
            }
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

    private String generarNombrePdf(HttpServletRequest request) {
        String nombre = "";
        
        // Obtiene DNI del usuario
        HttpSession session = request.getSession();
        UsuarioGenericoViafirma usuario = (UsuarioGenericoViafirma) session.getAttribute("usuarioAutenticado");
        if (usuario == null) {
            nombre += "usuario_";        
        } else {
            nombre += usuario.getNumberUserId() + "_";        
        }
        
        // Obtiene la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        nombre += formattedDateTime + ".pdf";

        return nombre;
    }

}
