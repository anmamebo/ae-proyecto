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
        <title>Inicio | CertiSign</title>
    </head>
    <body>
        <!-- HEADER -->
        <jsp:include page="./header.jsp" />

        <main class="container my-5">
            <div id="buttonContainer" class="row align-items-center justify-content-center text-center bg-body-tertiary p-5 rounded-3">
                <%if (session.getAttribute("usuarioAutenticado") != null) {%>
                <a href="formulario.jsp" class="col-3 btn btn-dark">
                    Rellenar formulario
                </a>
                <%} else {%>
                <a href="SolicitarAutenticacionViafirmaServlet" class="col-3 btn btn-dark">
                    Acceder con Certificado Digital
                </a>
                <%}%>
            </div>
        </main>
            
        <!-- FOOTER -->
        <jsp:include page="./footer.jsp" />
    </body>
</html>
