package Main.Entidades;

public class Marca {
	public Marca() {}
	public Marca(int id) {
		this.idMarca = id;
	}
	
	private int idMarca;
	private String nombre;
	private String descripcion;
	
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
