package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import modelo.Usuario;

public class GestionUsuarios {

	private static HashMap<Integer, Usuario> usuarios = new HashMap<>();

	private static String fichero = "usuarios.txt";

	public GestionUsuarios() {
		usuarios = new HashMap<>();
		cargarUsuarios();
	}

	// CREAR USUARIO
	public static boolean crearUsuario(int id, String nombre, String email) {

		if (usuarios.containsKey(id)) {
			System.out.println("Error: ya existe un usuario con ese ID.");
			return false;

		}

		Usuario nuevoUsuario = new Usuario(id, nombre, email);

		usuarios.put(id, nuevoUsuario);

		guardarUsuarios();

		System.out.println("Usuario creado correctamente.");
		return true;

	}

	// LISTA DE USURAIOS
	public static void listaUsuarios() {

		if (usuarios.isEmpty()) {
			System.out.println("No hay usuarios");
			return;
		}

		for (Usuario usuario : usuarios.values()) {
			System.out.println(usuario);
		}

	}

	// BUSCAR USUARIO POR ID
	public static Usuario buscarUsuarioId(int id) {

		return usuarios.get(id);

	}

	// BUSCAR USUARIO POR NOMBRE

	public static Usuario buscarUsuarioNombre(String nombre) {

		for (Usuario usuario : usuarios.values()) {
			if (usuario.getNombre().equalsIgnoreCase(nombre)) {
				return usuario;
			}
		}

		return null;

	}

	// MODIFICAR USUARIO
	public static boolean modificarUsuario(int id, String nombre, String email) {

		Usuario modUsuario = usuarios.get(id);

		if (modUsuario == null) {
			System.out.println("Este usuario no existe");
			return false;

		}

		modUsuario.setNombre(nombre);
		modUsuario.setEmail(email);

		guardarUsuarios();

		System.out.println("Usuario modificado correctamente");
		return true;

	}

	// ELIMINAR USUARIO
	public static boolean eliminarUsuario(int id) {

		if (!usuarios.containsKey(id)) {
			System.out.println("Este usuario no existe");
			return false;

		}

		usuarios.remove(id);

		guardarUsuarios();

		System.out.println("Usuario eliminado correctamente");
		return true;

	}

	// GUARDAR USUARIOS
	private static void guardarUsuarios() {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

			for (Usuario usuario : usuarios.values()) {

				bw.write(usuario.getId() + "," + usuario.getNombre() + "," + usuario.getEmail());
				bw.newLine();

			}

		} catch (IOException e) {
			System.out.println("Error al guardar los usuarios");
		}
	}

	// CARGAR USUARIOS
	private static void cargarUsuarios() {

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(",");

				int id = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				String email = datos[2];

				Usuario usuario = new Usuario(id, nombre, email);

				usuarios.put(id, usuario);
			}

		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");

		} catch (NumberFormatException e) {
			System.out.println("Error en el formato del ID");
		}
	}

}
