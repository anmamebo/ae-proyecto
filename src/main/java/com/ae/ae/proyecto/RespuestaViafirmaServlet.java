/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ae.ae.proyecto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.viafirma.cliente.ViafirmaClientServlet;
import org.viafirma.cliente.exception.CodigoError;
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
        /* Lógica específica de la aplicación para gestionar el resultado de la firma */
        request.setAttribute("resultado", firma);
        try {
            request.getRequestDispatcher("/resultadoFirma.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void authenticateOK(UsuarioGenericoViafirma usuario, HttpServletRequest request, HttpServletResponse response) {
        // Lógica específica de cada aplicación para gestionar el resultado de la autenticación
        try {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioAutenticado", usuario);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancel(HttpServletRequest request, HttpServletResponse response) {
        // Gestión de cancelación del usuario al autenticar o firmar
        try {
            request.setAttribute("error", "El usuario ha cancelado la autenticación");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void error(CodigoError codError, HttpServletRequest request, HttpServletResponse response) {
        // Gestión de error al autenticar o firmar
        try {
            request.setAttribute("codError", codError);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
