/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ae.ae.proyecto.utils;

import com.ae.ae.proyecto.modelos.Direccion;
import com.ae.ae.proyecto.modelos.Estudios;
import com.ae.ae.proyecto.modelos.Iban;
import com.ae.ae.proyecto.modelos.Persona;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anmam
 */
public class FormularioUtils {
    
    public static Persona generarPersona(String nombre, String apellidos, String dni, String fNacimiento, String email, String telefono) {
        Persona p = new Persona();
        
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = formatoFecha.parse(fNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(FormularioUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setDni(dni);
        p.setFechaNacimiento(fechaNacimiento);
        p.setEmail(email);
        p.setTelefono(telefono);
        
        return p;
    }
    
    public static Direccion generarDireccion(String calle, String numero, String cPostal, String ciudad, String provincia) {
        Direccion d = new Direccion();
        
        d.setCalle(calle);
        d.setNumeroCalle(numero);
        d.setCodigoPostal(cPostal);
        d.setCiudad(ciudad);
        d.setProvincia(provincia);
        
        return d;
    }
    
    public static boolean generarTieneTitulo(String tieneTitulo) {
        return "si".equals(tieneTitulo);
    }
    
    public static Estudios generarEstudios(String nombreUniversidad, String cursoYEstudios) {
        Estudios e = new Estudios();
        
        e.setNombreUniversidad(nombreUniversidad);
        e.setCursoYEstudios(cursoYEstudios);
        
        return e;
    }
    
    public static boolean generarFamiliaNumerosa(String familiaNumerosa) {
        return "si".equals(familiaNumerosa);
    }
    
    public static boolean generarIndependiente(String independiente) {
        return "si".equals(independiente);
    }
    
    public static boolean generarOrfandad(String orfandad) {
        return "si".equals(orfandad);
    }
    
    public static Iban generarIban(String pais, String digitosControl, String numeroCuenta) {
        Iban i = new Iban();
        
        i.setPaisIban(pais);
        i.setDigitosControlIban(digitosControl);
        i.setNumeroCuentaIban(numeroCuenta);
        
        return i;
    }
    
    public static boolean generarConsentimiento(String consentimiento) {
        return "si".equals(consentimiento);
    }
}
