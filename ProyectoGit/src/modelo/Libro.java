package modelo;

public class Libro extends Recurso {

	// DATOS DE LIBRO
	private String autor;
	private int paginas;

	// CONSTRUCTOR DE LIBRO
	public Libro(String id, String titulo, int año, boolean disponible, String autor, int paginas) {

		super(id, titulo, año, disponible);
		this.autor = autor;
		this.paginas = paginas;

	}

	// Getters y Setters
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro " + "[id=" + getId() + ", titulo=" + getTitulo() + ", año=" + getAño() + ", disponible="
				+ isDisponible() + ", autor/a=" + autor + ", paginas=" + paginas + "]";

	}

}
