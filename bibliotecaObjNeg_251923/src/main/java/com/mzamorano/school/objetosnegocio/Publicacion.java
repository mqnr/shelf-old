package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * Una {@code Publicacion} representa un objeto que encapsula los atributos
 * básicos de una publicación editorial, como libros, revistas, etc.
 *
 * <p>Esta clase proporciona un acceso estructurado a los atributos de la publicación,
 * permitiendo su manejo en sistemas que requieren la gestión de inventarios de publicaciones
 * o bibliotecas. Los atributos incluyen ISBN, título, editorial y clasificación.
 */
public class Publicacion {
    protected String isbn;
    protected String titulo;
    protected String editorial;
    protected String clasificacion;

    /**
     * Construye una {@code Publicacion} sin inicializar sus atributos.
     */
    public Publicacion() {
    }

    /**
     * Construye una {@code Publicacion} con los detalles editoriales dados.
     *
     * @param isbn el ISBN de la publicación, que sirve como identificador único.
     * @param titulo el título de la publicación.
     * @param editorial la editorial que publica la obra.
     * @param clasificacion la clasificación de la publicación, que puede usarse para categorizarla.
     */
    public Publicacion(String isbn, String titulo, String editorial, String clasificacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.clasificacion = clasificacion;
    }

    /**
     * Construye una {@code Publicacion} solo con el ISBN.
     *
     * @param isbn el ISBN de la publicación.
     */
    public Publicacion(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el ISBN de la publicación.
     *
     * @return el ISBN como una cadena de texto.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN de la publicación.
     *
     * @param isbn el nuevo ISBN de la publicación.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el título de la publicación.
     *
     * @return el título como una cadena de texto.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     *
     * @param titulo el nuevo título de la publicación.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve la editorial que publica la obra.
     *
     * @return la editorial como una cadena de texto.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial que publica la obra.
     *
     * @param editorial la nueva editorial de la publicación.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Devuelve la clasificación de la publicación.
     *
     * @return la clasificación como una cadena de texto.
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Establece la clasificación de la publicación.
     *
     * @param clasificacion la nueva clasificación de la publicación.
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Compara esta {@code Publicacion} al {@code Object} especificado. El resultado es {@code true} si y
     * solo si el argumento es un objeto {@code Publicacion} del mismo tipo con un ISBN equivalente.
     *
     * @param o el objeto con el que comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return Objects.equals(isbn, that.isbn);
    }

    /**
     * Devuelve el código hash para esta {@code Publicacion} basándose en su ISBN.
     *
     * @return el código hash de esta publicación.
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    /**
     * Devuelve una representación en cadena de la publicación.
     *
     * @return una cadena que representa la publicación, incluyendo ISBN, título, editorial y clasificación.
     */
    @Override
    public String toString() {
        return isbn + ", " + titulo + ", " + editorial + ", " + clasificacion;
    }
}
