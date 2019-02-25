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
 * Servlet implementation class CategoriaABM
 */
@WebServlet("/CategoriaABM")
public class CategoriaABM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaABM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnUpdate") != null || request.getParameter("btnDelete") != null) 
		 {
			 Categoria cat = new Categoria();
			 cat.setIdCategoria(Integer.parseInt(request.getParameter("id_categoria")));
			 
			 CategoriaLogic cl = new CategoriaLogic();
			 Categoria cate = cl.GetOne(cat);
			 if(cate != null)
			 {
				 request.setAttribute("categoria", cate);
				 if(request.getParameter("btnUpdate") != null)
				 {
					 request.setAttribute("accion", "update");
				 }
				 else
				 {
					 request.setAttribute("accion", "delete");
				 }
				 request.getRequestDispatcher("admin-baja-modif-categoria.jsp").forward(request, response);
			 }
			 else
			 {
				 request.setAttribute("existeCategoria", false);
				 request.getRequestDispatcher("ListaCategoria").forward(request, response);
			 }
		 }
		 else
		 {
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
