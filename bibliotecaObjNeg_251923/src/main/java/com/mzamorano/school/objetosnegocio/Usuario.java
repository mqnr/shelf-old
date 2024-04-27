package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * Un {@code Usuario} representa a un usuario de la biblioteca, incluyendo su credencial,
 * nombre, dirección y teléfono.
 *
 * <p>Esta clase facilita la gestión de usuarios en sistemas que requieren mantener un registro
 * detallado de sus miembros para servicios de préstamo, notificaciones y otros requerimientos
 * administrativos.
 */
public class Usuario {
    private String numCredencial;
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * Construye un {@code Usuario} sin inicializar sus atributos.
     */
    public Usuario() {
    }

    /**
     * Construye un {@code Usuario} con los datos dados.
     *
     * @param numCredencial número de credencial único del usuario.
     * @param nombre nombre completo del usuario.
     * @param direccion dirección postal del usuario.
     * @param telefono número de teléfono de contacto del usuario.
     */
    public Usuario(String numCredencial, String nombre, String direccion, String telefono) {
        this.numCredencial = numCredencial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /**
     * Construye un {@code Usuario} con el número de credencial dado.
     *
     * @param numCredencial número de credencial único del usuario.
     */
    public Usuario(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    /**
     * Devuelve el número de credencial del usuario.
     *
     * @return número de credencial único del usuario.
     */
    public String getNumCredencial() {
        return numCredencial;
    }

    /**
     * Establece el número de credencial del usuario.
     *
     * @param numCredencial número de credencial único del usuario.
     */
    public void setNumCredencial(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return nombre completo del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre nombre completo del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del usuario.
     *
     * @return dirección postal del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     *
     * @param direccion dirección postal del usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el número de teléfono del usuario.
     *
     * @return número de teléfono de contacto del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono número de teléfono de contacto del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Compara este {@code Usuario} al {@code Object} especificado. El resultado es {@code true} si y
     * solo si el argumento es un objeto {@code Usuario} con un número de credencial equivalente.
     *
     * @param o el objeto con el que comparar.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(numCredencial, usuario.numCredencial);
    }

    /**
     * Devuelve el código hash para este {@code Usuario} basándose en su número de credencial.
     *
     * @return el código hash de este usuario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numCredencial);
    }

    /**
     * Devuelve una representación en cadena del usuario.
     *
     * @return una cadena que representa al usuario, incluyendo su número de credencial, nombre, dirección y teléfono
     */
    @Override
    public String toString() {
        return numCredencial + ", " + nombre + ", " + direccion + ", " + telefono;
    }
}