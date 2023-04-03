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
        <script defer src="./js/familiaresFormulario.js"></script>
    </head>
    <body>
        <!-- Comprobación usuario autenticado -->
        <%
        if (session.getAttribute("usuarioAutenticado") == null) {
            response.sendRedirect("login.jsp");
        }
        %>

        <!-- HEADER -->
        <jsp:include page="./header.jsp" />

        <main class="container">
            <div id="formContainer" class="row bg-body-tertiary p-5 rounded-3">
                <div class="col-12 border-bottom">
                    <h3>Solicitar Beca CertiSign</h3>
                </div>
                <div class="col-12 mt-4">
                    <!-- MENSAJES -->
                    <%if (request.getAttribute("error") != null) {%>
                    <div class="alert alert-danger alert-dismissible fade show px-5">
                        <span class="m-0">${error}. Operación cancelada</span>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%}%>
                    
                    <form id="formulario" method="post" action="GenerarPDFServlet" class="row g-3">
                        <!-- DATOS PERSONALES -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Datos Personales</h5>
                        </div>
                        <div class="col-md-4">
                            <label for="nombreInput" class="form-label">Nombre:</label>
                            <input type="text" id="nombreInput" class="form-control" name="nombre" value="${sessionScope.usuarioAutenticado.firstName}" disabled>    
                        </div>
                        <div class="col-md-4">
                            <label for="apellidosInput" class="form-label">Apellidos:</label>
                            <input type="text" id="apellidosInput" class="form-control" name="apellidos" value="${sessionScope.usuarioAutenticado.lastName}" disabled>    
                        </div>
                        <div class="col-md-4">
                            <label for="dniInput" class="form-label">DNI:</label>
                            <input type="text" id="dniInput" class="form-control" name="dni" value="${sessionScope.usuarioAutenticado.numberUserId}" disabled>    
                        </div>
                        <div class="col-md-4">
                            <label for="fNacimientoInput" class="form-label">Fecha Nacimiento:</label>
                            <input type="date" id="fNacimientoInput" class="form-control" name="fechaNacimiento" value="2001-04-06">    
                        </div>
                        <div class="col-md-4">
                            <label for="emailInput" class="form-label">Correo Electrónico:</label>
                            <input type="email" id="emailInput" class="form-control" name="email" value="anmamebo2001@gmail.com">    
                        </div>
                        <div class="col-md-4">
                            <label for="telefonoInput" class="form-label">Teléfono Móvil:</label>
                            <input type="text" id="telefonoInput" class="form-control" name="telefono" value="627660577">    
                        </div>
                        
                        <!-- DOMICILIO -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Domicilio</h5>
                        </div>
                        <div class="col-md-6">
                            <label for="calleInput" class="form-label">Calle:</label>
                            <input type="text" id="calleInput" class="form-control" name="calle" value="Santa Bárbara">    
                        </div>
                        <div class="col-md-3">
                            <label for="numeroCalleInput" class="form-label">Nº:</label>
                            <input type="text" id="numeroCalleInput" class="form-control" name="numeroCalle" value="50">    
                        </div>
                        <div class="col-md-3">
                            <label for="cpInput" class="form-label">Código Postal:</label>
                            <input type="text" id="cpInput" class="form-control" name="codigoPostal" value="41870">    
                        </div>
                        <div class="col-md-6">
                            <label for="ciudadInput" class="form-label">Ciudad:</label>
                            <input type="text" id="ciudadInput" class="form-control" name="ciudad" value="Aznalcóllar">    
                        </div>
                        <div class="col-md-6">
                            <label for="provinciaSelect" class="form-label">Provincia:</label>
                            <select id="provinciaSelect" class="form-select" name="provincia">    
                                <option value=""  disabled>Selecciona una provincia</option>
                                <option value="alava">Álava</option>
                                <option value="albacete">Albacete</option>
                                <option value="alicante">Alicante</option>
                                <option value="almeria">Almería</option>
                                <option value="asturias">Asturias</option>
                                <option value="avila">Ávila</option>
                                <option value="badajoz">Badajoz</option>
                                <option value="barcelona">Barcelona</option>
                                <option value="burgos">Burgos</option>
                                <option value="caceres">Cáceres</option>
                                <option value="cadiz">Cádiz</option>
                                <option value="cantabria">Cantabria</option>
                                <option value="castellon">Castellón</option>
                                <option value="ceuta">Ceuta</option>
                                <option value="ciudadreal">Ciudad Real</option>
                                <option value="cordoba">Córdoba</option>
                                <option value="cuenca">Cuenca</option>
                                <option value="girona">Girona</option>
                                <option value="granada">Granada</option>
                                <option value="guadalajara">Guadalajara</option>
                                <option value="guipuzcoa">Guipúzcoa</option>
                                <option value="huelva">Huelva</option>
                                <option value="huesca">Huesca</option>
                                <option value="illesbalears">Illes Balears</option>
                                <option value="jaen">Jaén</option>
                                <option value="larioja">La Rioja</option>
                                <option value="las_palmas">Las Palmas</option>
                                <option value="leon">León</option>
                                <option value="lleida">Lleida</option>
                                <option value="lugo">Lugo</option>
                                <option value="madrid">Madrid</option>
                                <option value="malaga">Málaga</option>
                                <option value="melilla">Melilla</option>
                                <option value="murcia">Murcia</option>
                                <option value="navarra">Navarra</option>
                                <option value="ourense">Ourense</option>
                                <option value="palencia">Palencia</option>
                                <option value="pontevedra">Pontevedra</option>
                                <option value="salamanca">Salamanca</option>
                                <option value="segovia">Segovia</option>
                                <option value="sevilla" selected>Sevilla</option>
                                <option value="soria">Soria</option>
                                <option value="tarragona">Tarragona</option>
                                <option value="tenerife">Tenerife</option>
                                <option value="teruel">Teruel</option>
                                <option value="toledo">Toledo</option>
                                <option value="valencia">Valencia</option>
                                <option value="valladolid">Valladolid</option>
                                <option value="vizcaya">Vizcaya</option>
                                <option value="zamora">Zamora</option>
                                <option value="zaragoza">Zaragoza</option>
                            </select>
                        </div>
                        
                        <!-- DATOS ACADÉMICOS -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Datos Académicos</h5>
                        </div>
                        <label class="form-label col-4">¿Posee algún título universitario o grado superior?</label>
                        <div class="col-8">
                            <input class="form-check-input" type="radio" name="tieneTitulo" id="tieneTitulo1" value="si">
                            <label class="form-check-label me-4" for="tieneTitulo1">Sí</label>
                            <input class="form-check-input" type="radio" name="tieneTitulo" id="tieneTitulo2" value="no" checked>
                            <label class="form-check-label" for="tieneTitulo2">No</label>
                        </div>
                        <div class="col-md-4">
                            <label for="universidadInput" class="form-label">Universidad:</label>
                            <input type="text" id="universidadInput" class="form-control" name="universidad" value="Pablo de Olavide Sevilla">    
                        </div>
                        <div class="col-md-8">
                            <label for="estudiosInput" class="form-label">Curso y Estudios que va a realizar:</label>
                            <input type="text" id="estudiosInput" class="form-control" name="estudios" value="4º - Graduado en Ingeniería Informática en Sistemas de Información">    
                        </div>
                        
                        <!-- FAMILIARES -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Familiares</h5>
                        </div>
                        <div class="col-6">
                            <label for="dniFamiliaresInput" class="form-label">DNI:</label>
                            <div id="dniFamiliaresInput">
                                <div class="mb-2">
                                    <input type="text" class="form-control" name="dniFamiliares[]" id="dniFamiliares" value="45839432J">
                                </div>
                            </div>
                        </div>
                        <div class="col-6">
                            <label for="nombreFamiliaresInput" class="form-label">Nombre:</label>
                            <div id="nombreFamiliaresInput">
                                <div class="mb-2">
                                    <input type="text" class="form-control" name="nombreFamiliares[]" id="nombreFamiliares" value="Carmen Elena Borrero Alamillo">
                                </div>
                            </div>
                        </div>
                        <button type="button" class="col-2 btn btn-light border mt-1 me-3" id="addFamiliar">Añadir</button>
                        <button type="button" class="col-2 btn btn-light border mt-1" id="removeFamiliar">Quitar</button>
                        
                        <!-- DATOS FAMILIARES CON REPERCUSIÓN ECONÓMICA -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Datos familiares con repercusión económica:</h5>
                        </div>
                        <label class="form-label col-4">¿Condición de familia numerosa?</label>
                        <div class="col-8">
                            <input class="form-check-input" type="radio" name="familiaNumerosa" id="familiaNumerosa1" value="si">
                            <label class="form-check-label me-4" for="familiaNumerosa1">Sí</label>
                            <input class="form-check-input" type="radio" name="familiaNumerosa" id="familiaNumerosa2" value="no" checked>
                            <label class="form-check-label" for="familiaNumerosa2">No</label>
                        </div>
                        <label class="form-label col-4">¿Independiente?</label>
                        <div class="col-8">
                            <input class="form-check-input" type="radio" name="independiente" id="independiente1" value="si">
                            <label class="form-check-label me-4" for="independiente1">Sí</label>
                            <input class="form-check-input" type="radio" name="independiente" id="independiente2" value="no" checked>
                            <label class="form-check-label" for="independiente2">No</label>
                        </div>
                        <label class="form-label col-4">¿Orfandad absoluta?</label>
                        <div class="col-8">
                            <input class="form-check-input" type="radio" name="orfandad" id="orfandad1" value="si">
                            <label class="form-check-label me-4" for="orfandad1">Sí</label>
                            <input class="form-check-input" type="radio" name="orfandad" id="orfandad2" value="no" checked>
                            <label class="form-check-label" for="orfandad2">No</label>
                        </div>
                        
                        <!-- DATOS DE IBAN -->
                        <div class="col-12">
                            <h5 class="text-uppercase">Datos de IBAN</h5>
                        </div>
                        <div class="col-md-2">
                            <label for="paisIbanInput" class="form-label">País:</label>
                            <input type="text" id="paisIbanInput" class="form-control" name="paisIban" placeholder="ES" value="ES">    
                        </div>
                        <div class="col-md-2">
                            <label for="dControlIbanInput" class="form-label">Digitos control:</label>
                            <input type="text" id="dControlIbanInput" class="form-control" name="dControlIban" placeholder="XX" value="07">    
                        </div>
                        <div class="col-md-8">
                            <label for="nCuentaIbanInput" class="form-label">Nº de cuenta:</label>
                            <input type="text" id="nCuentaIbanInput" class="form-control" name="nCuentaIban" placeholder="XXXX XXXX XXXX XXXX XXXX" value="2345 8762 7823 7234 6882">    
                        </div>
                        
                        <!-- CONSENTIMIENTO -->
                        <div class="col-12">
                            <div class="form-check mt-5">
                                <input type="checkbox" id="checkbox" class="form-check-input" name="verificacionIdentidad" value="si" checked>
                                <label for="checkbox" class="form-check-label">Consiente la verificación de identidad.</label>
                            </div>
                        </div>
                        <div class="col-12">
                            <p>Deseo participar en el procedimiento de la Beca CertiSign, a tal efecto firmo este documento.</p>
                        </div>
                        
                        <!-- SUBMIT -->
                        <div class="col-12">
                            <input type="submit" class="btn btn-dark mt-1 px-5 py-2" value="Firmar">
                        </div>
                    </form>
                </div>
            </div>
        </main>

        <!-- FOOTER -->
        <jsp:include page="./footer.jsp" />
    </body>
</html>