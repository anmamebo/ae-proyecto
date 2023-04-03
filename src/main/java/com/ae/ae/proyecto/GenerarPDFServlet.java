/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ae.ae.proyecto;

import com.ae.ae.proyecto.modelos.Formulario;
import com.ae.ae.proyecto.utils.FormularioUtils;
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
import org.viafirma.cliente.vo.UsuarioGenericoViafirma;

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

            Formulario form = this.procesarFormulario(request, (UsuarioGenericoViafirma) request.getSession().getAttribute("usuarioAutenticado"));
            
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
                document.add(new Paragraph(form.getDatosPersonales().getNombre() + " " + form.getDatosPersonales().getApellidos() + " " + form.getDatosPersonales().getDni() + " " + form.isConsentimiento()));
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

    private Formulario procesarFormulario(HttpServletRequest request, UsuarioGenericoViafirma usuario) {
        Formulario form = new Formulario();

        String nombre = usuario.getFirstName();
        String apellidos = usuario.getLastName();
        String dni = usuario.getNumberUserId();
        String fNacimiento = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        form.setDatosPersonales(FormularioUtils.generarPersona(nombre, apellidos, dni, fNacimiento, email, telefono));
        
        String calle = request.getParameter("calle");
        String numeroCalle = request.getParameter("numeroCalle");
        String codigoPostal = request.getParameter("codigoPostal");
        String ciudad = request.getParameter("ciudad");
        String provincia = request.getParameter("provincia");
        form.setDireccion(FormularioUtils.generarDireccion(calle, numeroCalle, codigoPostal, ciudad, provincia));
        
        String tieneTitulo = request.getParameter("tieneTitulo");
        form.setTieneTitulo(FormularioUtils.generarTieneTitulo(tieneTitulo));
        
        String nombreUniversidad = request.getParameter("universidad");
        String cursoYEstudios = request.getParameter("estudios");
        form.setEstudios(FormularioUtils.generarEstudios(nombreUniversidad, cursoYEstudios));
        
        String familiaNumerosa = request.getParameter("familiaNumerosa");
        form.setFamiliaNumerosa(FormularioUtils.generarFamiliaNumerosa(familiaNumerosa));
        String independiente = request.getParameter("independiente");
        form.setIndependiente(FormularioUtils.generarIndependiente(independiente));
        String orfandad = request.getParameter("orfandad");
        form.setOrfandad(FormularioUtils.generarOrfandad(orfandad));
        
        String paisIban = request.getParameter("paisIban");
        String digitosControlIban = request.getParameter("dControlIban");
        String numeroCuentaIban = request.getParameter("nCuentaIban");
        form.setIban(FormularioUtils.generarIban(paisIban, digitosControlIban, numeroCuentaIban));
        
        
        String verificacionIdentidad = request.getParameter("verificacionIdentidad");
        form.setConsentimiento(FormularioUtils.generarConsentimiento(verificacionIdentidad));

        return form;
    }
}
