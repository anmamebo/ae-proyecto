/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ae.ae.proyecto.modelos;

/**
 *
 * @author anmam
 */
public class Iban {

    private String paisIban;
    private String digitosControlIban;
    private String numeroCuentaIban;

    public Iban(String paisIban, String digitosControlIban, String numeroCuentaIban) {
        this.paisIban = paisIban;
        this.digitosControlIban = digitosControlIban;
        this.numeroCuentaIban = numeroCuentaIban;
    }

    public Iban() {
    }

    public String getPaisIban() {
        return paisIban;
    }

    public void setPaisIban(String paisIban) {
        this.paisIban = paisIban;
    }

    public String getDigitosControlIban() {
        return digitosControlIban;
    }

    public void setDigitosControlIban(String digitosControlIban) {
        this.digitosControlIban = digitosControlIban;
    }

    public String getNumeroCuentaIban() {
        return numeroCuentaIban;
    }

    public void setNumeroCuentaIban(String numeroCuentaIban) {
        this.numeroCuentaIban = numeroCuentaIban;
    }
}
