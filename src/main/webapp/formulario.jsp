<%-- 
    Document   : formulario
    Created on : 01-abr-2023, 20:38:05
    Author     : Antonio Manuel Mérida Borrero
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.viafirma.cliente.vo.UsuarioGenericoViafirma"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticación</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    </head>
    <body>


        <!-- Comprobación usuario autenticado -->
        <%
            if (request.getAttribute("usuarioAutenticado") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

    <main class="container-fluid">
        <h2>Formulario</h2>
        <%if (request.getAttribute("error") != null) {%>
        <p class="message error">${error}. Operación cancelada</p>
        <%} else { %>
        <form>
            <label>Nombre:</label>
            <input type="text" value="${usuarioAutenticado.firstName}" disabled>
            <label>Apellidos:</label>
            <input type="text" value="${usuarioAutenticado.lastName}" disabled>
            <label>DNI:</label>
            <input type="text" value="${usuarioAutenticado.numberUserId}" disabled>
            
            <br>
            
            <input type="checkbox" id="checkbox1" name="" value="1">
            <label for="checkbox1">Consiente la verificación de identidad.</label>
            
            <br>
            
            Deseo participar en el procedimiento de PRUEBA, a tal efecto firmo este documento.
            
            <br>
            
            <input type="submit" value="Firmar">
        </form>
        <%}%>
        <p>
            <a href="index.jsp">&larr; Inicio</a>
        </p>
    </main>
</body>
</html>