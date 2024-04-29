package com.mzamorano.school.objetosnegocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibroTest {
    private Libro libro;

    @BeforeEach
    void setUp() {
        libro = new Libro("123-456-789", "Principios de Java", "Editorial ITSON", "Educación", "Juan Pérez", "Primera Edición");
    }

    @Test
    void testConstructorVacio() {
        Libro l = new Libro();
        assertNull(l.getIsbn(), "El ISBN debería ser null después de usar el constructor vacío");
        assertNull(l.getTitulo(), "El título debería ser null después de usar el constructor vacío");
        assertNull(l.getEditorial(), "La editorial debería ser null después de usar el constructor vacío");
        assertNull(l.getClasificacion(), "La clasificación debería ser null después de usar el constructor vacío");
        assertNull(l.getAutor(), "El autor debería ser null después de usar el constructor vacío");
        assertNull(l.getEdicion(), "La edición debería ser null después de usar el constructor vacío");
    }

    @Test
    void testConstructorCompleto() {
        assertNotNull(libro.getIsbn(), "El ISBN no debería ser null después de ser inicializado");
        assertEquals("123-456-789", libro.getIsbn(), "El ISBN no coincide con el valor proporcionado en el constructor");
        assertEquals("Principios de Java", libro.getTitulo(), "El título no coincide con el valor proporcionado en el constructor");
        assertEquals("Editorial ITSON", libro.getEditorial(), "La editorial no coincide con el valor proporcionado en el constructor");
        assertEquals("Educación", libro.getClasificacion(), "La clasificación no coincide con el valor proporcionado en el constructor");
        assertEquals("Juan Pérez", libro.getAutor(), "El autor no coincide con el valor proporcionado en el constructor");
        assertEquals("Primera Edición", libro.getEdicion(), "La edición no coincide con el valor proporcionado en el constructor");
    }

    @Test
    void testConstructorISBN() {
        Libro l = new Libro("987-654-321");
        assertEquals("987-654-321", l.getIsbn(), "El ISBN debería coincidir con el valor proporcionado");
        assertNull(l.getTitulo(), "El título debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(l.getEditorial(), "La editorial debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(l.getClasificacion(), "La clasificación debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(l.getAutor(), "El autor debería ser null en un constructor solo con ISBN");
        assertNull(l.getEdicion(), "La edición debería ser null en un constructor solo con ISBN");
    }

    @Test
    void testSetters() {
        libro.setIsbn("321-654-987");
        assertEquals("321-654-987", libro.getIsbn(), "El ISBN no fue actualizado correctamente");

        libro.setTitulo("Java Avanzado");
        assertEquals("Java Avanzado", libro.getTitulo(), "El título no fue actualizado correctamente");

        libro.setEditorial("Editorial UNISON");
        assertEquals("Editorial UNISON", libro.getEditorial(), "La editorial no fue actualizada correctamente");

        libro.setClasificacion("Avanzado");
        assertEquals("Avanzado", libro.getClasificacion(), "La clasificación no fue actualizada correctamente");

        libro.setAutor("María López");
        assertEquals("María López", libro.getAutor(), "El autor no fue actualizado correctamente");

        libro.setEdicion("Segunda Edición");
        assertEquals("Segunda Edición", libro.getEdicion(), "La edición no fue actualizada correctamente");
    }

    @Test
    void testToString() {
        assertEquals("123-456-789, Principios de Java, Editorial ITSON, Educación, Juan Pérez, Primera Edición", libro.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
