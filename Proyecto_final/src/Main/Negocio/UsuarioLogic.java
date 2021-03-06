package Main.Negocio;

import java.util.ArrayList;

import Main.Datos.UsuarioData;
import Main.Entidades.Usuario;

public class UsuarioLogic {
UsuarioData usuData;
	
	public UsuarioLogic() {
		usuData = new UsuarioData();
	}
	
	public ArrayList<Usuario> GetAll(){
		return usuData.GetAll();
	}
	
	public boolean Insert(Usuario usu) {
		return usuData.Insert(usu);
	}

	public boolean Delete(Usuario usu) {
		return usuData.Delete(usu);
	}
	
	public boolean Update(Usuario usu) {
		return usuData.Update(usu);
	}
	
	public Usuario GetOne(Usuario usu) {
		return usuData.GetOne(usu);
	}
	
	public boolean GetByUserName(Usuario usu) {
		return usuData.GetByUserName(usu);
	}
	
	public Usuario GetByUsuCon(Usuario usu) {
		return usuData.GetByUsuCon(usu);
	}
	
	public ArrayList<Usuario> GetByUsuario(Usuario usu)
	{
		if(usu == null)
		{
			usu = new Usuario();
			usu.setTipoUsuario(0);
		}
		return usuData.GetByUsuario(usu);
	}
}
