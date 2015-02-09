package com.example.ariketa13listviewsql;

public class Lista_entrada {
	private int idImagen;
	private String fecha;
	
	public Lista_entrada(int idImagen, String fecha)
	{
		this.idImagen=idImagen;
		this.fecha=fecha;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public String getFecha() {
		return fecha;
	}

}
