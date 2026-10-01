package controlador;

import java.util.Scanner;

import modelo.Recurso;
import modelo.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// CARGAMOS LOS RECURSOS Y USUARIOS DE LOS RESPECTIVOS FICHEROS
		new GestionRecursos();
		new GestionUsuarios();

		int opcion = -1;

		// ATRIBUTOS DE USUARIO
		int id;
		String nombre;
		String email;

		// ATRIBUTOS DE RECURSO
		String idRec;
		String titulo;
		int año;
		boolean disponible;

		// CONSULTAS
		while (opcion != 4) {
			System.out.println("¿A que apartado quiere acceder?" + "\n 1- Gestión de recursos"
					+ "\n 2- Gestión de usuarios" + "\n 3- Gestión de préstamos" + "\n 4- Salir del sistema");

			opcion = sc.nextInt();
			sc.nextLine();
			int opcionRecurso;

			switch (opcion) {

			// RECURSOS
			case 1:

				// OPCIONES RECURSOS
				System.out.println(" --- Gestion Recursos --- " + "\n 1- Crear Recurso" + "\n 2- Modificar Recurso"
						+ "\n 3- Eliminar Recurso" + "\n 4- Listar Recursos" + "\n 5- Búsqueda"
						+ "\nPulsa enter para volver");

				opcionRecurso = sc.nextInt();
				sc.nextLine();

				switch (opcionRecurso) {

				// CREAR
				case 1:
					System.out.println("Que tipo de recurso quieres crear? " + "\n 1- Libro" + "\n 2- Pelicula"
							+ "\n 3- Videojuego" + "\nPulsa enter para volver");

					int tipoCrear = sc.nextInt();
					sc.nextLine();

					// ATRIBUTOS GENRALES DE RECURSOS
					System.out.print("ID: ");
					idRec = sc.nextLine();

					System.out.print("Titulo: ");
					titulo = sc.nextLine();

					System.out.print("Año: ");
					año = sc.nextInt();
					sc.nextLine();

					disponible = true;

					switch (tipoCrear) {

					// ATRIBUTOS DE LIBRO
					case 1:
						System.out.print("Autor: ");
						String autor = sc.nextLine();

						System.out.print("Numero de Paginas: ");
						int paginas = sc.nextInt();
						sc.nextLine();

						GestionRecursos.crearLibro(idRec, titulo, año, disponible, autor, paginas);
						break;

					// ATRIBUTOS DE PELICULA
					case 2:
						System.out.print("Director: ");
						String director = sc.nextLine();

						System.out.print("Duración en minutos: ");
						int duracion = sc.nextInt();
						sc.nextLine();

						GestionRecursos.crearPelicula(idRec, titulo, año, disponible, director, duracion);
						break;

					// ATRIBUTOS DE VIDEOJUEGO
					case 3:
						System.out.print("Plataforma: ");
						String plataforma = sc.nextLine();

						System.out.print("PEGI: ");
						int PEGI = sc.nextInt();
						sc.nextLine();

						GestionRecursos.crearVideojuego(idRec, titulo, año, disponible, plataforma, PEGI);
						break;

					default:

						System.out.println("Opción no válida");
						break;

					}

					sc.nextLine();
					break;

				// MODIFICAR
				case 2:
					System.out.println("Que tipo de recurso quieres modificar? " + "\n 1- Libro" + "\n 2- Pelicula"
							+ "\n 3- Videojuego" + "\nPulsa enter para volver");

					int tipo = sc.nextInt();
					sc.nextLine();

					// ATRIBUTOS GENRALES DE RECURSOS
					System.out.print("ID del recurso que quieres modificar: ");
					idRec = sc.nextLine();

					System.out.print("Nuevo titulo: ");
					titulo = sc.nextLine();

					System.out.print("Nuevo año: ");
					año = sc.nextInt();
					sc.nextLine();

					System.out.print("¿Esta disponible? (true/false): ");
					disponible = sc.nextBoolean();
					sc.nextLine();

					switch (tipo) {

					// ATRIBUTOS DE LIBRO
					case 1:

						System.out.print("Nuevo autor: ");
						String autor = sc.nextLine();

						System.out.print("Nuevo numero de paginas: ");
						int paginas = sc.nextInt();
						sc.nextLine();

						GestionRecursos.modificarLibro(idRec, titulo, año, disponible, autor, paginas);
						break;

					// ATRIBUTOS DE PELICULA
					case 2:

						System.out.print("Nuevo director: ");
						String director = sc.nextLine();

						System.out.print("Nueva duracion: ");
						int duracion = sc.nextInt();
						sc.nextLine();

						GestionRecursos.modificarPelicula(idRec, titulo, año, disponible, director, duracion);
						break;

					// ATRIBUTOS DE VIDEOJUEGOS
					case 3:

						System.out.print("Nueva plataforma: ");
						String plataforma = sc.nextLine();

						System.out.print("Nuevo PEGI: ");
						int PEGI = sc.nextInt();
						sc.nextLine();

						GestionRecursos.modificarVideojuego(idRec, titulo, año, disponible, plataforma, PEGI);
						break;

					default:
						System.out.println("Tipo de recurso no valido.");
						break;
					}
					break;
				// ELIMINAR RECURSO
				case 3:

					System.out.print("Introduce el ID del recurso: ");
					idRec = sc.nextLine();

					GestionRecursos.eliminarRecurso(idRec);

					break;

				// LISTAR RECURSOS
				case 4:

					System.out.println(" --- Listar Recursos --- " + "\n 1- Recursos" + "\n 2- Libros"
							+ "\n 3- Peliculas" + "\n 4- Videojuegos" + "\n 5- Recursos Disponibles"
							+ "\n 6- Recursos NO Disponibles" + "\nPulsa enter para volver");

					int lista = sc.nextInt();
					sc.nextLine();

					// SELECTOR DE LISTA
					switch (lista) {

					case 1:

						GestionRecursos.listaRecursos();
						break;

					case 2:

						GestionRecursos.listaLibros();
						break;

					case 3:

						GestionRecursos.listaPeliculas();
						break;

					case 4:

						GestionRecursos.listaVideojuegos();
						break;

					case 5:

						GestionRecursos.listaDisponibles();
						break;

					case 6:

						GestionRecursos.listaPrestados();
						break;

					default:

						System.out.println("Opción no válida");
						break;

					}

					break;

				case 5:

					System.out.println(" --- Buscar Recursos --- " + "\n 1- Por Id" + "\n 2- Por Titulo"
							+ "\nPulsa enter para volver");

					int tipoBusquedaRecurso = sc.nextInt();
					sc.nextLine();

					// POR COMO DEVUELVEN LOS DATOS LOS METODOS DE BUSQUEDA SE DEBE GUARDAR EN UN
					// OBJETO DE RECURSO
					Recurso recurso = null;

					switch (tipoBusquedaRecurso) {

					// POR ID
					case 1:

						System.out.print("Introduce el ID: ");
						idRec = sc.nextLine();

						recurso = GestionRecursos.buscarRecursoId(idRec);

						break;

					// POR TITULO
					case 2:

						System.out.print("Introduce el Titulo: ");
						titulo = sc.nextLine();

						recurso = GestionRecursos.buscarRecursoTitulo(titulo);

						break;

					default:

						System.out.println("Opción no válida");
						break;

					}
					
					if (recurso != null) {
					    System.out.println(recurso);
					} else {
					    System.out.println("No se ha encontrado el recurso.");
					}

					break;

				default:
					System.out.println("Opción no válida");
					break;

				}
				
			break;

				// USUARIOS
			case 2:

				// OPCIONES USUARIOS
				System.out.println(" --- Gestion Usuarios --- " + "\n 1- Crear Usuario" + "\n 2- Modificar Usuario"
						+ "\n 3- Eliminar Usuario" + "\n 4- Listar Usuario" + "\n 5- Busqueda"
						+ "\nPulsa enter para volver");

				int opcionUsuario = sc.nextInt();
				sc.nextLine();

				switch (opcionUsuario) {

				// CREAR USUARIO
				case 1:

					System.out.print("ID del usuario: ");
					id = sc.nextInt();
					sc.nextLine();

					System.out.print("Nombre: ");
					nombre = sc.nextLine();

					System.out.print("Email: ");
					email = sc.nextLine();

					GestionUsuarios.crearUsuario(id, nombre, email);

					break;

				// MODIFICAR USUARIO
				case 2:

					System.out.print("ID del usuario que quieres modificar: ");
					id = sc.nextInt();
					sc.nextLine();

					System.out.print("Nuevo nombre: ");
					nombre = sc.nextLine();

					System.out.print("Nuevo email: ");
					email = sc.nextLine();

					GestionUsuarios.modificarUsuario(id, nombre, email);

					break;

				// ELIMINAR USUARIO
				case 3:

					System.out.print("ID del usuario que quieres eliminar: ");
					id = sc.nextInt();
					sc.nextLine();

					GestionUsuarios.eliminarUsuario(id);

					break;

				// LISTAR USUARIOS
				case 4:
					GestionUsuarios.listaUsuarios();
					break;

				case 5:

					System.out.println(" --- Buscar Usuarios --- " + "\n 1- Por Id" + "\n 2- Por Titulo"
							+ "\nPulsa enter para volver");

					int tipoBusquedaUsuario = sc.nextInt();
					sc.nextLine();

					// POR COMO DEVUELVEN LOS DATOS LOS METODOS DE BUSQUEDA SE DEBE GUARDAR EN UN
					// OBJETO DE USUARIO
					Usuario usuario = null;

					switch (tipoBusquedaUsuario) {

					// POR ID
					case 1:

						System.out.print("Introduce el ID: ");
						id = sc.nextInt();
						sc.nextLine();

						usuario = GestionUsuarios.buscarUsuarioId(id);

						break;

					// POR TITULO
					case 2:

						System.out.print("Introduce el Nombre: ");
						nombre = sc.nextLine();

						usuario = GestionUsuarios.buscarUsuarioNombre(nombre);

						break;

					default:

						System.out.println("Opción no válida");
						break;

					}
					
					if (usuario != null) {
					    System.out.println(usuario);
					} else {
					    System.out.println("No se ha encontrado el usuario.");
					}
					
					break;

				}
				
			case 3:
				
				System.out.println("Prestamos");
				
				break;

			}

		}

	}

}
