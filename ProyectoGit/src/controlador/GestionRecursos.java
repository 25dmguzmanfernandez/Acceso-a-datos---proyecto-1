package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import modelo.Libro;
import modelo.Pelicula;
import modelo.Recurso;
import modelo.Videojuego;

public class GestionRecursos {

	private static HashMap<String, Recurso> recursos = new HashMap<>();

	private static String fichero = "recursos.txt";

	public GestionRecursos() {
		recursos = new HashMap<>();
		cargarRecursos();
	}

	// --- CREAR ---
	// CREAR PELICULA
	public static boolean crearPelicula(String id, String titulo, int año, boolean disponible, String director,
			int duracion) {

		if (recursos.containsKey(id)) {
			System.out.println("Error: ya existe un recurso con ese ID.");
			return false;
		}

		Pelicula nuevaPelicula = new Pelicula(id, titulo, año, disponible, director, duracion);

		recursos.put(id, nuevaPelicula);

		guardarRecursos();

		System.out.println("Película creada correctamente.");
		return true;
	}

	// CREAR LIBRO
	public static boolean crearLibro(String id, String titulo, int año, boolean disponible, String autor, int paginas) {

		if (recursos.containsKey(id)) {
			System.out.println("Error: ya existe un recurso con ese ID.");
			return false;
		}

		Libro nuevoLibro = new Libro(id, titulo, año, disponible, autor, paginas);

		recursos.put(id, nuevoLibro);

		guardarRecursos();

		System.out.println("Libro creado correctamente.");
		return true;
	}

	// CREAR VIDEOJUEGO
	public static boolean crearVideojuego(String id, String titulo, int año, boolean disponible, String plataforma,
			int PEGI) {

		if (recursos.containsKey(id)) {
			System.out.println("Error: ya existe un recurso con ese ID.");
			return false;
		}

		Videojuego nuevoVideojuego = new Videojuego(id, titulo, año, disponible, plataforma, PEGI);

		recursos.put(id, nuevoVideojuego);

		guardarRecursos();

		System.out.println("Videojuego creado correctamente.");
		return true;
	}

	// --- LISTAR ---
	// LISTA DE RECURSOS
	public static void listaRecursos() {

		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}

