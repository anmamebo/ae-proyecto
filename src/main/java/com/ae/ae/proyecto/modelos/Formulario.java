/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ae.ae.proyecto.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anmam
 */
public class Formulario {

    private Persona datosPersonales;
    private Direccion direccion;
    private boolean tieneTitulo;
    private Estudios estudios;
    private List<Familiar> familiares;
    private boolean familiaNumerosa;
    private boolean independiente;
    private boolean orfandad;
    private Iban iban;
    private boolean consentimiento;

    public Formulario() {
        this.familiares = new ArrayList<>();
    }

    public Persona getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(Persona datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isTieneTitulo() {
        return tieneTitulo;
    }

    public void setTieneTitulo(boolean tieneTitulo) {
        this.tieneTitulo = tieneTitulo;
    }

    public Estudios getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

    public List<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(List<Familiar> familiares) {
        this.familiares = familiares;
    }

    public boolean isFamiliaNumerosa() {
        return familiaNumerosa;
    }

    public void setFamiliaNumerosa(boolean familiaNumerosa) {
        this.familiaNumerosa = familiaNumerosa;
    }

    public boolean isIndependiente() {
        return independiente;
    }

    public void setIndependiente(boolean independiente) {
        this.independiente = independiente;
    }

    public boolean isOrfandad() {
        return orfandad;
    }

    public void setOrfandad(boolean orfandad) {
        this.orfandad = orfandad;
    }

    public Iban getIban() {
        return iban;
    }

    public void setIban(Iban iban) {
        this.iban = iban;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }
}
