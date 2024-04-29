package com.mzamorano.school.objetosnegocio;

import com.mzamorano.school.objetosservicio.Fecha;

/**
 * Una {@code Revista} es una especialización de {@code Publicacion} que además incluye
 * información específica relevante para publicaciones periódicas, como la periodicidad y la fecha de publicación.
 *
 * <p>Esta clase permite gestionar revistas dentro de sistemas que requieren llevar un control sobre publicaciones
 * que tienen una aparición recurrente en el tiempo, proporcionando métodos para establecer y recuperar la periodicidad
 * y la fecha de cada edición.
 */
public class Revista extends Publicacion {
    private String periodicidad;
    private Fecha fecha;

    /**
     * Construye una {@code Revista} sin inicializar sus atributos.
     */
    public Revista() {
        super();
    }

    /**
     * Construye una {@code Revista} con los detalles editoriales, periodicidad, y fecha dados.
     *
     * @param isbn el ISBN de la revista.
     * @param titulo el título de la revista.
     * @param editorial la editorial que publica la revista.
     * @param clasificacion la clasificación de la revista.
     * @param periodicidad la periodicidad de publicación de la revista (ej. mensual, anual).
     * @param fecha la fecha de publicación de la edición actual de la revista.
     */
    public Revista(String isbn, String titulo, String editorial, String clasificacion, String periodicidad, Fecha fecha) {
        super(isbn, titulo, editorial, clasificacion);
        this.periodicidad = periodicidad;
        this.fecha = fecha;
    }

    /**
     * Construye una {@code Revista} con el ISBN dado.
     *
     * @param isbn el ISBN de la publicación.
     */
    public Revista(String isbn) {
        super(isbn);
    }

    /**
     * Devuelve la periodicidad de la revista.
     *
     * @return la periodicidad de la revista.
     */
    public String getPeriodicidad() {
        return periodicidad;
    }

    /**
     * Establece la periodicidad de la revista.
     *
     * @param periodicidad la nueva periodicidad de la revista.
     */
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    /**
     * Devuelve la fecha de publicación de la revista.
     *
     * @return la fecha de publicación de la revista.
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de publicación de la revista.
     *
     * @param fecha la nueva fecha de publicación de la revista.
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve una representación en cadena de la revista,
     * incluyendo su ISBN, título, editorial, clasificación, periodicidad y fecha de publicación.
     *
     * @return Una cadena que representa la revista.
     */
    @Override
    public String toString() {
        return super.toString() + ", " + periodicidad + ", " + fecha;
    }
}
