package Main.Negocio;

import java.util.ArrayList;

import Main.Datos.MarcaData;
import Main.Entidades.Marca;
import Main.Entidades.Usuario;

public class MarcaLogic {
	MarcaData marcaData;
	
	public MarcaLogic() {
		marcaData = new MarcaData();
	}
	
	public ArrayList<Marca> GetAll(){
		return marcaData.GetAll();
	}
	
	public boolean Insert(Marca marca) {
		return marcaData.Insert(marca);
	}

	public boolean Delete(Marca marca) {
		return marcaData.Delete(marca);
	}
	
	public boolean Update(Marca marca) {
		return marcaData.Update(marca);
	}
	
	public Marca GetOne(Marca marca) {
		return marcaData.GetOne(marca);
	}

}
