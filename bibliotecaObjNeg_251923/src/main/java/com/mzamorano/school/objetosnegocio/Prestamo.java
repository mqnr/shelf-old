package com.mzamorano.school.objetosnegocio;

import com.mzamorano.school.objetosservicio.Fecha;

import java.util.Objects;

/**
 * Representa un préstamo de una publicación a un usuario dentro del sistema de gestión bibliotecaria.
 * Incluye información sobre el usuario, la publicación prestada, la fecha del préstamo, y el tiempo de préstamo.
 */
public class Prestamo {
    private Usuario usuario;
    private Publicacion publicacion;
    private Fecha fechaPrestamo;
    private int tiempoPrestamo;

    /**
     * Constructor por defecto que crea un préstamo sin especificar detalles.
     */
    public Prestamo() {
    }

    /**
     * Constructor que inicializa un préstamo con todos los detalles especificados.
     * @param usuario el usuario al que se le presta la publicación.
     * @param publicacion la publicación que se presta.
     * @param fechaPrestamo la fecha en la que se realiza el préstamo.
     * @param tiempoPrestamo el tiempo de duración del préstamo en días.
     */
    public Prestamo(Usuario usuario, Publicacion publicacion, Fecha fechaPrestamo, int tiempoPrestamo) {
        this.usuario = usuario;
        this.publicacion = publicacion;
        this.fechaPrestamo = fechaPrestamo;
        this.tiempoPrestamo = tiempoPrestamo;
    }

    /**
     * Constructor que inicializa un préstamo con el usuario y la publicación, sin especificar la fecha ni el tiempo de préstamo.
     * @param usuario el usuario al que se le presta la publicación.
     * @param publicacion la publicación que se presta.
     */
    public Prestamo(Usuario usuario, Publicacion publicacion) {
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    /**
     * Obtiene el usuario que realiza el préstamo.
     * @return el usuario que realiza el préstamo.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realiza el préstamo.
     * @param usuario el nuevo usuario que realiza el préstamo.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la publicación que se presta.
     * @return la publicación que se presta.
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    /**
     * Establece la publicación que se presta.
     * @param publicacion la nueva publicación que se presta.
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Obtiene la fecha en la que se realiza el préstamo.
     * @return la fecha del préstamo.
     */
    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece la fecha en la que se realiza el préstamo.
     * @param fechaPrestamo la nueva fecha del préstamo.
     */
    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Obtiene el tiempo de duración del préstamo, expresado en días.
     * @return el tiempo del préstamo en días.
     */
    public int getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    /**
     * Establece el tiempo de duración del préstamo, expresado en días.
     * @param tiempoPrestamo el nuevo tiempo del préstamo en días.
     */
    public void setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    /**
     * Determina si dos préstamos son iguales, basándose en el usuario y la publicación.
     * @param o el objeto con el que comparar.
     * @return {@code true} si ambos préstamos tienen el mismo usuario y publicación, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(usuario, prestamo.usuario) && Objects.equals(publicacion, prestamo.publicacion);
    }

    /**
     * Calcula el código hash de esta instancia, basándose en el usuario y la publicación asociada.
     * @return el código hash de esta instancia.
     */
    @Override
    public int hashCode() {
        return Objects.hash(usuario, publicacion);
    }

    /**
     * Devuelve una representación en cadena del préstamo, incluyendo el usuario, la publicación, la fecha del préstamo y el tiempo de préstamo.
     * @return una cadena que representa el préstamo.
     */
    @Override
    public String toString() {
        return usuario + ", " + publicacion + ", " + fechaPrestamo + ", " + tiempoPrestamo;
    }
}