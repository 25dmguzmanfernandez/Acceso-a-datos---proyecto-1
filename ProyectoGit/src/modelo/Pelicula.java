package modelo;

public class Pelicula extends Recurso{ 
	
	//Datos de "Pelicula"
	private String director;
	private int duracion;

	// Constructor de "Pelicula"
	public Pelicula(int id, String titulo, int año, boolean disponible, String director, int duracion) {
		super(id, titulo, año, disponible);
		
		this.director = director;
		this.duracion = duracion;
		
	}

	// Getters y Setters
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Pelicula "
				+ "[id=" + getId()
				+ ", titulo=" + getTitulo()
				+ ", año=" + getAño()
				+ ", dispobile=" + isDisponible()
				+ ", director=" + director
				+ ", duraion=" + duracion + "]";
				
	}

	
	
	


	
}
