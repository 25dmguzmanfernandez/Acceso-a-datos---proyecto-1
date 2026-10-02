package controlador;

import modelo.Prestamo;
import modelo.Recurso;
import modelo.Usuario;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamos {
	// Lista estática global para almacenar los préstamos del sistema
	private static List<Prestamo> listaPrestamos = new ArrayList<>();
	private static final String ARCHIVO = "prestamo.txt";

	// Método estático para registrar un nuevo préstamo
	public static boolean prestarRecurso(Usuario usuario, Recurso recurso) {
		if (usuario == null || recurso == null) {
			System.out.println("Error: El usuario o el recurso no existen.");
			return false;
		}

		// Verificamos disponibilidad usando tu método existente
		if (!recurso.isDisponible()) {
			System.out.println("Error: El recurso ya se encuentra prestado.");
			return false;
		}

		// Cambiamos el estado utilizando tu método .setEstado
		recurso.setEstado(false);

		Prestamo nuevoPrestamo = new Prestamo(usuario, recurso);
		listaPrestamos.add(nuevoPrestamo);

		// GUARDAR: Guardamos en el archivo tras añadir un préstamo
		guardarPrestamos();

		System.out.println("Préstamo realizado con éxito.");
		return true;
	}

	// Método estático para procesar la devolución de un recurso
	public static boolean devolverRecurso(Usuario usuario, Recurso recurso) {
		if (usuario == null || recurso == null) {
			System.out.println("Error: Datos inválidos.");
			return false;
		}

		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.getUsuario().equals(usuario) && prestamo.getRecurso().equals(recurso) && prestamo.isActivo()) {

				// Volvemos a dejar disponible el recurso
				recurso.setEstado(true);
				prestamo.setFechaDevolucion(LocalDate.now());

				// GUARDAR: Actualizamos el archivo tras una devolución
				guardarPrestamos();

				System.out.println("Recurso devuelto con éxito.");
				return true;
			}
		}

		System.out.println("Error: No se encontró un préstamo activo para este usuario y recurso.");
		return false;
	}

	// Método para listar todos los préstamos que no han sido devueltos aún
	public static void comprobarPrestamos() {
		boolean hayActivos = false;

		System.out.println("--- Listado de Préstamos Activos ---");

		for (Prestamo prestamo : listaPrestamos) {
			if (prestamo.isActivo()) {
				hayActivos = true;

				String nombreUsuario = prestamo.getUsuario().getNombre();
				String idRecurso = prestamo.getRecurso().getId();

				System.out.println("- Usuario: " + nombreUsuario + " | Recurso: " + idRecurso);
			}
		}

		if (!hayActivos) {
			System.out.println("No hay préstamos activos en este momento.");
		}
	}

	/**
	 * Escribe la lista de préstamos actual en el archivo 'prestamo.txt'.
	 */
	public static void guardarPrestamos() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
			for (Prestamo prestamo : listaPrestamos) {
				// Estructura CSV interna en el TXT:
				// idUsuario,idRecurso,isActivo,fechaDevolucion
				int idUsuario = prestamo.getUsuario().getId();
				String idRecurso = prestamo.getRecurso().getId();
				boolean activo = prestamo.isActivo();
				String fechaDev = (prestamo.getFechaDevolucion() != null) ? prestamo.getFechaDevolucion().toString()
						: "null";

				bw.write(idUsuario + "," + idRecurso + "," + activo + "," + fechaDev);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al guardar los préstamos: " + e.getMessage());
		}
	}

	/**
	 * Lee el archivo 'prestamo.txt' y reconstruye la lista al arrancar la app.
	 */
	public static void cargarPrestamos() {
		File file = new File(ARCHIVO);
		if (!file.exists()) {
			return; // Si el archivo no existe todavía, salimos sin hacer nada
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String linea;
			listaPrestamos.clear(); // Limpiamos memoria para evitar duplicados

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length == 4) {
					int idUsuario = Integer.parseInt(datos[0]);
					String idRecurso = datos[1];
					boolean activo = Boolean.parseBoolean(datos[2]);
					String fechaDevStr = datos[3];

					// Reconstruimos los punteros usando tus buscadores estáticos existentes
					Usuario usuario = GestionUsuarios.buscarUsuarioId(idUsuario);
					Recurso recurso = GestionRecursos.buscarRecursoId(idRecurso);

					if (usuario != null && recurso != null) {
						Prestamo prestamo = new Prestamo(usuario, recurso);

						// Si el préstamo ya estaba cerrado, recuperamos su fecha de devolución
						if (!activo) {
							if (!fechaDevStr.equals("null")) {
								prestamo.setFechaDevolucion(LocalDate.parse(fechaDevStr));
							}
						} else {
							// Si el préstamo seguía activo, forzamos que el recurso en memoria esté ocupado
							recurso.setEstado(false);
						}

						listaPrestamos.add(prestamo);
					}
				}
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Error al cargar los préstamos: " + e.getMessage());
		}
	}
}
