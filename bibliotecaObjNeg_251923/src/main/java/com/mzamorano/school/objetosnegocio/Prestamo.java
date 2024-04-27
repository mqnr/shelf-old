package com.mzamorano.school.objetosnegocio;

import com.mzamorano.school.objetosservicio.Fecha;

import java.util.Objects;

/**
 * Un {@code Prestamo} representa un préstamo de una {@link Publicacion} a un {@link Usuario},
 * incluyendo detalles como la fecha del préstamo y el tiempo estimado de préstamo.
 *
 * <p>Esta clase es crucial para el manejo de préstamos en sistemas de biblioteca, permitiendo un seguimiento
 * efectivo del estado de las publicaciones y su disponibilidad, además de facilitar la gestión de las devoluciones.
 */
public class Prestamo {
    private Usuario usuario;
    private Publicacion publicacion;
    private Fecha fechaPrestamo;
    private int tiempoPrestamo;

    /**
     * Construye un {@code Prestamo} sin inicializar sus atributos.
     */
    public Prestamo() {
    }

    /**
     * Construye un {@code Prestamo} con un usuario, publicación, y fecha y duración dados.
     *
     * @param usuario el {@link Usuario} al que se le presta la publicación.
     * @param publicacion la {@link Publicacion} que se presta.
     * @param fechaPrestamo la {@link Fecha} en la que se realiza el préstamo.
     * @param tiempoPrestamo el tiempo de duración del préstamo en días.
     */
    public Prestamo(Usuario usuario, Publicacion publicacion, Fecha fechaPrestamo, int tiempoPrestamo) {
        this.usuario = usuario;
        this.publicacion = publicacion;
        this.fechaPrestamo = fechaPrestamo;
        this.tiempoPrestamo = tiempoPrestamo;
    }

    /**
     * Construye un {@code Prestamo} con el usuario y publicación dados.
     *
     * @param usuario el usuario al que se le presta la publicación.
     * @param publicacion la publicación que se presta.
     */
    public Prestamo(Usuario usuario, Publicacion publicacion) {
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    /**
     * Devuelve el usuario que solicitó el préstamo.
     *
     * @return el usuario que solicitó el préstamo.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que solicitó el préstamo.
     *
     * @param usuario el nuevo usuario que solicitó el préstamo.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la publicación que se presta.
     *
     * @return la publicación que se presta.
     */
    public Publicacion getPublicacion() {
        return publicacion;
    }

    /**
     * Establece la publicación que se presta.
     *
     * @param publicacion la nueva publicación que se presta.
     */
    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    /**
     * Devuelve la fecha en la que se realiza el préstamo.
     *
     * @return la fecha del préstamo.
     */
    public Fecha getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece la fecha en la que se realiza el préstamo.
     *
     * @param fechaPrestamo la nueva fecha del préstamo.
     */
    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Devuelve el tiempo de duración del préstamo, expresado en días.
     *
     * @return el tiempo del préstamo en días.
     */
    public int getTiempoPrestamo() {
        return tiempoPrestamo;
    }

    /**
     * Establece el tiempo de duración del préstamo, expresado en días.
     *
     * @param tiempoPrestamo el nuevo tiempo del préstamo en días.
     */
    public void setTiempoPrestamo(int tiempoPrestamo) {
        this.tiempoPrestamo = tiempoPrestamo;
    }

    /**
     * Compara este {@code Prestamo} al {@code Object} especificado. El resultado es {@code true} si y
     * solo si el argumento es un objeto {@code Prestamo} con el mismo usuario y publicación.
     *
     * @param o el objeto con el que comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(usuario, prestamo.usuario) && Objects.equals(publicacion, prestamo.publicacion);
    }

    /**
     * Devuelve el código hash para este {@code Prestamo} basándose en su usuario y publicación.
     *
     * @return el código hash de este préstamo.
     */
    @Override
    public int hashCode() {
        return Objects.hash(usuario, publicacion);
    }

    /**
     * Devuelve una representación en cadena del préstamo.
     *
     * @return una cadena que representa el préstamo, incluyendo el usuario, la publicación, la fecha del préstamo y el tiempo de préstamo.
     */
    @Override
    public String toString() {
        return usuario + ", " + publicacion + ", " + fechaPrestamo + ", " + tiempoPrestamo;
    }
}