		for (Recurso recurso : recursos.values()) {
			System.out.println(recurso);
		}

	}

	// LISTA DE PELICULAS
	public static void listaPeliculas() {

		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}

		for (Recurso recurso : recursos.values()) {
			if (recurso instanceof Pelicula) {
				System.out.println(recurso);
			}

		}

	}

	// LISTA DE LIBROS
	public static void listaLibros() {

		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}

		for (Recurso recurso : recursos.values()) {
			if (recurso instanceof Libro) {
				System.out.println(recurso);

			}
		}

	}

	// LISTA DE VIDEOJUGEOS
	public static void listaVideojuegos() {

		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}

		for (Recurso recurso : recursos.values()) {
			if (recurso instanceof Videojuego) {
				System.out.println(recurso);
			}

		}

	}

	// LISTA DE RECURSOS DISPONIBLES
	public static void listaDisponibles() {
		
		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}
		
		for (Recurso recurso : recursos.values()) {
			if (recurso.isDisponible() == true) {
				System.out.println(recurso);
			}

		}
		
	}

	// LISTA DE RECURSOS PRESTADOS
	public static void listaPrestados() {
		
		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}
		
		for (Recurso recurso : recursos.values()) {
			if (recurso.isDisponible() == false) {
				System.out.println(recurso);
			}

		}
		
	}
	
	// --- BUSCAR ---
	// BUSCAR RECURSO POR ID
	public static Recurso buscarRecursoId(String id) {

		return recursos.get(id);

	}

	// BUSCAR RECURSO POR TITULO
	public static Recurso buscarRecursoTitulo(String titulo) {

		for(Recurso recurso : recursos.values()) {
			if (recurso.getTitulo().equalsIgnoreCase(titulo)) {
	            return recurso;
	        }
		}
		return null;

	}
	
	// --- MODIFICAR ---
	// MODIFICAR PELICULA
	public static boolean modificarPelicula(String id, String titulo, int año, boolean disponible, String director,
			int duracion) {

		Recurso modPelicula = recursos.get(id);

		if (modPelicula == null) {
			System.out.println("Este recurso no existe.");
			return false;
		}

		if (!(modPelicula instanceof Pelicula)) {
			System.out.println("El recurso indicado no es una película.");
			return false;
		}

		Pelicula pelicula = (Pelicula) modPelicula;

		pelicula.setTitulo(titulo);
		pelicula.setAño(año);
		pelicula.setEstado(disponible);
		pelicula.setDirector(director);
		pelicula.setDuracion(duracion);

		guardarRecursos();

		System.out.println("Película modificada correctamente.");
		return true;
	}

	// MODIFICAR LIBRO
	public static boolean modificarLibro(String id, String titulo, int año, boolean disponible, String autor, int paginas) {

		Recurso modLibro = recursos.get(id);

		if (modLibro == null) {
			System.out.println("Este recurso no existe.");
			return false;
		}

		if (!(modLibro instanceof Libro)) {
			System.out.println("El recurso indicado no es un libro.");
			return false;
		}

		Libro libro = (Libro) modLibro;

		libro.setTitulo(titulo);
		libro.setAño(año);
		libro.setEstado(disponible);
		libro.setAutor(autor);
		libro.setPaginas(paginas);

		guardarRecursos();

		System.out.println("Libro modificado correctamente.");
		return true;
	}

	// MODIFICAR VIDEOJUEGO
	public static boolean modificarVideojuego(String id, String titulo, int año, boolean disponible, String plataforma,
			int PEGI) {

		Recurso modVideojuego = recursos.get(id);

		if (modVideojuego == null) {
			System.out.println("Este recurso no existe.");
			return false;
		}

		if (!(modVideojuego instanceof Videojuego)) {
			System.out.println("El recurso indicado no es un videojuego.");
			return false;
		}

		Videojuego videojuego = (Videojuego) modVideojuego;

		videojuego.setTitulo(titulo);
		videojuego.setAño(año);
		videojuego.setEstado(disponible);
		videojuego.setPlataforma(plataforma);
		videojuego.setPEGI(PEGI);

		guardarRecursos();

		System.out.println("Videojuego modificado correctamente.");
		return true;
	}

	// --- ELIMINAR, GUARDAR y CARGAR ---
	// ELIMINAR RECURSO
	public static boolean eliminarRecurso(String id) {

		if (!recursos.containsKey(id)) {
			System.out.println("Este recurso no existe");
			return false;

		}

		recursos.remove(id);

		guardarRecursos();

		System.out.println("Recurso eliminado correctamente");
		return true;

	}

	// GUARDAR RECURSOS
	private static void guardarRecursos() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

			for (Recurso recurso : recursos.values()) {

				// DIFERENCIAR ENTRE LOS TIPOS DE RECURSOS
				if (recurso instanceof Pelicula) {
					Pelicula pelicula = (Pelicula) recurso;
					bw.write(pelicula.getId() + "," + pelicula.getTitulo() + "," + pelicula.getAño() + ","
							+ pelicula.isDisponible() + "," + pelicula.getDirector() + "," + pelicula.getDuracion());

				} else if (recurso instanceof Libro) {
					Libro libro = (Libro) recurso;
					bw.write(libro.getId() + "," + libro.getTitulo() + "," + libro.getAño() + "," + libro.isDisponible()
							+ "," + libro.getAutor() + "," + libro.getPaginas());

				} else if (recurso instanceof Videojuego) {
					Videojuego videojuego = (Videojuego) recurso;
					bw.write(videojuego.getId() + "," + videojuego.getTitulo() + "," + videojuego.getAño() + ","
							+ videojuego.isDisponible() + "," + videojuego.getPlataforma() + ","
							+ videojuego.getPEGI());
				}
				bw.newLine();

			}

		} catch (IOException e) {
			System.out.println("Error al guardar los recursos");
		}
	}

	// CARGAR RECURSOS
	public static void cargarRecursos() {

	    try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(",");

	            String id = datos[0];
	            String titulo = datos[1];
	            int año = Integer.parseInt(datos[2]);
	            boolean disponible = Boolean.parseBoolean(datos[3]);

	            // DIFERENCIAR ENTRE LOS TIPOS DE RECURSOS
	            if (id.startsWith("P")) {

	                String director = datos[4];
	                int duracion = Integer.parseInt(datos[5]);

	                Pelicula pelicula = new Pelicula(
	                        id, titulo, año, disponible,
	                        director, duracion);

	                recursos.put(id, pelicula);

	            } else if (id.startsWith("L")) {

	                String autor = datos[4];
	                int paginas = Integer.parseInt(datos[5]);

	                Libro libro = new Libro(
	                        id, titulo, año, disponible,
	                        autor, paginas);

	                recursos.put(id, libro);

	            } else if (id.startsWith("V")) {

	                String plataforma = datos[4];
	                int PEGI = Integer.parseInt(datos[5]);

	                Videojuego videojuego = new Videojuego(
	                        id, titulo, año, disponible,
	                        plataforma, PEGI);

	                recursos.put(id, videojuego);
	            }
	        }

	    } catch (IOException e) {

	        System.out.println("No se ha encontrado el fichero");

	    } catch (NumberFormatException e) {

	        System.out.println("Error en el formato de los datos");
	    }
	}

}
