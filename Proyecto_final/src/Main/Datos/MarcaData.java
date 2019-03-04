package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Main.Entidades.Marca;


public class MarcaData {

	public boolean Insert(Marca marca)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = Base.getConnection();
			String sql = "";
			sql += "INSERT INTO marcas(nombre,descripcion) VALUES(?,?)";
			
			pstm = con.prepareStatement(sql);
			//pstm.RETURN_GENERATED_KEYS();
			pstm.setString(1, marca.getNombre());
			pstm.setString(2, marca.getDescripcion());
			
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
	
	public boolean Delete(Marca marca)
	{
		Connection con = null;
		PreparedStatement pstm = null;	
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "DELETE FROM Marcas WHERE idMarca = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, marca.getIdMarca());
			
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
	
	public boolean Update(Marca marca)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "UPDATE Marcas SET nombre = ?, descripcion = ? WHERE idMarca = ?";
				
			pstm = con.prepareStatement(sql);
			pstm.setString(1, marca.getNombre());
			pstm.setString(2, marca.getDescripcion());
			pstm.setInt(3, marca.getIdMarca());
			
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
	
	public Marca GetOne(Marca marca)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "SELECT * FROM Marcas WHERE idMarca = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, marca.getIdMarca());
			rs = pstm.executeQuery();
			
			Marca mar = null;
			
			while(rs.next())
			{
				mar = new Marca();
				mar.setIdMarca(rs.getInt("idMarca"));
				mar.setNombre(rs.getString("nombre"));
				mar.setDescripcion(rs.getString("descripcion"));
			}
			return mar;
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
	
	public ArrayList<Marca> GetAll()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Marcas";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<Marca> Marcas = new ArrayList<Marca>();
			Marca marca = null;
			
			while(rs.next())
			{
				marca = new Marca();
				marca.setIdMarca(rs.getInt("idMarca"));
				marca.setDescripcion(rs.getString("descripcion"));
				marca.setNombre(rs.getString("nombre"));
				Marcas.add(marca);
			}
			return Marcas;
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
