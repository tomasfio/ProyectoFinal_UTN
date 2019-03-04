package Main.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Marca;
import Main.Negocio.MarcaLogic;

/**
 * Servlet implementation class BajaModifMarca
 */
@WebServlet("/BajaModifMarca")
public class BajaModifMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaModifMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnDelete") != null) {
			Marca marca = new Marca();
			marca.setIdMarca(Integer.parseInt(request.getParameter("id_baja")));
			
			MarcaLogic ml = new MarcaLogic();
			if(ml.Delete(marca))
			{
				request.setAttribute("bajaMarca", true);
			}
			else
			{
				request.setAttribute("bajaMarca", false);
			}
			request.getRequestDispatcher("ListaMarca").forward(request, response);
		}
		else if(request.getParameter("btnUpdate") != null) {
			Marca marca = new Marca();
			marca.setIdMarca(Integer.parseInt(request.getParameter("id_modificar")));
			marca.setNombre(request.getParameter("nombre_modificar"));
			marca.setDescripcion(request.getParameter("descripcion_modificar"));
			
			
			MarcaLogic ml = new MarcaLogic();
			if(ml.Update(marca)) {
				request.setAttribute("modifMarca", true);
				request.getRequestDispatcher("ListaMarca").forward(request, response);
			}
			else {
				request.setAttribute("modifMarca", false);
			}
			
			
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
