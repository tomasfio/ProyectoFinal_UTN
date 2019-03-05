package Main.Entidades;

public class Movistock {
	
	private int idMovistock;
	private int cantidad;
	private double subtotal;
	private Movimiento movimiento;
	private Producto producto;
	
	public int getIdMovistock() {
		return idMovistock;
	}
	public void setIdMovistock(int idMovistock) {
		this.idMovistock = idMovistock;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Movimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
