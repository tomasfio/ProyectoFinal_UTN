<%@page import="Main.Negocio.MarcaLogic"%>
<%@page import="Main.Entidades.Marca" %>
<%@page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html lang="es">
<head>

		<style type="text/css">
	    	<%@include file="css/styles-css/cp-styles.css"%>
	    	<%@include file="css/bootstrap.min.css"%>
	    	<%@include file="css/shop-homepage.css"%>
	    	<%@include file="../../css/pagination.css"%>
    	</style>

    </head>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	       <div class="container">
	           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	               <ul class="nav navbar-nav navbar-right">
						<li><a href="LogOut"><span class="glyphicon glyphicon-log-out"></span> Cerrar sesión</a></li>
	               </ul>
	           </div>
	       </div>
	   </nav>
        <div class="container">
        <div class="row">
                <div class="col-md-3">
                    <p class="lead">Bienvenido </p>
                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation"><a href="ListaUsuario">Listado de usuarios</a></li>
                        <li role="presentation"><a href="ListaMarca">Listado de marcas</a></li>
                        <li role="presentation"><a href="ListaCategoria">Listado de categorias</a></li>
                    </ul>
                </div>

                <div class="col-md-7 col-md-offset-1">
                    <h1>Listado de marcas</h1>

                    <hr>
                     <form class="form-inline" action="MarcaABM" method="GET">
                          <div class="form-group">
                              <a class="btn btn-success" href="admin-alta-marca.jsp" role="button">Nueva marca</a>
                          </div>
                          <div class="form-group pull-right">
                              <input type="number" min='0' class="form-control" name="id_marca" id="id_marca" placeholder="Ingrese ID" required>
                              <button type="submit" class="btn btn-warning" id="btnUpdate" name="btnUpdate" value="update">Modificar</button>
                              <button type="submit" class="btn btn-danger" id="btnUpdate" name="btnDelete" value="delete">Eliminar</button>
                          </div>
                      </form>
                      <%
	                      if(request.getAttribute("existeMarca") != null){
	                      	if(!(boolean)request.getAttribute("existeMarca")){
                      %><p>El id ingresado no pertenece a ninguna marca registrada en el sistema</p><%
                      		}
                      	}
                      %>
                      <br>

                      <table class="table table-striped">
                          <thead>
                              <tr>
                                  <td><b>ID</b></td>
                                  <td><b>Nombre</b></td>
                                  <td><b>Descripcion</b></td>
                              </tr>
                          </thead>
                          <tbody>
                          <%
                            if(request.getAttribute("listaMarcas") != null){
                            	ArrayList<Marca> marcas = (ArrayList<Marca>)request.getAttribute("listaMarcas");
                            	for(Marca mar : marcas){
                            %>
                              <tr>
                                  <td><%=Integer.toString(mar.getIdMarca()) %></td>                              
                                  <td><%=mar.getNombre().toString() %></td>
                                  <td><%=mar.getDescripcion().toString() %></td>                               
                              </tr>
                              <%
                              	}
                              }
                              %>
                        </tbody>
                    </table>
            	</div>
            </div>
        </div>
        <hr>
        <footer>
            <div class="row" style="text-align:center">
                <div class="col-lg-12">
                    <p></p>
                </div>
            </div>
        </footer>
        <!-- end footer -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>