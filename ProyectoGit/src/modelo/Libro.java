package modelo;

public class Libro extends Recurso {

	private String autor;
	private String editorial;
	private int paginas;

	public Libro(int id, String titulo, int año, boolean disponible, String autor, String editorial, int paginas) {

		super(id, titulo, año, disponible);
		this.autor = autor;
		this.editorial = editorial;
		this.paginas = paginas;

	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int setPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", editorial=" + editorial + ", getId()=" + getId() + ", getTitulo()="
				+ getTitulo() + ", getAño()=" + getAño() + ", isDisponible()=" + isDisponible() + "]";
	}

}
