Biblioteca Multimedia

Aplicación por consola que gestiona Recursos, Usuarios y Prestamos


Integrantes

  - Ekaitz Sánchez
  - Guzman Fernandez
  - Yeray Leguina

___________________________________________________________________________________________________________________________________________

Descripcion

La aplicación permite gestionar una Biblioteca formada por diferentes tipos de objetos:

  - Recursos
     · Libros
     · Peliculas
     · Videojuegos
  - Usuarios
  - Prestamos y Devoluciones  

___________________________________________________________________________________________________________________________________________

Gestion de Clases y paquetes

// USUARIOS

  - Usuario
      - int id
      - String nombre
      - String email

  Los usuarios pueden:
  - Crear
  - Modificar
  - Eliminar
  - Listar
  - Buscar (por id y por nombre)

// RECURSOS

  - Recurso
      - String id
      - String titulo
      - int año
      - boolean disponible

  - Libro (hereda de Recurso)
      - String autor
      - int paginas
        
  - Pelicula (hereda de Recurso)
      - String director
      - int duracion (en minutos)

  - Videojuego (hereda de Recurso)
      - String plataforma
      - int PEGI

  Los recursos pueden:
  - Crear
  - Modificar
  - Eliminar
  - Listar (filtrar por tipo)
  - Lista de disponibilidad
  - Buscar (por id y por titulo)

// PRESTAMOS 

  - Usuario Usuario
  - Recurso Recurso
  - LocalDate fechaPrestamo
  - LocalDate fechaDevolucion
