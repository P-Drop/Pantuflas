package com.pdruceat.model;


import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class App {

	ArrayList<Sneaker> misZ = new ArrayList<>();
	Scanner keyboard = new Scanner(System.in);
	Sneaker s = new Sneaker();
	
	
	public void showZ() {
		int contador = 0;
		if(misZ.size()!= 0) {
			for (Sneaker sneaker : misZ) {
				System.out.println("\nnº "+(++contador)+"\n"+sneaker.toString()+"\n");
			}
		}
		else {
			System.out.println("\nNo hay zapatillas weii\n");
		}
	}
	public void addZ() throws InputMismatchException, Exception{
		keyboard.nextLine();
		System.out.print("\nVas a crear una nueva zapatilla.. \nIntroduce la marca: ");
		String marca = keyboard.nextLine();
		System.out.print("Introduce el modelo: ");
		String modelo = keyboard.nextLine();
		System.out.print("Introduce el año de fabricacion: ");
		int anioF = keyboard.nextInt();
		System.out.print("Introduce el precio: ");
		double precio = keyboard.nextDouble();
		s.actualizarContador(misZ.size());
		Sneaker snk = new Sneaker(marca, modelo, precio, anioF);
		misZ.add(snk);
		System.out.println("\nSE HA CREADO EL MODELO\n");
	}
	public void editZ() throws InputMismatchException, Exception{
		boolean existeID = false;
		if (misZ.size() != 0) {
		Iterator <Sneaker> snkIte = misZ.iterator();
		showZ();
		System.out.print("\nIntroduce el ID de la zapatilla que quieres editar -> ");
		int id = keyboard.nextInt();
		keyboard.nextLine();
		while(snkIte.hasNext()) {
			Sneaker snked = snkIte.next();
			if(snked.getiD() == (id)) {
				existeID = true;
				System.out.print("\nIntroduce los datos del modelo\nMarca: ");
				String marca = keyboard.nextLine();
				System.out.print("Modelo: ");
				String modelo = keyboard.nextLine();
				System.out.print("Año de fabricación: ");
				int anioF = keyboard.nextInt();
				System.out.print("Precio: ");
				double precio = keyboard.nextDouble();
				snked.setMarca(marca);
				snked.setModelo(modelo);
				snked.setAnioF(anioF);
				snked.setPrecio(precio);
				break;
			}
		}
		if(!existeID) {
			System.err.println("\nError -> No existe el modelo, revisa el ID\n");
		}
		else {
			System.out.println("\nSE HA ACTUALIZADO EL MODELO\n");
		}
		}
		else {
			System.out.println("\nNo hay zapatillas weii\n");
		}
	}
	public void delZ() throws InputMismatchException, Exception{
		boolean existeID = false;
		if (misZ.size() != 0) {
		Iterator <Sneaker> snkIte = misZ.iterator();
		showZ();
		System.out.print("\nIntroduce el ID de la zapatilla que quieres eliminar -> ");
		int id = keyboard.nextInt();
		int nuevoID = id;
		while(snkIte.hasNext()) {
			Sneaker snkdel = snkIte.next();
			if(snkdel.getiD() == (id)) {
				existeID = true;
				snkIte.remove();
			}
			if(snkdel.getiD() > id) {
				snkdel.setiD(nuevoID++);
			}
		}
		if(!existeID) {
			System.err.println("\nError -> No existe el modelo, revisa el ID\n");
		}
		else {
		System.out.println("\nSE HA ELIMINADO EL MODELO\n");
		}
		}
		else {
			System.out.println("\nNo hay zapatillas weii\n");
		}
	}
	public void cargar() throws InputMismatchException, Exception{
		System.out.println("\nSe van a cargar los datos del archivo datos.txt...¿Continuar? (y/n)");
		String continuar = keyboard.next();
		if(continuar.equals("y")) {
			try (BufferedReader ficheroCargar = new BufferedReader(new FileReader("datos.txt"))){
				String[] datosOb = null;
				String linea = ficheroCargar.readLine();
				s.actualizarContador(misZ.size());
				while(linea != null) {
					datosOb = linea.split(";");
					Sneaker snk = new Sneaker(datosOb[1], datosOb[2], Double.parseDouble(datosOb[3]), Integer.parseInt(datosOb[4]));
					misZ.add(snk);
					linea = ficheroCargar.readLine();
				}
				System.out.println("\nDATOS CARGADOS\n");
			}
			catch (IOException e) {
				System.err.println("Error -> "+ e.getMessage());
			}
		}
	}
	public void guardar() throws Exception{
		if(misZ.size() != 0) {
		try (BufferedWriter ficheroGuardar = new BufferedWriter(new FileWriter("datos.txt"))){
			for (Sneaker sneaker : misZ) {
				String datosSneaker = sneaker.getiD() +";"+ sneaker.getMarca() +";"+ sneaker.getModelo() +";"+ sneaker.getPrecio() +";"+ sneaker.getAnioF();
				ficheroGuardar.write(datosSneaker);
				ficheroGuardar.newLine();
			}
			System.out.println("\nDATOS GUARDADOS\n");
		}
		catch (IOException e) {
			System.err.println("Error -> " + e.getMessage());
		}
		}
		else {
			System.out.println("\nNo hay zapatillas weii\n");
		}
	}
}
