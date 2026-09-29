package controlador;

import modelo.Prestamo;
import modelo.Recurso;
import modelo.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestionPrestamos {
    private List<Prestamo> listaPrestamos;
    private List<Usuario> usuariosRegistrados; 
    private List<Recurso> recursosRegistrados; 

    public GestionPrestamos(List<Usuario> usuarios, List<Recurso> recursos) {
        this.listaPrestamos = new ArrayList<>();
        this.usuariosRegistrados = usuarios;
        this.recursosRegistrados = recursos;
    }

    // Método para registrar un nuevo préstamo
    public boolean prestarRecurso(Usuario usuario, Recurso recurso) {
        if (!usuariosRegistrados.contains(usuario) || !recursosRegistrados.contains(recurso)) {
            System.out.println("Error: El usuario o el recurso no existen.");
            return false;
        }

        // Usamos .isDisponible() que ya existe en tu clase
        if (!recurso.isDisponible()) {
            System.out.println("Error: El recurso ya se encuentra prestado.");
            return false;
        }

        // CAMBIO AQUÍ: Usamos tu método .setEstado(false) para marcarlo como NO disponible
        recurso.setEstado(false);

        Prestamo nuevoPrestamo = new Prestamo(usuario, recurso);
        listaPrestamos.add(nuevoPrestamo);
        System.out.println("Préstamo realizado con éxito.");
        return true;
    }

    // Método para procesar la devolución de un recurso
    public boolean devolverRecurso(Usuario usuario, Recurso recurso) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getUsuario().equals(usuario) && 
                prestamo.getRecurso().equals(recurso) && 
                prestamo.isActivo()) {

                // CAMBIO AQUÍ: Usamos tu método .setEstado(true) para dejarlo disponible de nuevo
                recurso.setEstado(true);
                prestamo.setFechaDevolucion(LocalDate.now()); 
                
                System.out.println("Recurso devuelto con éxito.");
                return true;
            }
        }
        
        System.out.println("Error: No se encontró un préstamo activo para este usuario y recurso.");
        return false;
    }
}
