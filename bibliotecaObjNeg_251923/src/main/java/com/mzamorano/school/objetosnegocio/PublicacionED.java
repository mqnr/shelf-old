package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * {@code PublicacionED} (Publicación Existencia y Disponibilidad) encapsula la información de existencia y disponibilidad
 * de una {@code Publicacion} en el inventario de la biblioteca.
 *
 * <p>Esta clase es esencial para el manejo de inventarios en sistemas que gestionan bibliotecas o puntos de venta
 * de publicaciones, permitiendo el seguimiento detallado de cuántas copias de una publicación están disponibles
 * para ser prestadas o vendidas.
 */
public class PublicacionED {
    private Publicacion publicacion;
    private int existencia;
    private int disponibilidad;

    /**
     * Construye una {@code PublicacionED} sin inicializar sus atributos.
     */
    public PublicacionED() {
    }

    /**
     * Construye una {@code PublicacionED} con una publicación y sus respectivas cantidades de existencia y disponibilidad.
     *
     * @param publicacion la publicación a la que se refiere esta entrada de inventario.
     * @param existencia el total de copias existentes de la publicación.
     * @param disponibilidad el número de copias disponibles.
     */
    public PublicacionED(Publicacion publicacion, int existencia, int disponibilidad) {
        this.publicacion = publicacion;
        this.existencia = existencia;
        this.disponibilidad = disponibilidad;
    }

    /**
     * Construye una {@code PublicacionED} con una publicación dada.
     *
     * @param publicacion la publicación de esta entrada de inventario.
     */
    public PublicacionED(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Devuelve la publicación asociada con esta entrada de inventario.
     *
     * @return la publicación.
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    /**
     * Establece la publicación asociada con esta entrada de inventario.
     *
     * @param publicacion la nueva publicación.
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Devuelve el total de copias existentes de la publicación.
     *
     * @return el número de existencias.
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * Establece el total de copias existentes de la publicación.
     *
     * @param existencia el nuevo total de existencias.
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * Devuelve el número de copias disponibles de la publicación.
     *
     * @return el número de disponibilidades.
     */
    public int getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece el número de copias disponibles de la publicación.
     *
     * @param disponibilidad el nuevo número de disponibilidades.
     */
    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Compara esta {@code PublicacionED} al {@code Object} especificado. El resultado es {@code true} si y
     * solo si el argumento es un objeto {@code PrestamoED} con la misma publicación.
     *
     * @param o el objeto con el que comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicacionED that = (PublicacionED) o;
        return Objects.equals(publicacion, that.publicacion);
    }

    /**
     * Devuelve el código hash para este {@code PrestamoED} basándose en su publicación.
     *
     * @return el código hash de esta entrada de inventario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(publicacion);
    }

    /**
     * Devuelve una representación en cadena de la entrada de inventario.
     *
     * @return una cadena que representa esta entrada de inventario, incluyendo la publicación y sus cantidades de existencia y disponibilidad.
     */
    @Override
    public String toString() {
        return publicacion + ", " + existencia + ", " + disponibilidad;
    }
}