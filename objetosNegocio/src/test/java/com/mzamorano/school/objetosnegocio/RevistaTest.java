package com.mzamorano.school.objetosnegocio;

import com.mzamorano.school.objetosservicio.Fecha;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RevistaTest {
    private Revista revista;
    private Fecha fechaPublicacion;

    @BeforeEach
    void setUp() {
        fechaPublicacion = new Fecha(1, 1, 2024);
        revista = new Revista("123-456-789", "Ciencia Hoy", "Editorial Científica", "Ciencia", "Mensual", fechaPublicacion);
    }

    @Test
    void testConstructorVacio() {
        Revista r = new Revista();
        assertNull(r.getIsbn(), "El ISBN debería ser null después de usar el constructor vacío");
        assertNull(r.getTitulo(), "El título debería ser null después de usar el constructor vacío");
        assertNull(r.getEditorial(), "La editorial debería ser null después de usar el constructor vacío");
        assertNull(r.getClasificacion(), "La clasificación debería ser null después de usar el constructor vacío");
        assertNull(r.getPeriodicidad(), "La periodicidad debería ser null después de usar el constructor vacío");
        assertNull(r.getFecha(), "La fecha debería ser null después de usar el constructor vacío");
    }

    @Test
    void testConstructorCompleto() {
        assertNotNull(revista.getIsbn(), "El ISBN no debería ser null después de ser inicializado");
        assertEquals("123-456-789", revista.getIsbn(), "El ISBN no coincide con el valor proporcionado en el constructor");
        assertEquals("Ciencia Hoy", revista.getTitulo(), "El título no coincide con el valor proporcionado en el constructor");
        assertEquals("Editorial Científica", revista.getEditorial(), "La editorial no coincide con el valor proporcionado en el constructor");
        assertEquals("Ciencia", revista.getClasificacion(), "La clasificación no coincide con el valor proporcionado en el constructor");
        assertEquals("Mensual", revista.getPeriodicidad(), "La periodicidad no coincide con el valor proporcionado en el constructor");
        assertEquals(fechaPublicacion, revista.getFecha(), "La fecha no coincide con el valor proporcionado en el constructor");
    }

    @Test
    void testConstructorISBN() {
        Revista r = new Revista("987-654-321");
        assertEquals("987-654-321", r.getIsbn(), "El ISBN debería coincidir con el valor proporcionado");
        assertNull(r.getTitulo(), "El título debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(r.getEditorial(), "La editorial debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(r.getClasificacion(), "La clasificación debería ser null cuando se utiliza el constructor solo con ISBN");
        assertNull(r.getPeriodicidad(), "La periodicidad debería ser null en un constructor solo con ISBN");
        assertNull(r.getFecha(), "La fecha debería ser null en un constructor solo con ISBN");
    }

    @Test
    void testSetters() {
        revista.setIsbn("321-654-987");
        assertEquals("321-654-987", revista.getIsbn(), "El ISBN no fue actualizado correctamente");

        revista.setTitulo("Ciencia Mañana");
        assertEquals("Ciencia Mañana", revista.getTitulo(), "El título no fue actualizado correctamente");

        revista.setEditorial("Editorial del Futuro");
        assertEquals("Editorial del Futuro", revista.getEditorial(), "La editorial no fue actualizada correctamente");

        revista.setClasificacion("Tecnología");
        assertEquals("Tecnología", revista.getClasificacion(), "La clasificación no fue actualizada correctamente");

        revista.setPeriodicidad("Anual");
        assertEquals("Anual", revista.getPeriodicidad(), "La periodicidad no fue actualizada correctamente");

        Fecha nuevaFecha = new Fecha(1, 2, 2025);
        revista.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, revista.getFecha(), "La fecha no fue actualizada correctamente");
    }

    @Test
    void testToString() {
        assertEquals("123-456-789, Ciencia Hoy, Editorial Científica, Ciencia, Mensual, 01/01/2024", revista.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
