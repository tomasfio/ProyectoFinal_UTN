package Main.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.*;
import Main.Negocio.CategoriaLogic;
import Main.Negocio.MarcaLogic;
import Main.Negocio.ProductoLogic;

/**
 * Servlet implementation class Indez
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoLogic pl = new ProductoLogic();
		if(request.getParameter("busca") != null) {
			Producto pro = new Producto();
			pro.setNombre((String)request.getParameter("busca"));
			pro.setDescripcion((String)request.getParameter("busca"));
			
			request.setAttribute("listaProducto", pl.GetProducto(pro));
		}
		else if(request.getParameter("idMar") != null) {
			Producto pro = new Producto();
			pro.setMarca(new Marca(Integer.parseInt(request.getParameter("idMar"))));
			request.setAttribute("listaProducto", pl.GetByMarca(pro));
		}
		else if(request.getParameter("idCat") != null) {
			Producto pro = new Producto();
			pro.setCategoria(new Categoria(Integer.parseInt(request.getParameter("idCat"))));
			request.setAttribute("listaProducto", pl.GetByCategoria(pro));
		}
		else {
			request.setAttribute("listaProducto", pl.GetAll());
		}
		
		
		CategoriaLogic cl = new CategoriaLogic();
		request.setAttribute("listaCategoria", cl.GetAll());
		
		MarcaLogic ml = new MarcaLogic();
		request.setAttribute("listaMarca", ml.GetAll());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
