package com.example.ariketa9agendaintent;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombre="";
	private String apellido="";
	private String tel="";
	private String obs="";
	private String pueblo="";
	private static final long serialVersionUID = 1L;
	
	public Persona(String nombre, String apellido, String tel, String obs, String pueblo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.obs = obs;
		this.pueblo = pueblo;
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
	
}
