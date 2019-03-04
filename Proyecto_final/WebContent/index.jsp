<%@page import="java.util.ArrayList" %>

<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  </head>
  <body>
        <body>
                <!-- Navigation -->
                <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                    <div class="container">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Navegaci�n</span>
                            </button>
                            <a class="navbar-brand" href="Index">Menu principal</a>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li>
                                    <a href="Contacto">Contacto</a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <%
									if(request.getSession().getAttribute("user") != null){
										Usuario usu = (Usuario)request.getSession().getAttribute("user");
										%> 
			                    			<li><a href="CarritoCompra"><span class="glyphicon glyphicon-shopping-cart"></span> Ir al carro</a></li>
											<li><a href="LogOut"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesion</a></li>
										<%
									}
									else
									{
										%>
											<li><a href="registro-login.jsp">Registrarse</a></li>
				                            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar sesion</a></li>
										<%
									}
								%>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- nav -->
            
                <!-- Page Content -->
                <div class="container">
            		<div class="row">
            <div class="col-md-3">
            	<p class="lead">Buscar libro</p>
            	<div class="panel-group">
       				<form action="BuscarLibro" method="post">
               			<input type="text" class="form-control" name="busca" id="busca" placeholder="Buscar..." />
               		</form>
           		</div>
            	
                <p class="lead">Categorias</p>

                <div class="panel-group">
                  <div class="panel panel-default">
                     <ul class="list-group">
	                     <%
	                     	if(request.getAttribute("listaCategoria") != null){
	                     		ArrayList<Categoria> categorias = (ArrayList<Categoria>)request.getAttribute("listaCategoria");
	                     		for(Categoria cat : categorias){
	                     			%>
	                     			<div class="panel-heading">
	                     				<h4 class="panel-title"><a href="Index?idCat=<%=cat.getIdCategoria() %>" ><%=cat.getNombre() %></a></h4>
                     				</div>
	                     			<%
	                     		}
	                     	}
	                     %>
                     </ul>
                   </div>
               	 </div>
               	 <p class="lead">Marcas</p>
               	 <div class="panel-group">
               	 	<div class="panel panel-default">
               	 		<ul class="list-group">
               	 			<%
               	 			if(request.getAttribute("listaMarcas") != null){
	                     		ArrayList<Marca> marcas = (ArrayList<Marca>)request.getAttribute("listaMarca");
	                     		for(Marca mar : marcas){
	                     			%>
	                     			<div class="panel-heading">
	                     				<h4 class="panel-title"><a href="Index?idCat=<%=mar.getIdMarca() %>" ><%=mar.getNombre() %></a></h4>
	                 				</div>
	                     			<%
	                     		}
	                     	}
               	 			%>
               	 		</ul>
               	 	</div>
               	 </div>
       		 </div>
          </div>
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>