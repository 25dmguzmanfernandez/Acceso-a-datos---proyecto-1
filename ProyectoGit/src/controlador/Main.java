package controlador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
		
		while (opcion != 4) {
			System.out.println("¿A que apartao quiere acceder?");
			System.out.println("1- Gestión de recursos");
			System.out.println("2- Gestión de usuarios");
			System.out.println("3- Gestión de préstamos");
			System.out.println("4- Salir del sistema");
			
			opcion = sc.nextInt();
			sc.nextLine();
			int opcion2;
			
			switch (opcion) {
			case 1:
				System.out.println("1- Recursos disponibles y prestados");
				System.out.println("2- Búsqueda por título");
				System.out.println("3- Recursos filtrados por tipo");
				
				opcion2 = sc.nextInt();
				sc.nextLine();
				
				switch (opcion2) {
				case 1:
					System.out.println("-");
					System.out.println("Pulsa enter para volver");
					sc.nextLine();
					break;
				case 2:
					System.out.println("-");
					System.out.println("Pulsa enter para volver");
					sc.nextLine();
					break;
				case 3:
					System.out.println("-");
					System.out.println("Pulsa enter para volver");
					sc.nextLine();
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
				
				break;
			case 2:
				System.out.println("1- Préstamos de un usuario");
				System.out.println("Pulsa enter para volver");
				sc.nextLine();
				break;
			case 3:
				System.out.println("1- Préstamos activos");
				System.out.println("Pulsa enter para volver");
				sc.nextLine();
				break;
			case 4:
				System.out.println("Cerrando programa");
				System.out.println("Pulsa enter para volver");
				sc.nextLine();
				break;
				
			default:
				System.out.println("Valor inválido introduce un número del 1 al 4");
				break;
			}
			
			
		}
		
		
		
	}
	
	
}
