package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Main.Entidades.Categoria;
import Main.Entidades.Marca;
import Main.Entidades.Producto;

public class ProductoData {
	
	public Producto GetOne(Producto producto)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MarcaData marData = new MarcaData();
		CategoriaData catData = new CategoriaData();
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql = "SELECT * FROM productos WHERE idProducto = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, producto.getIdProducto());
			rs = pstm.executeQuery();
			
			Producto pro = null;
			
			while(rs.next())
			{
				pro = new Producto();
				pro.setIdProducto(rs.getInt("idProducto"));
				pro.setNombre(rs.getString("nombre"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnidad(rs.getDouble("precioUnidad"));
				pro.setMarca(marData.GetOne(new Marca(rs.getInt("idMarca"))));
				pro.setCategoria(catData.GetOne(new Categoria(rs.getInt("idProducto"))));
			}
			return pro;
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
	
	public ArrayList<Producto> GetAll()
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MarcaData marData = new MarcaData();
		CategoriaData catData = new CategoriaData();
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Productos";
			
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto pro = null;
			
			while(rs.next())
			{
				pro = new Producto();
				pro.setIdProducto(rs.getInt("idProducto"));
				pro.setNombre(rs.getString("nombre"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnidad(rs.getDouble("precioUnidad"));
				pro.setMarca(marData.GetOne(new Marca(rs.getInt("idMarca"))));
				pro.setCategoria(catData.GetOne(new Categoria(rs.getInt("idCategoria"))));
				productos.add(pro);
			}
			return productos;
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
	
	public ArrayList<Producto> GetByMarca(Producto pro)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MarcaData marData = new MarcaData();
		CategoriaData catData = new CategoriaData();
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Productos WHERE idMarca = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, pro.getMarca().getIdMarca());
			
			rs = pstm.executeQuery();
			
			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto producto = null;
			
			while(rs.next())
			{
				pro = new Producto();
				pro.setIdProducto(rs.getInt("idProducto"));
				pro.setNombre(rs.getString("nombre"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnidad(rs.getDouble("precioUnidad"));
				pro.setMarca(marData.GetOne(new Marca(rs.getInt("idMarca"))));
				pro.setCategoria(catData.GetOne(new Categoria(rs.getInt("idCategoria"))));
				productos.add(pro);
			}
			return productos;
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
	
	public ArrayList<Producto> GetByCategoria(Producto pro)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MarcaData marData = new MarcaData();
		CategoriaData catData = new CategoriaData();
		
		try
		{
			con = Base.getConnection();
			String sql = "";
			sql += "SELECT * FROM Productos WHERE idCategoria = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, pro.getCategoria().getIdCategoria());
			
			rs = pstm.executeQuery();
			
			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto producto = null;
			
			while(rs.next())
			{
				pro = new Producto();
				pro.setIdProducto(rs.getInt("idProducto"));
				pro.setNombre(rs.getString("nombre"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnidad(rs.getDouble("precioUnidad"));
				pro.setMarca(marData.GetOne(new Marca(rs.getInt("idMarca"))));
				pro.setCategoria(catData.GetOne(new Categoria(rs.getInt("idCategoria"))));
				productos.add(pro);
			}
			return productos;
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
	
	public ArrayList<Producto> GetProducto(Producto producto)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CategoriaData catData = new CategoriaData();
		MarcaData marData = new MarcaData();
		
		try {
			con = Base.getConnection();
			String sql = "";
			sql = "SELECT * FROM productos " +
				"WHERE nombre LIKE ? OR descripcion LIKE ? ";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, "%" + producto.getNombre() + "%");
			pstm.setString(2, "%" + producto.getDescripcion() + "%");
			
			rs = pstm.executeQuery();
			ArrayList<Producto> productos = new ArrayList<Producto>();
			Producto pro = null;
			
			while(rs.next())
			{
				pro = new Producto();
				pro.setIdProducto(rs.getInt("idProducto"));
				pro.setNombre(rs.getString("nombre"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecioUnidad(rs.getDouble("precioUnidad"));
				pro.setMarca(marData.GetOne(new Marca(rs.getInt("idMarca"))));
				pro.setCategoria(catData.GetOne(new Categoria(rs.getInt("idCategoria"))));
				productos.add(pro);
			}
			
			return productos;
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
