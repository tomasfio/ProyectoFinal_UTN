<%@page import="Main.Negocio.UsuarioLogic"%>
<%@page import="Main.Entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="es">
<head>
	<style type="text/css">
    	<%@include file="css/styles-css/cp-styles.css"%>
    	<%@include file="css/bootstrap.min.css"%>
    	<%@include file="css/shop-homepage.css"%>
    </style>
</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <p class="lead">Bienvenido <%//Usuario%></p>
                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation"><a href="ListaUsuario">Listado de usuarios</a></li>
                         <li role="presentation"><a href="ListaMarca">Listado de marcas</a></li>
                         <li role="presentation"><a href="ListaCategoria">Listado de categorias</a></li>
                    </ul>
                </div>

                <div class="col-md-7 col-md-offset-1">
                    <% 
                    	if(request.getAttribute("usuario") != null)
                    	{
                    %>
                    <form class="form-group" action="BajaModifUsuario" method="GET">
                    <%
                    		Usuario usu = (Usuario)request.getAttribute("usuario");  
                    		if(request.getAttribute("accion") == "update")
                    		{
                     %>
                        <h1>Modificación de usuario</h1>
                        <hr>
                            <div class="form-group">
                                <label for="id">ID seleccionado:</label>
                                <input type="number" class="form-control" name="id_modificar" value="<%=usu.getIdUsuario() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" name="nombre_modificar" value="<%=usu.getNombre() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="apellido">Apellido:</label>
                                <input type="text" class="form-control" name="apellido_modificar" value="<%=usu.getApellido() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="email">E-Mail:</label>
                                <input type="email"  class="form-control" name="email_modificar" value="<%=usu.getEmail() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="localidad">Localidad:</label>
                                <input type="text"  class="form-control" name="localidad_modificar" value="<%=usu.getLocalidad() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono:</label>
                                <input type="text"  class="form-control" name="telefono_modificar" value="<%=usu.getTelefono() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="celular">Celular:</label>
                                <input type="text"  class="form-control" name="celular_modificar" value="<%=usu.getCelular() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="usuario">Usuario:</label>
                                <input type="text"  class="form-control" name="usuario_modificar" value="<%=usu.getUsuario() %>" required>
                            </div>
                            <div class="form-group">
                              <button type="submit" class="btn btn-warning" id="btnUpdate" name="btnUpdate" value="update">Modificar</button>
                            </div>
                    <% } else if(request.getAttribute("accion") == "delete"){ %>
	                        <h1>Baja de un usuario</h1>
	                        <hr>
                            <div class="form-group">
                                <label for="id">ID seleccionado:</label>
                                <input type="number" class="form-control" name="id_baja" id="id_baja" value="<%=usu.getIdUsuario() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" id="nombre_baja" value="<%=usu.getNombre() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="apellido">Apellido:</label>
                                <input type="text" class="form-control" id="apellido_baja" value="<%=usu.getApellido() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="email">E-Mail:</label>
                                <input type="email" class="form-control" id="email_baja" value="<%=usu.getEmail() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="localidad">Localidad:</label>
                                <input type="text"  class="form-control" id="localidad_baja" value="<%=usu.getLocalidad() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono:</label>
                                <input type="text"  class="form-control" id="telefono_baja" value="<%=usu.getTelefono() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="celular">Celular:</label>
                                <input type="text"  class="form-control" id="celular_baja" value="<%=usu.getCelular() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="usuario">Usuario:</label>
                                <input type="text" class="form-control" id="usuario_baja" value="<%=usu.getUsuario() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="contrase�a">Contraseña:</label>
                                <input type="password" class="form-control" id="password_baja" value="<%=usu.getContrase�a() %>" readonly="readonly">
                            </div>
	                        <div class="form-group">
                                <button type="submit" class="btn btn-warning" id="btnDelete" name="btnDelete" value="delete">Eliminar</button>
	                        </div>
                   	 	<% 
	                    	} 
						%>
                            </form>
                        <%
	                    } 
                   		else 
                   		{ 
                   		%>
                        <h1>Gestión de un cliente</h1>
                        <hr>
                        <div class="alert alert-danger">No existe un usuario con el ID ingresado, o ha ocurrido un error en la transacción.</div>
                        <a class="btn btn-primary" href="ListaUsuario" role="button">Volver al listado</a>
                    	<% 
                   		} 
                    	%>
                </div>
        </div>
		</div>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
