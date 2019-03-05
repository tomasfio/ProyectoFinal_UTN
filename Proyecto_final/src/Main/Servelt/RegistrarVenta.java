package Main.Servelt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Movimiento;
import Main.Negocio.MovimientoLogic;

/**
 * Servlet implementation class RegistrarVenta
 */
@WebServlet("/RegistrarVenta")
public class RegistrarVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnRegistrar") != null) {
			Movimiento mov = (Movimiento)request.getSession().getAttribute("carrito");
			
			if(request.getParameter("direccion").isEmpty()) {
				request.setAttribute("faltaDireccion","Falto agregar la direccion donde se realiza el envio");
			}
			else {
				mov.setDireccion(request.getParameter("direccion"));
				mov.setObservacion(request.getParameter("observacion"));
				mov.setFecha(new Date());
				
				MovimientoLogic ml = new MovimientoLogic();
				if(ml.RegistrarVenta(mov)) {
					request.setAttribute("venta", true);
					request.getSession().setAttribute("carrito", null);
				}
				else {
					request.setAttribute("venta", false);
				}
			}
			
			request.getRequestDispatcher("CarritoCompra").forward(request, response);
		}
		else if(request.getParameter("btnDelete") != null) {
			request.getSession().setAttribute("carrito", null);
			request.getRequestDispatcher("CarritoCompra").forward(request, response);	
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
