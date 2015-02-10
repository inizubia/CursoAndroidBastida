package com.example.ariketa13listviewsql;

public class Lista_entrada {
	private int idImagen;
	private String fecha;
	private String asunto;
	
	public Lista_entrada(int idImagen, String fecha, String asunto)
	{
		this.idImagen=idImagen;
		this.fecha=fecha;
		this.asunto=asunto;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public String getFecha() {
		return fecha;
	}
	
	public String getAsunto() {
		return asunto;
	}
}
