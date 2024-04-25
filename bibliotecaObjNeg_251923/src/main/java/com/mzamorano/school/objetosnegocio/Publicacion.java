package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * Representa una publicación genérica en un sistema de gestión bibliotecaria.
 * Incluye información básica como ISBN, título, editorial y clasificación.
 */
public class Publicacion {
    /**
     * El International Standard Book Number (ISBN) de la publicación.
     * El ISBN es un identificador único para libros previsto por la norma ISO, utilizado internacionalmente para identificar de manera unívoca las publicaciones.
     */
    protected String isbn;

    /**
     * El título de la publicación.
     * Representa el nombre bajo el cual la publicación es conocida y catalogada.
     */
    protected String titulo;

    /**
     * La editorial que publica la obra.
     * Indica la compañía editorial responsable de la publicación y distribución de la publicación.
     */
    protected String editorial;

    /**
     * La clasificación de la publicación.
     * Se refiere a la categorización o clasificación temática de la publicación, lo cual ayuda a su identificación y ubicación dentro de un sistema de clasificación bibliotecario.
     */
    protected String clasificacion;


    /**
     * Constructor por ausencia. Crea una publicación sin especificar detalles.
     */
    public Publicacion() {
    }

    /**
     * Constructor que inicializa una publicación con todos los detalles especificados.
     * @param isbn el ISBN de la publicación.
     * @param titulo el título de la publicación.
     * @param editorial la editorial de la publicación.
     * @param clasificacion la clasificación de la publicación.
     */
    public Publicacion(String isbn, String titulo, String editorial, String clasificacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.clasificacion = clasificacion;
    }

    /**
     * Constructor que inicializa una publicación solo con el ISBN.
     * @param isbn el ISBN de la publicación.
     */
    public Publicacion(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el ISBN de la publicación.
     * @return el ISBN de la publicación.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN de la publicación.
     * @param isbn el nuevo ISBN de la publicación.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el título de la publicación.
     * @return el título de la publicación.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la publicación.
     * @param titulo el nuevo título de la publicación.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la editorial de la publicación.
     * @return la editorial de la publicación.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial de la publicación.
     * @param editorial la nueva editorial de la publicación.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene la clasificación de la publicación.
     * @return la clasificación de la publicación.
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Establece la clasificación de la publicación.
     * @param clasificacion la nueva clasificación de la publicación.
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * Determina si dos publicaciones son iguales basándose en su ISBN.
     * @param o el objeto con el que comparar.
     * @return {@code true} si ambos objetos son publicaciones con el mismo ISBN, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return Objects.equals(isbn, that.isbn);
    }

    /**
     * Calcula el código hash de la publicación basándose en su ISBN.
     * @return el código hash de la publicación.
     */
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    /**
     * Devuelve una representación en cadena de la publicación, incluyendo su ISBN, título, editorial y clasificación.
     * @return una cadena que representa la publicación.
     */
    @Override
    public String toString() {
        return isbn + ", " + titulo + ", " + editorial + ", " + clasificacion;
    }
}