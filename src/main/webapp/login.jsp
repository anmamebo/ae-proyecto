<%-- 
    Document   : login
    Created on : 03-abr-2023, 1:17:21
    Author     : anmam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn | CertiSign</title>
    </head>
    <body>
        <!-- Comprobación usuario autenticado -->
        <%
        if (session.getAttribute("usuarioAutenticado") != null) {
            response.sendRedirect("index.jsp");
        }
        %>
        
        <!-- HEADER -->
        <jsp:include page="./header.jsp" />

        <main class="container my-5">
            <div id="buttonContainer" class="row align-items-center justify-content-center text-center bg-body-tertiary p-5 rounded-3">
                <a href="SolicitarAutenticacionViafirmaServlet" class="col-3 btn btn-dark">
                    Acceder con Certificado Digital
                </a>
            </div>
        </main>
            
        <!-- FOOTER -->
        <jsp:include page="./footer.jsp" />
    </body>
</html>
