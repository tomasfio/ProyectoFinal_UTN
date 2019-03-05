<%@page import="java.util.ArrayList" %>
<%@page import="Main.Entidades.*" %>

<!doctype html>
<html lang="en">
  <head>
    <title>Mayorista</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style type="text/css">
    	<%@include file="css/shop-homepage.css"%>
    	<%@include file="../../css/pagination.css"%>
   	</style> 
   	<style>
	  .modal-header, h4, .close {
	    background-color: #5cb85c;
	    color:white !important;
	    text-align: center;
	    font-size: 30px;
	  }
	  .modal-footer {
	    background-color: #f9f9f9;
	  }
  	</style>
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  	
  	<script type="text/javascript">
  	<%
  	if(request.getAttribute("venta") != null){
  	    if((boolean)request.getAttribute("venta")){
  	    	%>alert('Se ha registrado la venta con exito');<%
  	    }
  	    else{
  	        %>alert('Hubo un error y no se ha podido registrar la venta');<%
  	    }
  	}
  	%>
  	</script>
  	
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
				                            <li><a href="" data-toggle="modal" data-target="#modalLogin"><span class="glyphicon glyphicon-log-in"></span> Iniciar sesion</a></li>
										<%
									}
								%>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- nav -->
            
             <!-- Modal login -->
		    <div class="modal face" id="modalLogin" role="dialog">
			    <div class="modal-content">
			      <div class="modal-header" style="padding:35px 50px;">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
			      </div>
			      <form action="SingIn" method="post">
				      <div class="modal-body" style="padding:40px 50px;">
				        <div class="form-group">
			              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Usuario</label>
			              <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Ingresa usuario" required>
			            </div>
			            <div class="form-group">
			              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
			              <input type="password" class="form-control" id="pass" name="pass" placeholder="Ingresa password" required>
			            </div>
              			<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
				      </div>
				      <div class="modal-footer">
				        <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cerrar</button>
				      </div>
			      </form>
			    </div>
		    </div>
            
           <!-- Page Content -->
           <div class="container">
       		<div class="row">
       		
       			<div class="col-md-3">
       			
          			<p class="lead">Buscar produto</p>
			          	<div class="panel-group">
			   				<form action="#" method="post">
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
				                     				<h5><a href="Index?idCat=<%=cat.getIdCategoria() %>" ><%=cat.getNombre() %></a></h5>
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
		               	 			if(request.getAttribute("listaMarca") != null){
			                     		ArrayList<Marca> marcas = (ArrayList<Marca>)request.getAttribute("listaMarca");
			                     		for(Marca mar : marcas){
			                     			%>
				                     			<div class="panel-heading">
			                     					<h5></body><a href="Index?idCat=<%=mar.getIdMarca() %>" ><%=mar.getNombre() %></a></h5>
		           								</div>
			                     			<%
			                     		}
			                     	}
		               	 			%>
		               	 		</ul>
		               	 	</div>
		               	 </div>
               	 
       		 </div>
       		 
       		 <div class="col-md-9">
       		 	<div class="col-md-12">
                        <h1 align="center">Carrito de compras</h1>
                        	<table class="table table-striped">
                        		<thead>
                        			<tr>
                        				<td><b>Producto</b></td>
                        				<td><b>Cantidad</b></td>
                        				<td><b>Subtotal</b></td>
                       				</tr>
                   				</thead> 
                   				<tbody>
                   					<%
                   					if(request.getSession().getAttribute("carrito") != null)
                   					{
                   						Movimiento carrito = (Movimiento)request.getSession().getAttribute("carrito");

                   						ArrayList<Movistock> detalles = (ArrayList<Movistock>)carrito.getDetalles();
                   						for(Movistock detalle : detalles)
                   						{
                   							%>
                   								<tr>
                   									<td><%=detalle.getProducto().getNombre() %></td>
                   									<td><%=detalle.getCantidad() %></td>
                   									<td><%=detalle.getSubtotal() %></td>
                   								</tr>
                   							<%
                   						}
                   						%>
                   						</tbody>
	                   				<tfoot>
	                   					<tr>
	                   						<td>Total <%=carrito.getImporte() %></td>
	                   					</tr>
	                   				</tfoot>
                   					<%
                   					}
                				%>
                        	</table>
                        	<form action="RegistrarVenta" method="post">
                       			<input class="form-control" type="text" name="direccion" id="direccion" placeholder="direccion donde se realiza la entrega"/>
                       			 <%
				                	if(request.getAttribute("faltaDireccion") != null)
				                	{
				                		%>
				                		<p style="color : red;"><%=request.getAttribute("faltaDireccion") %></p>
				                		<%
				               		} 
			               		%>
                       			<br>
                       			<input class="form-control" type="text" name="observacion" id="observacion" placeholder="Comentarios u observaciones del pedido" /><br><br>
                       			<button class="btn btn-warning" type="submit" name="btnRegistrar" value="registrar">Registrar venta</button>
                      			<div class="form-group pull-right">
                            		 <button type="submit" class="btn btn-danger" name="btnDelete" value="delete">Vaciar carrito</button>
                       	 		</div>
                        	</form>
                    </div>
       		 </div>
          </div>
       </div>
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
  </body>
</html>