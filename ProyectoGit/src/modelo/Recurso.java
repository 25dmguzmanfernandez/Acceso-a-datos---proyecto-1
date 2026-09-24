package modelo;

public class Recurso {
	
	// Datos de "Recurso"
	private int id;
	private String titulo;
	private int año;
	private boolean disponible;
	
	// Constructor de "Recurso"
	public Recurso(int id, String titulo, int año, boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.año = año;
		this.disponible = disponible;
	}
	
	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setEstado(boolean estado) {
		this.disponible = estado;
	}
	
	
	
}
