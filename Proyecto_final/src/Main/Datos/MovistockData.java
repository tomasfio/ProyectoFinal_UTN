package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import Main.Entidades.*;

public class MovistockData {
	
	public boolean Insert(Movistock mos) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = Base.getConnection();
			String sql = "";
			sql += "INSERT INTO movistock(cantidad,subtotal,idMovimiento,idProducto) VALUES(?,?,?,?)";
			
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, mos.getCantidad());
			pstm.setDouble(2,mos.getSubtotal());
			pstm.setInt(3, mos.getMovimiento().getIdMovimiento());
			pstm.setInt(4, mos.getProducto().getIdProducto());
			
			int resultado = pstm.executeUpdate();
			
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
}
