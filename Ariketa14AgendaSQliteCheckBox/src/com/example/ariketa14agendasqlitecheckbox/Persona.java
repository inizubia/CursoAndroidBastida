package com.example.ariketa14agendasqlitecheckbox;

import java.io.Serializable;

public class Persona implements Serializable{

	private int id;
	private String nombre="";
	private String apellido="";
	private String tel="";
	private String obs="";
	private String pueblo="";
	private static final long serialVersionUID = 1L;
	
	public Persona(int id, String nombre, String apellido, String tel, String obs, String pueblo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.obs = obs;
		this.pueblo = pueblo;
	}
	
	public Persona() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", tel=" + tel + ", obs=" + obs + ", pueblo="
				+ pueblo + "]";
	}
}
