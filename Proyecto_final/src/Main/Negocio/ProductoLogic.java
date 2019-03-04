package Main.Negocio;

import java.util.ArrayList;
import Main.Entidades.*;
import Main.Datos.*;

public class ProductoLogic {
	private ProductoData proData;
	public ProductoLogic() {
		this.proData = new ProductoData();
	}
	
	public ArrayList<Producto> GetAll(){
		return proData.GetAll();
	}
	
	public ArrayList<Producto> GetByMarca(Producto pro){
		return proData.GetByMarca(pro);
	}
	
	public ArrayList<Producto> GetByCategoria(Producto pro){
		return proData.GetByCategoria(pro);
	}

}
