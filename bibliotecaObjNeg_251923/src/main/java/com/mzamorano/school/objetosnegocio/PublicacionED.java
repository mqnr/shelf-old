package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * Gestiona la información de existencia y disponibilidad de una {@link Publicacion} en el inventario.
 * Esta clase encapsula una publicación junto con sus datos de existencia (total de copias) y disponibilidad (copias disponibles para préstamo o venta).
 */
public class PublicacionED {
    private Publicacion publicacion;
    private int existencia;
    private int disponibilidad;

    /**
     * Constructor por defecto que crea una instancia sin especificar la publicación ni sus cantidades.
     */
    public PublicacionED() {
    }

    /**
     * Constructor que inicializa una instancia con una publicación específica y sus respectivas cantidades de existencia y disponibilidad.
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
     * Constructor que inicializa una instancia solo con la publicación.
     * @param publicacion la publicación de esta entrada de inventario.
     */
    public PublicacionED(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Obtiene la publicación asociada con esta entrada de inventario.
     * @return La publicación.
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    /**
     * Establece la publicación asociada con esta entrada de inventario.
     * @param publicacion la nueva publicación.
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Obtiene el total de copias existentes de la publicación.
     * @return el número de existencias.
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * Establece el total de copias existentes de la publicación.
     * @param existencia el nuevo total de existencias.
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * Obtiene el número de copias disponibles de la publicación.
     * @return el número de disponibilidades.
     */
    public int getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece el número de copias disponibles de la publicación.
     * @param disponibilidad el nuevo número de disponibilidades.
     */
    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Determina si dos instancias de {@link PublicacionED} son iguales, basándose en la publicación asociada.
     * @param o el objeto con el que comparar.
     * @return {@code true} si ambas instancias se refieren a la misma publicación, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicacionED that = (PublicacionED) o;
        return Objects.equals(publicacion, that.publicacion);
    }

    /**
     * Calcula el código hash de esta instancia, basándose en la publicación asociada.
     * @return el código hash de esta instancia.
     */
    @Override
    public int hashCode() {
        return Objects.hash(publicacion);
    }

    /**
     * Devuelve una representación en cadena de esta entrada de inventario, incluyendo la publicación y sus cantidades de existencia y disponibilidad.
     * @return una cadena que representa esta entrada de inventario.
     */
    @Override
    public String toString() {
        return publicacion + ", " + existencia + ", " + disponibilidad;
    }
}