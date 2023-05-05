package com.pdruceat.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.pdruceat.model.*;

public class Menu {

	static Scanner keyboard = new Scanner(System.in);
	static App myapp = new App();
	
	public static void mostrarMenu() {
		boolean menu = true;
		while(menu) {
			System.out.println("\t\tCALZATE");
			System.out.println("\t1. Mostrar zapatillas");
			System.out.println("\t2. Añadir zapatillas");
			System.out.println("\t3. Editar zapatillas");
			System.out.println("\t4. Eliminar zapatillas");
			System.out.println("\t5. Cargar zapatillas");
			System.out.println("\t6. Guardar zapatillas");
			System.out.println("\t0. Salir");
			System.out.print("\n\tOpcion -> ");
			try {
			int opcion = keyboard.nextInt();
			switch(opcion) {
			case 1 -> myapp.showZ();
			case 2 -> myapp.addZ();
			case 3 -> myapp.editZ();
			case 4 -> myapp.delZ();
			case 5 -> myapp.cargar();
			case 6 -> myapp.guardar();
			case 0 -> menu = false;
			default -> System.err.println("\nError -> Seleciona una opcion correcta\n");
			}
			}
			catch (InputMismatchException e) {
				System.err.println("\nError -> "+ e.getMessage());
				System.out.println("Introduce una opcion correcta\n");
				keyboard.nextLine();
			}
			catch (Exception e) {
				System.err.println("\nError -> "+ e.getMessage());
				System.out.println("Introduce una opcion correcta\n");
				keyboard.nextLine();
			}
		}
		keyboard.close();
	}
}
