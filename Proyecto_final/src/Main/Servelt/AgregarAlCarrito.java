package Main.Servelt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.*;
import Main.Negocio.ProductoLogic;

/**
 * Servlet implementation class AgregarAlCarrito
 */
@WebServlet("/AgregarAlCarrito")
public class AgregarAlCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAlCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("carrito") == null) {
			Movimiento movimiento = new Movimiento();
			movimiento.setUsuario((Usuario)request.getSession().getAttribute("user"));
			movimiento.setImporte(0);
			movimiento.setDetalles(new ArrayList<Movistock>());
			request.getSession().setAttribute("carrito", movimiento);
		}
		ProductoLogic pl = new ProductoLogic();
		
		Movistock mos = new Movistock();
		mos.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		mos.setProducto(pl.GetOne(new Producto(Integer.parseInt(request.getParameter("id")))));
		mos.setSubtotal(mos.getCantidad() * mos.getProducto().getPrecioUnidad());
		
		Movimiento movimiento = (Movimiento)request.getSession().getAttribute("carrito");
		ArrayList<Movistock> movistocks = movimiento.getDetalles();
		
		movistocks.add(mos);
		movimiento.setImporte(movimiento.getImporte() + mos.getSubtotal());
		request.getSession().setAttribute("carrito", movimiento);
		
		request.getRequestDispatcher("Index").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
