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
 * Servlet implementation class MarcaABM
 */
@WebServlet("/MarcaABM")
public class MarcaABM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarcaABM() {
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
			 Marca mar = new Marca();
			 mar.setIdMarca(Integer.parseInt(request.getParameter("id_marca")));
			 
			 MarcaLogic ml = new MarcaLogic();
			 Marca marca = ml.GetOne(mar);
			 if(marca != null)
			 {
				 request.setAttribute("marca", marca);
				 if(request.getParameter("btnUpdate") != null)
				 {
					 request.setAttribute("accion", "update");
				 }
				 else
				 {
					 request.setAttribute("accion", "delete");
				 }
				 request.getRequestDispatcher("admin-baja-modif-marca.jsp").forward(request, response);
			 }
			 else
			 {
				 request.setAttribute("existeMarca", false);
				 request.getRequestDispatcher("ListaMarca").forward(request, response);
			 }
		 }
		 else
		 {
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
