package com.example.ariketa14agendasqlitecheckbox;

public class Lista_entrada {
	private int idImagen;
	private String name="";
	private String surname="";
	private String id;
	
	public Lista_entrada(int idImagen, String name, String surname, String id)
	{
		this.idImagen=idImagen;
		this.name=name;
		this.surname=surname;
		this.id=id;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getId() {
	    return id;
	  }
}
