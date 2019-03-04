package Main.Servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Usuario;
import Main.Negocio.UsuarioLogic;

/**
 * Servlet implementation class SingIn
 */
@WebServlet("/SingIn")
public class SingIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioLogic ul = new UsuarioLogic();
		Usuario usu = new Usuario();
		usu.setUsuario(request.getParameter("usuario"));
		usu.setContraseña(request.getParameter("pass"));
		
		usu = ul.GetByUsuCon(usu);
		if (usu != null)
		{
			request.getSession().setAttribute("user", usu);
			if(usu.getTipoUsuario() == 1)
			{
				request.getRequestDispatcher("Index").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("index-cp.jsp").forward(request, response);
			}
		}
		else 
		{
			request.setAttribute("error", "Usuario y/o contraseña incorrecto");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		};
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
