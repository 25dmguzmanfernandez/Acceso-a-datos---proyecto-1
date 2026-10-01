package modelo;

public class Videojuego extends Recurso {

	// DATOS DE VIDEOJUEGO
	private String plataforma;
	private int PEGI;

	// CONSTRUCTOR DE VIDEOJUEGO
	public Videojuego(String id, String titulo, int año, boolean disponible, String plataforma, int PEGI) {
		super(id, titulo, año, disponible);

		this.plataforma = plataforma;
		this.PEGI = PEGI;

	}

	// Getters y Setters
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getPEGI() {
		return PEGI;
	}

	public void setPEGI(int PEGI) {
		this.PEGI = PEGI;
	}

	@Override
	public String toString() {
		return "Videojuego " + "[id=" + getId() + ", titulo=" + getTitulo() + ", año=" + getAño() + ", disponible="
				+ isDisponible() + ", plataforma=" + plataforma + ", PEGI=" + PEGI + "]";

	}

}