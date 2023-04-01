<%-- 
    Document   : header
    Created on : 02-abr-2023, 0:47:21
    Author     : anmam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    </head>
    <body>
        <header class="p-4 mb-3 border-bottom">
            <div class="container-fluid">
                <div class="row align-items-center justify-content-between">
                    <!-- LOGO -->
                    <div class="col-4 text-start">
                        <a href="index.jsp" class="link-body-emphasis text-decoration-none">
                            <span class="fs-4">Simple header</span>
                        </a>    
                    </div>
                    <!-- CERRAR SESIÓN -->
                    <div class="col-4 text-end">
                        <%if (session.getAttribute("usuarioAutenticado") != null) {%>
                        <a href="CerrarSesionServlet" class="link-dark text-decoration-none">
                            Cerrar sesión
                        </a>
                        <%}%>
                    </div>
                </div>
            </div>
        </header>
    </body>
</html>
