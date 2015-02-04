package com.example.ariketa5agenda;

public class Persona {
	
	private String nombre="";
	private String apellido="";
	private String tel="";
	private String obs="";
	
	public Persona(String nombre, String apellido, String tel, String obs) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.obs = obs;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
