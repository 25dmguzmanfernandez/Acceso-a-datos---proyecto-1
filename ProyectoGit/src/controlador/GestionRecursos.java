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


public class GestionRecursos {

	private static HashMap<Integer, Recurso> recursos = new HashMap<>();

	private static String fichero = "recursos.txt";
	
	public GestionRecursos() {
		recursos = new HashMap<>();
		cargarRecursos();
	}

	// CREAR PELICULA
	public static boolean crearPelicula(int id, String titulo, int año, boolean disponible, String director, int duracion) {

		if (recursos.containsKey(id)) {
			System.out.println("Error: ya existe un recurso con ese ID.");
			return false;

		}

		Pelicula nuevaPelicula = new Pelicula(id, titulo, año, disponible, director, duracion);

		recursos.put(id, nuevaPelicula);

		guardarRecursos();

		System.out.println("Pelicula creada correctamente.");
		return true;

	}
	
	// CREAR LIBRO
	public static boolean crearLibro(int id, String titulo, int año, boolean disponible, String autor, editorial) {

		if (recursos.containsKey(id)) {
			System.out.println("Error: ya existe un recurso con ese ID.");
			return false;

		}

		Libro nuevoLibro = new Libro(id, titulo, año, disponible, autor, paginas);

		recursos.put(id, nuevaPelicula);

		guardarRecursos();

		System.out.println("Pelicula creada correctamente.");
		return true;

	}

	// LISTA DE USURAIOS
	public void listaRecursos() {

		if (recursos.isEmpty()) {
			System.out.println("No hay recursos");
			return;
		}

		for (Recurso recurso : recursos.values()) {
			System.out.println();
		}

	}

	// BUSCAR USUARIO
	public Recurso buscarRecurso(int id) {

		return recursos.get(id);

	}

	// MODIFICAR USUARIO
	public boolean modificarRecurso(int id, String nombre, String email) {

		Recurso modRecurso = recursos.get(id);

		if (modRecurso == null) {
			System.out.println("Este recurso no existe");
			return false;

		}

		modRecurso.setNombre(nombre);
		modRecurso.setEmail(email);

		guardarRecursos();

		return true;

	}

	// ELIMINAR USUARIO
	public boolean eliminarRecurso(int id) {

		if (!recursos.containsKey(id)) {
			System.out.println("Este recurso no existe");
			return false;

		}

		recursos.remove(id);

		guardarRecursos();

		System.out.println("Recurso eliminado correctamente");
		return true;

	}

	// GUARDAR USUARIOS
	private static void guardarRecursos() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

			for (Recurso recurso : recursos.values()) {

				bw.write(recurso.getId() + "," + recurso.getNombre() + "," + recurso.getEmail());
				bw.newLine();

			}

		} catch (IOException e) {
			System.out.println("Error al guardar los recursos");
		}
	}

	// CARGAR USUARIOS
	private void cargarRecursos() {

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(",");

				int id = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String email = datos[2];

				Recurso recurso = new Recurso(id, nombre, email);

				recursos.put(id, recurso);
			}

		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");

		} catch (NumberFormatException e) {
			System.out.println("Error en el formato del ID");
		}
	}

}
