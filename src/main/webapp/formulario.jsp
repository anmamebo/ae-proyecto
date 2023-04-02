<%-- 
    Document   : formulario
    Created on : 01-abr-2023, 20:38:05
    Author     : Antonio Manuel Mérida Borrero
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.viafirma.cliente.vo.UsuarioGenericoViafirma"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario | CertiSign</title>
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

        <main class="container">
            <div id="formContainer" class="row bg-body-tertiary p-5 rounded-3">
                <div class="col-12 border-bottom">
                    <h2>Formulario</h2>
                </div>
                <div class="col-12 mt-5">
                    <%if (request.getAttribute("error") != null) {%>
                    <div class="alert alert-danger alert-dismissible fade show px-5">
                        <span class="m-0">${error}. Operación cancelada</span>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%}%>
                    <form id="formulario" method="post" action="GenerarPDFServlet" class="row g-3">
                        <div class="col-md-4">
                            <label for="nombreInput" class="form-label">Nombre:</label>
                            <input type="text" id="nombreInput" class="form-control" name="nombre" value="${sessionScope.usuarioAutenticado.firstName}" readonly>    
                        </div>
                        <div class="col-md-4">
                            <label for="apellidosInput" class="form-label">Apellidos:</label>
                            <input type="text" id="apellidosInput" class="form-control" name="apellidos" value="${sessionScope.usuarioAutenticado.lastName}" readonly>    
                        </div>
                        <div class="col-md-4">
                            <label for="dniInput" class="form-label">DNI:</label>
                            <input type="text" id="dniInput" class="form-control" name="dni" value="${sessionScope.usuarioAutenticado.numberUserId}" readonly>    
                        </div>
                        <div class="col-12">
                            <div class="form-check">
                                <input type="checkbox" id="checkbox" class="form-check-input" name="verificacionIdentidad" value="si">
                                <label for="checkbox" class="form-check-label">Consiente la verificación de identidad.</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <p>
                                Deseo participar en el procedimiento de PRUEBA, a tal efecto firmo este documento.
                            </p>
                        </div>
                        
                        <div class="col-12">
                            <input type="submit" class="btn btn-dark mt-1" value="Firmar">
                        </div>
                    </form>
                </div>
            </div>
        </main>

        <!-- FOOTER -->
        <jsp:include page="./footer.jsp" />
    </body>
</html>