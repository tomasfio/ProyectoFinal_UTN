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
 * Servlet implementation class AltaMarca
 */
@WebServlet("/AltaMarca")
public class AltaMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Marca marca= new Marca();
		marca.setNombre(request.getParameter("nombre"));
		marca.setDescripcion(request.getParameter("descripcion"));
		
		MarcaLogic mar = new MarcaLogic();
		if(mar.Insert(marca))
		{
			request.setAttribute("registroMarca", true);//registroLibro
			request.getRequestDispatcher("ListaMarca").forward(request, response);
		}
		else
		{
			request.setAttribute("registroMarca", false);//registroLibro
			request.getRequestDispatcher("admin-alta-marca.jsp").forward(request, response);
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
