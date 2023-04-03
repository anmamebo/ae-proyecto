/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ae.ae.proyecto.modelos;

/**
 *
 * @author anmam
 */
public class Estudios {

    private String nombreUniversidad;
    private String cursoYEstudios;

    public Estudios(String nombreUniversidad, String cursoYEstudios) {
        this.nombreUniversidad = nombreUniversidad;
        this.cursoYEstudios = cursoYEstudios;
    }

    public Estudios() {
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public String getCursoYEstudios() {
        return cursoYEstudios;
    }

    public void setCursoYEstudios(String cursoYEstudios) {
        this.cursoYEstudios = cursoYEstudios;
    }   
}
