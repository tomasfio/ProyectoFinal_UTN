package Main.Entidades;

import java.util.ArrayList;
import java.util.Date;

public class Movimiento {
	
	private int idMovimiento;
	private Date fecha;
	private String direccion;
	private String observacion;
	private double importe;
	private Usuario usuario;
	private ArrayList<Movistock> detalles;
	
	
	public int getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<Movistock> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<Movistock> detalles) {
		this.detalles = detalles;
	}
	
	

}
