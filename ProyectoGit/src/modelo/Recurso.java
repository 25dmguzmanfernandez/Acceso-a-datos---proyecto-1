package modelo;

public class Recurso {
	
	// Datos de "Recurso"
	private String id;
	private String titulo;
	private int año;
	private boolean disponible;
	
	// Constructor de "Recurso"
	public Recurso(String id, String titulo, int año, boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.año = año;
		this.disponible = disponible;
	}
	
	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
