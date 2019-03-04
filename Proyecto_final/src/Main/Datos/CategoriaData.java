package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Main.Entidades.Categoria;


public class CategoriaData {
	
	public boolean Insert(Categoria cat)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = Base.getConnection();
			String sql = "";
			sql += "INSERT INTO categorias(nombre,descripcion) VALUES(?,?)";
			
			pstm = con.prepareStatement(sql);
			//pstm.RETURN_GENERATED_KEYS();
			pstm.setString(1, cat.getNombre());
			pstm.setString(2, cat.getDescripcion());
			
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
	
	public boolean Delete(Categoria cat)
	{
		Connection con = null;
		PreparedStatement pstm = null;	
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "DELETE FROM Categorias WHERE idCategoria = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cat.getIdCategoria());
			
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
	
	public boolean Update(Categoria cat)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "UPDATE Categorias SET nombre = ?, descripcion = ? WHERE idCategoria = ?";
				
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cat.getNombre());
			pstm.setString(2, cat.getDescripcion());
			pstm.setInt(3, cat.getIdCategoria());
			
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
	
	public Categoria GetOne(Categoria cat)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "SELECT * FROM Categorias WHERE idCategoria = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, cat.getIdCategoria());
			rs = pstm.executeQuery();
			
			Categoria cate = null;
			
			while(rs.next())
			{
				cate = new Categoria();
				cate.setIdCategoria(rs.getInt("idCategoria"));
				cate.setNombre(rs.getString("nombre"));
				cate.setDescripcion(rs.getString("descripcion"));
			}
			return cate;
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
	
	public ArrayList<Categoria> GetAll()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Categorias";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<Categoria> Categorias = new ArrayList<Categoria>();
			Categoria cat = null;
			
			while(rs.next())
			{
				cat = new Categoria();
				cat.setIdCategoria(rs.getInt("idCategoria"));
				cat.setDescripcion(rs.getString("descripcion"));
				cat.setNombre(rs.getString("nombre"));
				Categorias.add(cat);
			}
			return Categorias;
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
