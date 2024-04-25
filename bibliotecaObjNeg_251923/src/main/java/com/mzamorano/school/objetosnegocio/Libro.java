package com.mzamorano.school.objetosnegocio;

/**
 * Representa un libro en un sistema de gestión bibliotecaria.
 * Extiende {@link Publicacion} para incluir detalles específicos de libros, como autor y edición.
 */
public class Libro extends Publicacion {
    private String autor;
    private String edicion;

    /**
     * Constructor por defecto. Crea un libro sin especificar detalles.
     */
    public Libro() {
        super();
    }

    /**
     * Constructor que inicializa un libro con todos los detalles especificados, incluyendo los de la publicación.
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
     * Constructor que inicializa un libro solo con el ISBN, utilizando el constructor de la clase padre.
     * @param isbn el ISBN de la publicación.
     */
    public Libro(String isbn) {
        super(isbn);
    }

    /**
     * Obtiene el autor del libro.
     * @return el autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     * @param autor el nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la edición del libro.
     * @return la edición del libro.
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * Establece la edición del libro.
     * @param edicion la nueva edición del libro.
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * Devuelve una representación en cadena del libro, incluyendo su ISBN, título, editorial, clasificación, autor y edición.
     * Utiliza {@code toString} de la clase padre para incluir los detalles de la publicación.
     * @return una cadena que representa el libro.
     */
    @Override
    public String toString() {
        return super.toString() + ", " + autor + ", " + edicion;
    }
}