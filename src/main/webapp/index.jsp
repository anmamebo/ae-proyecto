<%-- 
    Document   : index
    Created on : 30-mar-2023, 20:56:09
    Author     : Antonio Manuel Mérida Borrero
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="./header.jsp" />

        <main class="container-fluid">
            <form action="SolicitarAutenticacionViafirmaServlet">
                <input class="btn btn-dark" type="submit" value="Acceder con Certificado Digital">
            </form>
        </main>
    </body>
</html>
