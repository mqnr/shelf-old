package com.mzamorano.school.objetosnegocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PublicacionTest {
    private Publicacion publicacion;

    @BeforeEach
    void setUp() {
        publicacion = new Publicacion("123-456-789", "Principios de Java", "Editorial ITSON", "Educación");
    }

    @Test
    void testConstructorVacio() {
        Publicacion p = new Publicacion();
        assertNull(p.getIsbn(), "El ISBN debería ser null después de usar el constructor vacío");
        assertNull(p.getTitulo(), "El título debería ser null después de usar el constructor vacío");
        assertNull(p.getEditorial(), "La editorial debería ser null después de usar el constructor vacío");
        assertNull(p.getClasificacion(), "La clasificación debería ser null después de usar el constructor vacío");
    }

    @Test
    void testConstructorCompleto() {
        assertNotNull(publicacion.getIsbn(), "El ISBN no debería ser null después de ser inicializado");
        assertEquals("123-456-789", publicacion.getIsbn(), "El ISBN no coincide con el valor proporcionado en el constructor");
        assertEquals("Principios de Java", publicacion.getTitulo(), "El título no coincide con el valor proporcionado en el constructor");
        assertEquals("Editorial ITSON", publicacion.getEditorial(), "La editorial no coincide con el valor proporcionado en el constructor");
        assertEquals("Educación", publicacion.getClasificacion(), "La clasificación no coincide con el valor proporcionado en el constructor");
    }

    @Test
    void testConstructorISBN() {
        Publicacion p = new Publicacion("987-654-321");
        assertEquals("987-654-321", p.getIsbn(), "El ISBN debería coincidir con el valor proporcionado");
        assertNull(p.getTitulo(), "El título debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(p.getEditorial(), "La editorial debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(p.getClasificacion(), "La clasificación debería ser null cuando se utiliza el constructor solo con ISBN");
    }

    @Test
    void testSetters() {
        publicacion.setIsbn("321-654-987");
        assertEquals("321-654-987", publicacion.getIsbn(), "El ISBN no fue actualizado correctamente");

        publicacion.setTitulo("Java Avanzado");
        assertEquals("Java Avanzado", publicacion.getTitulo(), "El título no fue actualizado correctamente");

        publicacion.setEditorial("Editorial UNISON");
        assertEquals("Editorial UNISON", publicacion.getEditorial(), "La editorial no fue actualizada correctamente");

        publicacion.setClasificacion("Avanzado");
        assertEquals("Avanzado", publicacion.getClasificacion(), "La clasificación no fue actualizada correctamente");
    }

    @Test
    void testEquals() {
        Publicacion p1 = new Publicacion("123-456-789");
        Publicacion p2 = new Publicacion("123-456-789");
        Publicacion p3 = new Publicacion("987-654-321");

        assertEquals(p1, p2, "Dos publicaciones con el mismo ISBN deberían ser iguales");
        assertNotEquals(p1, p3, "Dos publicaciones con diferentes ISBN no deberían ser iguales");
        assertNotEquals(null, p1, "Una publicación no debería ser igual a null");
        assertNotEquals(p1, new Object(), "Una publicación no debería ser igual a un objeto de otra clase");
    }

    @Test
    void testHashCode() {
        Publicacion p1 = new Publicacion("123-456-789");
        Publicacion p2 = new Publicacion("123-456-789");
        Publicacion p3 = new Publicacion("987-654-321");

        assertEquals(p1.hashCode(), p2.hashCode(), "Dos publicaciones con el mismo ISBN deberían tener el mismo código hash");
        assertNotEquals(p1.hashCode(), p3.hashCode(), "Dos publicaciones con diferentes ISBN deberían tener diferentes códigos hash");
    }

    @Test
    void testToString() {
        assertEquals("123-456-789, Principios de Java, Editorial ITSON, Educación", publicacion.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
