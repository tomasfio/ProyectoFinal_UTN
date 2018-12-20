package Main.Servelt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Entidades.Usuario;
import Main.Negocio.UsuarioLogic;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usu = new Usuario();
		usu.setNombre(request.getParameter("nombre"));
		usu.setApellido(request.getParameter("apellido"));
		usu.setEmail(request.getParameter("email"));
		usu.setTipoUsuario(Integer.parseInt(request.getParameter("tipo_usu")));
		Date fechaActual = new Date();
		usu.setFechaAlta(fechaActual);
		usu.setLocalidad(request.getParameter("localidad"));
		usu.setTelefono(request.getParameter("telefono"));
		usu.setCelular(request.getParameter("celular"));
		usu.setUsuario(request.getParameter("usuario"));
		usu.setContraseña(request.getParameter("contrasenia"));
		usu.setAnulado(false);
		
		UsuarioLogic ul = new UsuarioLogic();
		if(ul.GetByUserName(usu))
		{
			ul.Insert(usu);
			request.setAttribute("registroLibro", true);
			request.getRequestDispatcher("ListaUsuario").forward(request, response);
		}
		else
		{
			request.setAttribute("registroLibro", false);
			request.getRequestDispatcher("admin-alta-us.jsp").forward(request, response);
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
