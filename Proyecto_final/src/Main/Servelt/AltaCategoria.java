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
 * Servlet implementation class AltaCategoria
 */
@WebServlet("/AltaCategoria")
public class AltaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria cat= new Categoria();
		cat.setNombre(request.getParameter("nombre"));
		cat.setDescripcion(request.getParameter("descripcion"));
		
		CategoriaLogic cate = new CategoriaLogic();
		if(cate.Insert(cat))
		{
			request.setAttribute("registroCategoria", true);//registroLibro
			request.getRequestDispatcher("ListaCategoria").forward(request, response);
		}
		else
		{
			request.setAttribute("registroCategoria", false);//registroLibro
			request.getRequestDispatcher("admin-alta-categoria.jsp").forward(request, response);
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
