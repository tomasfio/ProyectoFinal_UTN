package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Main.Entidades.Usuario;

public class UsuarioData {
	
	public ArrayList<Usuario> GetByUsuario(Usuario usuario){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM usuarios WHERE tipoUsuario = ? AND anulado = false";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, usuario.getTipoUsuario());
			
			rs = pstm.executeQuery();
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			Usuario usu = null;
			
			while(rs.next()) {
				usu = new Usuario();
				usu.setIdUsuario(rs.getInt("idUsuario"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setNombre(rs.getString("nombre"));
				usu.setApellido(rs.getString("apellido"));
				usu.setLocalidad(rs.getString("localidad"));
				usu.setTelefono(rs.getString("telefono"));
				usu.setCelular(rs.getString("celular"));
				usu.setEmail(rs.getString("email"));
				usu.setTipoUsuario(rs.getInt("tipoUsuario"));
				usuarios.add(usu);
			}
			return usuarios;
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally 
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public boolean Insert(Usuario usu)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = Base.getConnection();
			String sql = "";
			sql += "INSERT INTO usuarios(usuario,contraseña,nombre,apellido,localidad,telefono,celular,email,fechaAlta,tipoUsuario,anulado) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			//pstm.RETURN_GENERATED_KEYS();
			pstm.setString(1, usu.getUsuario());
			pstm.setString(2, usu.getContraseña());
			pstm.setString(3, usu.getNombre());
			pstm.setString(4, usu.getApellido());
			pstm.setString(5, usu.getLocalidad());
			pstm.setString(6, usu.getTelefono());
			pstm.setString(7, usu.getCelular());
			pstm.setString(8, usu.getEmail());
			pstm.setString(9, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(usu.getFechaAlta()));
			pstm.setInt(10, usu.getTipoUsuario());
			pstm.setBoolean(11, usu.isAnulado());
			
			int resultado = pstm.executeUpdate();
			
			//Recupera la key autogenerada
			//ResultSet rs = pstm.getGeneratedKeys();
			
			if (resultado == 1)
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try 
			{
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public boolean Delete(Usuario usu)
	{
		Connection con = null;
		PreparedStatement pstm = null;	
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			//En ese solo ABM la baja se hace asi, en los demas hacer DELETE normal
			//sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
			sql = "UPDATE Usuarios SET anulado = TRUE WHERE idUsuario = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, usu.getIdUsuario());
			
			int rtdo = pstm.executeUpdate();
			
			if(rtdo == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public boolean Update(Usuario usu)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "UPDATE Usuarios SET nombre = ?, apellido = ?,"
					+ " localidad = ?, telefono = ?, celular = ?,"
					+ " email = ? WHERE idUsuario = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usu.getNombre());
			pstm.setString(2, usu.getApellido());
			pstm.setString(3, usu.getLocalidad());
			pstm.setString(4, usu.getTelefono());
			pstm.setString(5, usu.getCelular());
			pstm.setString(6, usu.getEmail());
			pstm.setInt(7, usu.getIdUsuario());
			
			int res = pstm.executeUpdate();
			
			if(res == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public Usuario GetOne(Usuario usuario)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "SELECT * FROM Usuarios WHERE idUsuario = ? AND anulado = FALSE";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, usuario.getIdUsuario());
			rs = pstm.executeQuery();
			
			Usuario usu = null;
			
			while(rs.next())
			{
				usu = new Usuario();usu = new Usuario();
				usu.setIdUsuario(rs.getInt("idUsuario"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setNombre(rs.getString("nombre"));
				usu.setApellido(rs.getString("apellido"));
				usu.setLocalidad(rs.getString("localidad"));
				usu.setTelefono(rs.getString("telefono"));
				usu.setCelular(rs.getString("celular"));
				usu.setEmail(rs.getString("email"));
				usu.setTipoUsuario(rs.getInt("tipoUsuario"));
			}
			return usu;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public boolean GetByUserName(Usuario usu)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND anulado = FALSE";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usu.getUsuario());
			rs = pstm.executeQuery();
			
			rs.last();
			if(rs.getRow() > 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if(pstm != null) pstm.close();
				if(rs != null) rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
		
	}
	
	public ArrayList<Usuario> GetAll()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Usuarios AND anulado = FALSE";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
			Usuario usu = null;
			
			while(rs.next())
			{
				usu = new Usuario();
				usu.setIdUsuario(rs.getInt("idUsuario"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setNombre(rs.getString("nombre"));
				usu.setApellido(rs.getString("apellido"));
				usu.setLocalidad(rs.getString("localidad"));
				usu.setTelefono(rs.getString("telefono"));
				usu.setCelular(rs.getString("celular"));
				usu.setEmail(rs.getString("email"));
				usu.setTipoUsuario(rs.getInt("tipoUsuario"));
				Usuarios.add(usu);
			}
			return Usuarios;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public Usuario GetByUsuCon(Usuario usuario)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ? AND anulado = FALSE";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, usuario.getContraseña());
			rs = pstm.executeQuery();
			
			Usuario usu = null;
			
			while(rs.next())
			{
				usu = new Usuario();
				usu.setIdUsuario(rs.getInt("idUsuario"));
				usu.setUsuario(rs.getString("usuario"));
				usu.setNombre(rs.getString("nombre"));
				usu.setApellido(rs.getString("apellido"));
				usu.setLocalidad(rs.getString("localidad"));
				usu.setTelefono(rs.getString("telefono"));
				usu.setCelular(rs.getString("celular"));
				usu.setEmail(rs.getString("email"));
				usu.setTipoUsuario(rs.getInt("tipoUsuario"));
			}
			return usu;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}
