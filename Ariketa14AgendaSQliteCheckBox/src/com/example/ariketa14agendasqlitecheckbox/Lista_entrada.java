package com.example.ariketa14agendasqlitecheckbox;

public class Lista_entrada {
	private int idImagen;
	private String name="";
	private String surname="";
	private boolean selected;
	
	public Lista_entrada(int idImagen, String name, String surname)
	{
		this.idImagen=idImagen;
		this.name=name;
		this.surname=surname;
		selected = false;
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
	
	public boolean isSelected() {
	    return selected;
	  }

	public void setSelected(boolean selected) {
	    this.selected = selected;
	}
}
