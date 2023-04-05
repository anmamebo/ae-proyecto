/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ae.ae.proyecto.utils;

import com.ae.ae.proyecto.modelos.Formulario;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anmam
 */
public class DocumentoUtils {

    public static void construirDocumentoFormulario(Document doc, Formulario form) {

        // TÍTULO
        Paragraph title = new Paragraph("BECA CERTISIGN 2022/2023");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setBold();
        doc.add(title);

        // LÍNEA SEPARADORA
        LineSeparator line = new LineSeparator(new SolidLine());
        doc.add(line);

        // TABLA
        Table table = new Table(new float[12]).useAllAvailableWidth();
        table.setMarginTop(10);
        table.setMarginBottom(0);
        table.setBorder(new SolidBorder(1));
        table.setBold();

        Cell cell = new Cell(1, 4);
        cell.setTextAlignment(TextAlignment.LEFT);
        cell.setPadding(5);
        cell.setBorder(Border.NO_BORDER);

        String dniTablaTexto = "DNI: " + form.getDatosPersonales().getDni();
        Paragraph dniTablaParrafo = new Paragraph(dniTablaTexto);
        cell.add(dniTablaParrafo);
        table.addCell(cell);

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        // Convertir la fecha actual en milisegundos desde el inicio de la era
        long milisegundos = fechaActual.toEpochDay();
        // Generar un número aleatorio entre 0 y 9999
        int numeroAleatorio = (int) (Math.random() * 10000);
        // Combinar la fecha actual y el número aleatorio para crear el ID
        String numeroSolicitud = String.format("%d-%04d", milisegundos, numeroAleatorio);

        Cell cell2 = new Cell(1, 4);
        cell2.setTextAlignment(TextAlignment.CENTER);
        cell2.setPadding(5);
        cell2.setBorder(Border.NO_BORDER);

        String numeroSolicitudTablaTexto = "Número de solicitud: " + numeroSolicitud;
        Paragraph numeroSolicitudTablaParrafo = new Paragraph(numeroSolicitudTablaTexto);
        cell2.add(numeroSolicitudTablaParrafo);
        table.addCell(cell2);

        // Pasar la fecha actual a una cadena de texto en el formato "dd/MM/yyyy"
        String fechaActualTexto = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Cell cell3 = new Cell(1, 4);
        cell3.setTextAlignment(TextAlignment.RIGHT);
        cell3.setPadding(5);
        cell3.setBorder(Border.NO_BORDER);

        String fechaTablaTexto = "Fecha: " + fechaActualTexto;
        Paragraph fechaTablaParrafo = new Paragraph(fechaTablaTexto);
        cell3.add(fechaTablaParrafo);
        table.addCell(cell3);

        doc.add(table);

        // NOMBRE
        String nombreTexto = form.getDatosPersonales().getNombre() + " " + form.getDatosPersonales().getApellidos();
        Paragraph nombreParrafo = new Paragraph(nombreTexto);
        nombreParrafo.setMarginTop(20);
        doc.add(nombreParrafo);

        // FECHA NACIMIENTO
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaNacimientoTexto = "Fecha Nacimiento: " + formatoFecha.format(form.getDatosPersonales().getFechaNacimiento());
        Paragraph fechaNacimientoParrafo = new Paragraph(fechaNacimientoTexto);
        doc.add(fechaNacimientoParrafo);

        // DOMICILIO
        String domicilioTexto = "Domicilio: Calle " + form.getDireccion().getCalle() + " Nº "
                + form.getDireccion().getNumeroCalle() + " C.P. " + form.getDireccion().getCodigoPostal()
                + " (" + form.getDireccion().getCiudad() + ") " + form.getDireccion().getProvincia();
        Paragraph domicilioParrafo = new Paragraph(domicilioTexto);
        doc.add(domicilioParrafo);

        // CORREO ELECTRÓNICO
        String correoElectronicoTexto = "Correo Electrónico: " + form.getDatosPersonales().getEmail();
        Paragraph correoElectronicoParrafo = new Paragraph(correoElectronicoTexto);
        doc.add(correoElectronicoParrafo);

        // TELÉFONO MÓVIL
        String telefonoMovilTexto = "Teléfono Móvil: " + form.getDatosPersonales().getTelefono();
        Paragraph telefonoMovilParrafo = new Paragraph(telefonoMovilTexto);
        doc.add(telefonoMovilParrafo);

        
        
        // TIENE TÍTULO
        doc.add(new Paragraph("Estudios:").setBold());
        
        String tieneTitulo = form.isTieneTitulo() ? "Sí" : "No";
        String tieneTituloTexto = "Título Universitario o de Grado Superior: " + tieneTitulo;
        Paragraph tieneTituloParrafo = new Paragraph(tieneTituloTexto);
        doc.add(tieneTituloParrafo);

        // UNIVERSIDAD        
        String universidadTexto = "Universidad donde realizará el curso: " + form.getEstudios().getNombreUniversidad();
        Paragraph universidadParrafo = new Paragraph(universidadTexto);
        doc.add(universidadParrafo);

        // CURSO Y ESTUDIOS
        String estudiosTexto = "Curso y Estudios que prevé realizar: " + form.getEstudios().getCursoYEstudios();
        Paragraph estudiosParrafo = new Paragraph(estudiosTexto);
        doc.add(estudiosParrafo);

        // FAMILIARES
        String tituloFamiliaresTexto = "Familiares:";
        Paragraph tituloFamiliaresParrafo = new Paragraph(tituloFamiliaresTexto);
        tituloFamiliaresParrafo.setBold();
        doc.add(tituloFamiliaresParrafo);

        for (int i = 0; i < form.getFamiliares().size(); i++) {
            String familiaresTexto = form.getFamiliares().get(i).getDni() + " - " + form.getFamiliares().get(i).getNombre();
            Paragraph familiaresParrafo = new Paragraph(familiaresTexto);
            doc.add(familiaresParrafo);
        }

        // DATOS IBAN
        String tituloDatosIbanTexto = "Datos de IBAN:";
        Paragraph tituloDatosIbanParrafo = new Paragraph(tituloDatosIbanTexto);
        tituloDatosIbanParrafo.setBold();
        doc.add(tituloDatosIbanParrafo);

        String datosIbanInfoTexto = "Recuerde que deberá ser titular o cotitular de esta cuenta y verificar que la cuenta permanece activa. Es importante que no cancele"
                + "la cuenta hasta que no haya percibido el importe total de la beca, teniendo en cuenta que pueden producirse distintos pagos parciales"
                + "en fechas diferentes (cuantía fija, posibles aumentos de cuantía y/o diversos pagos en concepto de cuantía variable).";
        Paragraph datosIbanInfoParrafo = new Paragraph(datosIbanInfoTexto);
        doc.add(datosIbanInfoParrafo);
        
        Table tableIban = new Table(new float[12]).useAllAvailableWidth();
        
        Cell c1 = new Cell(1, 2);
        c1.setPadding(5);
        c1.setTextAlignment(TextAlignment.CENTER);
        c1.setBorder(Border.NO_BORDER);
        c1.add(new Paragraph("País:"));
        tableIban.addCell(c1);
        
        Cell c2 = new Cell(1, 2);
        c2.setPadding(5);
        c2.setTextAlignment(TextAlignment.CENTER);
        c2.add(new Paragraph(form.getIban().getPaisIban()));
        tableIban.addCell(c2);
        
        Cell c3 = new Cell(1, 2);
        c3.setPadding(5);
        c3.setTextAlignment(TextAlignment.CENTER);
        c3.setBorder(Border.NO_BORDER);
        c3.add(new Paragraph("Digitos control:"));
        tableIban.addCell(c3);
        
        Cell c4 = new Cell(1, 2);
        c4.setPadding(5);
        c4.setTextAlignment(TextAlignment.CENTER);
        c4.add(new Paragraph(form.getIban().getDigitosControlIban()));
        tableIban.addCell(c4);
        
        Cell c5 = new Cell(1, 2);
        c5.setPadding(5);
        c5.setTextAlignment(TextAlignment.CENTER);
        c5.setBorder(Border.NO_BORDER);
        c5.add(new Paragraph("Nº de cuenta:"));
        tableIban.addCell(c5);
        
        Cell c6 = new Cell(1, 2);
        c6.setPadding(5);
        c6.setTextAlignment(TextAlignment.CENTER);
        c6.add(new Paragraph(form.getIban().getNumeroCuentaIban()));
        tableIban.addCell(c6);       
        
        doc.add(tableIban);
        
        // DATOS FAMILIARES CON REPERCUSIÓN ECONÓMICA
        doc.add(new Paragraph("Datos familiares con repercusión económica:").setBold());
        
        String familiaNumerosa = form.isFamiliaNumerosa() ? "Sí" : "No";
        doc.add(new Paragraph("Condición de familia numerosa: " + familiaNumerosa));
        
        String independiente = form.isIndependiente() ? "Sí" : "No";
        doc.add(new Paragraph("Independiente: " + independiente));
        
        String orfandad = form.isOrfandad() ? "Sí" : "No";
        doc.add(new Paragraph("Orfandad absoluta: " + orfandad));
    }
}
