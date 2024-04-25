package com.mzamorano.school.objetosnegocio;

import com.mzamorano.school.objetosservicio.Fecha;

/**
 * Representa una revista en un sistema de gestión bibliotecaria.
 * Extiende {@link Publicacion} para incluir detalles específicos de revistas, como la periodicidad y la fecha de publicación.
 */
public class Revista extends Publicacion {
    private String periodicidad;
    private Fecha fecha;

    /**
     * Constructor por ausencia. Crea una revista sin especificar detalles.
     */
    public Revista() {
        super();
    }

    /**
     * Constructor que inicializa una revista con todos los detalles especificados, incluyendo los de la publicación.
     * @param isbn el ISBN de la publicación.
     * @param titulo el título de la publicación.
     * @param editorial la editorial de la publicación.
     * @param clasificacion la clasificación de la publicación.
     * @param periodicidad la periodicidad de la revista.
     * @param fecha la fecha de publicación de la revista.
     */
    public Revista(String isbn, String titulo, String editorial, String clasificacion, String periodicidad, Fecha fecha) {
        super(isbn, titulo, editorial, clasificacion);
        this.periodicidad = periodicidad;
        this.fecha = fecha;
    }

    /**
     * Constructor que inicializa una revista solo con el ISBN, utilizando el constructor de la clase padre.
     * @param isbn el ISBN de la publicación.
     */
    public Revista(String isbn) {
        super(isbn);
    }

    /**
     * Obtiene la periodicidad de la revista.
     * @return la periodicidad de la revista.
     */
    public String getPeriodicidad() {
        return periodicidad;
    }

    /**
     * Establece la periodicidad de la revista.
     * @param periodicidad la nueva periodicidad de la revista.
     */
    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    /**
     * Obtiene la fecha de publicación de la revista.
     * @return la fecha de publicación de la revista.
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de publicación de la revista.
     * @param fecha la nueva fecha de publicación de la revista.
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve una representación en cadena de la revista, incluyendo su ISBN, título, editorial, clasificación, periodicidad y fecha de publicación.
     * @return Una cadena que representa la revista.
     */
    @Override
    public String toString() {
        return super.toString() + ", " + periodicidad + ", " + fecha;
    }
}