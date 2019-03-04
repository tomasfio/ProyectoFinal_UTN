<%@page import="Main.Negocio.MarcaLogic"%>
<%@page import="Main.Entidades.Marca"%>
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
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	       <div class="container">
	           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	               <ul class="nav navbar-nav navbar-right">
						<li><a href="LogOut"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesi�n</a></li>
	               </ul>
	           </div>
	       </div>
	   </nav>
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
                    	if(request.getAttribute("marca") != null)
                    	{
                    %>
                    <form class="form-group" action="BajaModifMarca" method="GET">
                    <%
                    		Marca mar = (Marca)request.getAttribute("marca");  
                    		if(request.getAttribute("accion") == "update")
                    		{
                     %>
                        <h1>Modificación de marca</h1>
                        <hr>
                            <div class="form-group">
                                <label for="id">ID seleccionado:</label>
                                <input type="number" class="form-control" name="id_modificar" value="<%=mar.getIdMarca() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" name="nombre_modificar" value="<%=mar.getNombre() %>" required>
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripcion:</label>
                                <input type="text" class="form-control" name="descripcion_modificar" value="<%=mar.getDescripcion() %>" required>
                            </div>
                            
                            <div class="form-group">
                              <button type="submit" class="btn btn-warning" id="btnUpdate" name="btnUpdate" value="update">Modificar</button>
                            </div>
                    <% } else if(request.getAttribute("accion") == "delete"){ %>
	                        <h1>Baja de una marca</h1>
	                        <hr>
                            <div class="form-group">
                                <label for="id">ID seleccionado:</label>
                                <input type="number" class="form-control" name="id_baja" id="id_baja" value="<%=mar.getIdMarca() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" id="nombre_baja" value="<%=mar.getNombre() %>" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="descripcion">Descripcion:</label>
                                <input type="text" class="form-control" id="descripcion_baja" value="<%=mar.getDescripcion() %>" readonly="readonly">
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
                        <h1>Gestión de una marca</h1>
                        <hr>
                        <div class="alert alert-danger">No existe una marca con el ID ingresado, o ha ocurrido un error en la transacción.</div>
                        <a class="btn btn-primary" href="ListaMarca" role="button">Volver al listado</a>
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