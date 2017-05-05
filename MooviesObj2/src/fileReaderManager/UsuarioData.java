package fileReaderManager;

import moovies.Usuario;

public class UsuarioData {

	/*
	 * Colaboradores internos
	 */
	
	private int id;
	
	private Usuario usuario;
	
	/*
	 * Constructor de UsuarioData
	 */
	
	public UsuarioData(int id, Usuario usuario) {
		
		this.id = id;
		this.usuario = usuario;
		
	}
	
	/*
	 * Getters
	 */
	
	public int getId(){
		
		return id;
	}

	public Usuario getUser(){
		
		return usuario;
	}
}
