package Main.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Categoria;
import Main.Negocio.CategoriaLogic;


/**
 * Servlet implementation class BajaModifCategoria
 */
@WebServlet("/BajaModifCategoria")
public class BajaModifCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaModifCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnDelete") != null) {
			Categoria cat = new Categoria();
			cat.setIdCategoria(Integer.parseInt(request.getParameter("id_baja")));
			
			CategoriaLogic cl = new CategoriaLogic();
			if(cl.Delete(cat))
			{
				request.setAttribute("bajaCategoria", true);
			}
			else
			{
				request.setAttribute("bajaCategoria", false);
			}
			request.getRequestDispatcher("ListaCategoria").forward(request, response);
		}
		else if(request.getParameter("btnUpdate") != null) {
			Categoria cat = new Categoria();
			cat.setIdCategoria(Integer.parseInt(request.getParameter("id_modificar")));
			cat.setNombre(request.getParameter("nombre_modificar"));
			cat.setDescripcion(request.getParameter("descripcion_modificar"));
			
			
			CategoriaLogic cl = new CategoriaLogic();
			if(cl.Update(cat)) {
				request.setAttribute("modifCategoria", true);
				request.getRequestDispatcher("ListaCategoria").forward(request, response);
			}
			else {
				request.setAttribute("modifCategoria", false);
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
