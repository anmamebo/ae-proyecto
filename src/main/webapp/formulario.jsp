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
        <title>Formulario</title>
    </head>
    <body>
        <!-- Comprobación usuario autenticado -->
        <%
            if (session.getAttribute("usuarioAutenticado") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <!-- HEADER -->
        <jsp:include page="./header.jsp" />

        <main class="container-fluid">
            <h2>Formulario</h2>
            <%if (request.getAttribute("error") != null) {%>
            <p class="message error">${error}. Operación cancelada</p>
            <%} else { %>
            <form id="formulario" method="post" action="GenerarPDFServlet">
                <label for="nombreInput">Nombre:</label>
                <input type="text" id="nombreInput" name="nombre" value="${sessionScope.usuarioAutenticado.firstName}" readonly>
                <label for="apellidosInput">Apellidos:</label>
                <input type="text" id="apellidosInput" name="apellidos" value="${sessionScope.usuarioAutenticado.lastName}" readonly>
                <label for="dniInput">DNI:</label>
                <input type="text" id="dniInput" name="dni" value="${sessionScope.usuarioAutenticado.numberUserId}" readonly>

                <br>

                <input type="checkbox" id="checkbox" name="verificacionIdentidad" value="si">
                <label for="checkbox">Consiente la verificación de identidad.</label>

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