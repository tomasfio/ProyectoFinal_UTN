package Main.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Usuario;
import Main.Negocio.CategoriaLogic;
import Main.Negocio.MarcaLogic;
import Main.Util.Autentificacion;

/**
 * Servlet implementation class CarritoCompra
 */
@WebServlet("/CarritoCompra")
public class CarritoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Autentificacion aut = new Autentificacion();
		if(!aut.AutentificacionCliente((Usuario)request.getSession().getAttribute("user"))) {
    		response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else {
			if(request.getSession().getAttribute("carritoCompra") != null)
			{
				/*Venta venta = (Venta)request.getSession().getAttribute("carritoCompra");
				request.setAttribute("listaDetalleVenta", venta.getDetallesVentas());
				request.setAttribute("importeTotal", venta.getImporte());*/
			}

			CategoriaLogic cl = new CategoriaLogic();
			request.setAttribute("listaCategoria", cl.GetAll());
			
			MarcaLogic ml = new MarcaLogic();
			request.setAttribute("listaMarca", ml.GetAll());
			
			request.getRequestDispatcher("carrito-compras.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
