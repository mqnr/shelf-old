package com.mzamorano.school.objetosnegocio;

import java.util.Objects;

/**
 * Representa un usuario dentro del sistema de gestión bibliotecaria.
 * Almacena información personal y de contacto del usuario, necesaria para la gestión de préstamos y reservas.
 */
public class Usuario {
    private String numCredencial;
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * Constructor por defecto. Crea un usuario sin especificar detalles.
     */
    public Usuario() {
    }

    /**
     * Constructor que inicializa un usuario con todos los detalles especificados.
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
     * Constructor que inicializa un usuario solo con el número de credencial.
     * @param numCredencial número de credencial único del usuario.
     */
    public Usuario(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    /**
     * Obtiene el número de credencial del usuario.
     * @return número de credencial único del usuario.
     */
    public String getNumCredencial() {
        return numCredencial;
    }

    /**
     * Establece el número de credencial del usuario.
     * @param numCredencial número de credencial único del usuario.
     */
    public void setNumCredencial(String numCredencial) {
        this.numCredencial = numCredencial;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return nombre completo del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre nombre completo del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del usuario.
     * @return dirección postal del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     * @param direccion dirección postal del usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * @return número de teléfono de contacto del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     * @param telefono número de teléfono de contacto del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Determina si dos usuarios son iguales basándose en su número de credencial.
     * @param o el objeto con el que comparar.
     * @return {@code true} si ambos usuarios tienen el mismo número de credencial, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(numCredencial, usuario.numCredencial);
    }

    /**
     * Calcula el código hash del usuario basándose en su número de credencial.
     * @return el código hash del usuario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numCredencial);
    }

    /**
     * Devuelve una representación en cadena del usuario, incluyendo su número de credencial, nombre, dirección y teléfono.
     * @return una cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return numCredencial + ", " + nombre + ", " + direccion + ", " + telefono;
    }
}