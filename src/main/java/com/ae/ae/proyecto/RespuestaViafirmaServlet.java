/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ae.ae.proyecto;

import com.ae.ae.proyecto.utils.DocumentoUtils;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.viafirma.cliente.ViafirmaClient;
import org.viafirma.cliente.ViafirmaClientFactory;
import org.viafirma.cliente.ViafirmaClientServlet;
import org.viafirma.cliente.exception.CodigoError;
import org.viafirma.cliente.exception.InternalException;
import org.viafirma.cliente.vo.FirmaInfoViafirma;
import org.viafirma.cliente.vo.UsuarioGenericoViafirma;

/**
 *
 * @author Antonio Manuel Mérida Borrero
 */
public class RespuestaViafirmaServlet extends ViafirmaClientServlet {

    @Override
    public void signOK(FirmaInfoViafirma firma, HttpServletRequest request,
            HttpServletResponse response) {

        try {

            ViafirmaClient viafirmaClient = ViafirmaClientFactory.getInstance();
            byte[] pdfGenerado = viafirmaClient.getOriginalDocument(firma.getSignId()).getDatos();
            
            response.setContentType("application/pdf");
            String headerKey = "Content-Disposition";
            String headerValue = "inline; filename=COMPROBANTE-" + viafirmaClient.getOriginalDocument(firma.getSignId()).getNombre();
            response.setHeader(headerKey, headerValue);

            PdfDocument pdf = new PdfDocument(new PdfReader(new ByteArrayInputStream(pdfGenerado)), new PdfWriter(response.getOutputStream()).setSmartMode(true));

            try (Document document = new Document(pdf)) {

                DocumentoUtils.construirDocumentoComprobanteFirma(document, firma, pdf);

                document.close();
            }

        } catch (IOException | InternalException ex) {
            Logger.getLogger(RespuestaViafirmaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void authenticateOK(UsuarioGenericoViafirma usuario, HttpServletRequest request, HttpServletResponse response) {
        // Lógica específica de cada aplicación para gestionar el resultado de la autenticación
        try {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioAutenticado", usuario);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
        }
    }

    @Override
    public void cancel(HttpServletRequest request, HttpServletResponse response) {
        // Gestión de cancelación del usuario al autenticar o firmar
        try {
            request.setAttribute("error", "El usuario ha cancelado la autenticación");
            request.getRequestDispatcher("/formulario.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
        }
    }

    @Override
    public void error(CodigoError codError, HttpServletRequest request, HttpServletResponse response) {
        // Gestión de error al autenticar o firmar
        try {
            request.setAttribute("codError", codError);
            request.getRequestDispatcher("/formulario.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
        }
    }
}
