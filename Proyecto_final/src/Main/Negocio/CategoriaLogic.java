package Main.Negocio;

import java.util.ArrayList;

import Main.Datos.CategoriaData;
import Main.Entidades.Categoria;



public class CategoriaLogic {
	CategoriaData catData;
	
	public CategoriaLogic() {
		catData = new CategoriaData();
	}
	
	public ArrayList<Categoria> GetAll(){
		return catData.GetAll();
	}
	
	public boolean Insert(Categoria cat) {
		return catData.Insert(cat);
	}

	public boolean Delete(Categoria cat) {
		return catData.Delete(cat);
	}
	
	public boolean Update(Categoria cat) {
		return catData.Update(cat);
	}
	
	public Categoria GetOne(Categoria cat) {
		return catData.GetOne(cat);
	}
}
