package com.pdruceat.model;

public class Sneaker {

	private String marca;
	private String modelo;
	private double precio;
	private int anioF;
	private int iD;
	private static int contadorID = 0;
	
	public Sneaker() {
	}
	
	public Sneaker(String marca, String modelo, double precio, int anioF) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.anioF = anioF;
		asignarID();
	}
	public void actualizarContador(int n) {
		contadorID = n;
	}
	
	private void asignarID() {
		this.iD = ++contadorID;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getAnioF() {
		return anioF;
	}

	public void setAnioF(int anioF) {
		this.anioF = anioF;
	}

	public int getiD() {
		return iD;
	}
	
	public void setiD(int n) {
		this.iD = n;
	}

	@Override
	public String toString() {
		return "Sneaker [marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + " €, anioF=" + anioF + ", iD="
				+ iD + "]";
	}
	
	
	
}
