package Main.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Main.Entidades.Marca;
import Main.Entidades.Movimiento;

public class MovimientoData {
	
	public Movimiento Insert(Movimiento mov) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = Base.getConnection();
			String sql = "";
			sql += "INSERT INTO movimientos(fecha,direccion,observacion,importe,idUsuario,idEntregaDetalle) VALUES(?,?,?,?,?,NULL)";
			
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pstm.setString(1, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(mov.getFecha()));
			pstm.setString(2, mov.getDireccion());
			pstm.setString(3, mov.getObservacion());
			pstm.setDouble(4, mov.getImporte());
			pstm.setInt(5, mov.getUsuario().getIdUsuario());
			
			int resultado = pstm.executeUpdate();
			
			if (resultado == 1) {
				Movimiento movi = new Movimiento();
				
				ResultSet rs = pstm.getGeneratedKeys();
				if(rs.next())
				{
					movi.setIdMovimiento(rs.getInt(1));
				}
				return movi;
			}
			else
				return null;
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
