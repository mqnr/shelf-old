package com.mzamorano.school.objetosnegocio;

/**
 * Un {@code Libro} es una especialización de {@code Publicacion} que añade atributos específicos
 * relevantes para libros, como el autor y la edición.
 *
 * <p>Esta clase proporciona un manejo detallado de los libros en sistemas que gestionan bibliotecas
 * o inventarios de publicaciones, facilitando el acceso y modificación de información pertinente al
 * autor y edición del libro.
 */
public class Libro extends Publicacion {
    private String autor;
    private String edicion;

    /**
     * Construye un {@code Libro} sin inicializar sus atributos.
     */
    public Libro() {
        super();
    }

    /**
     * Construye un {@code Libro} con los detalles editoriales, autor, y edición dados.
     *
     * @param isbn el ISBN de la publicación.
     * @param titulo el título de la publicación.
     * @param editorial la editorial de la publicación.
     * @param clasificacion la clasificación de la publicación.
     * @param autor el autor del libro.
     * @param edicion la edición del libro.
     */
    public Libro(String isbn, String titulo, String editorial, String clasificacion, String autor, String edicion) {
        super(isbn, titulo, editorial, clasificacion);
        this.autor = autor;
        this.edicion = edicion;
    }

    /**
     * Construye un {@code Libro} con el ISBN dado.
     *
     * @param isbn el ISBN de la publicación.
     */
    public Libro(String isbn) {
        super(isbn);
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return el autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor el nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la edición del libro.
     *
     * @return la edición del libro.
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * Devuelve la edición del libro.
     *
     * @param edicion la nueva edición del libro.
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * Devuelve una representación en cadena del libro,
     * incluyendo su ISBN, título, editorial, clasificación, autor y edición.
     *
     * @return Una cadena que representa el libro.
     */
    @Override
    public String toString() {
        return super.toString() + ", " + autor + ", " + edicion;
    }
}