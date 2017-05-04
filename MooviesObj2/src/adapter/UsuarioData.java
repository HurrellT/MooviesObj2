package adapter;

import moovies.Usuario;

public class UsuarioData {

	private int id;
	
	private Usuario usuario;
	
	public UsuarioData(int id, Usuario usuario) {
		
		this.id = id;
		this.usuario = usuario;
		
	}
	
	public int getId(){
		
		return id;
	}

	public Usuario getUser(){
		
		return usuario;
	}
}
