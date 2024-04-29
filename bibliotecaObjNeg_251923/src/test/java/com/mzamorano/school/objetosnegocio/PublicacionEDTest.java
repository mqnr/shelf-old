package com.mzamorano.school.objetosnegocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PublicacionEDTest {
    private Publicacion publicacion;
    private PublicacionED publicacionED;

    @BeforeEach
    void setUp() {
        publicacion = new Publicacion("123-456-789", "Principios de Java", "Editorial ITSON", "Educación");
        publicacionED = new PublicacionED(publicacion, 100, 75);
    }

    @Test
    void pruebaConstructorVacio() {
        PublicacionED ped = new PublicacionED();
        assertNull(ped.getPublicacion(), "La publicación debería ser null después de usar el constructor vacío");
        assertEquals(0, ped.getExistencia(), "La existencia debería ser 0 después de usar el constructor vacío");
        assertEquals(0, ped.getDisponibilidad(), "La disponibilidad debería ser 0 después de usar el constructor vacío");
    }

    @Test
    void pruebaConstructorConPublicacion() {
        PublicacionED ped = new PublicacionED(publicacion);
        assertNotNull(ped.getPublicacion(), "La publicación no debería ser null");
        assertEquals(publicacion, ped.getPublicacion(), "La publicación no coincide con la proporcionada en el constructor");
        assertEquals(0, ped.getExistencia(), "La existencia debería ser 0 al inicializar sólo con publicación");
        assertEquals(0, ped.getDisponibilidad(), "La disponibilidad debería ser 0 al inicializar sólo con publicación");
    }

    @Test
    void pruebaConstructorCompleto() {
        assertNotNull(publicacionED.getPublicacion(), "La publicación no debería ser null después de ser inicializado");
        assertEquals(publicacion, publicacionED.getPublicacion(), "La publicación no coincide con la proporcionada en el constructor");
        assertEquals(100, publicacionED.getExistencia(), "La cantidad de existencia no coincide con la proporcionada en el constructor");
        assertEquals(75, publicacionED.getDisponibilidad(), "La cantidad de disponibilidad no coincide con la proporcionada en el constructor");
    }

    @Test
    void pruebaSetters() {
        publicacionED.setExistencia(50);
        assertEquals(50, publicacionED.getExistencia(), "La existencia no fue actualizada correctamente");

        publicacionED.setDisponibilidad(30);
        assertEquals(30, publicacionED.getDisponibilidad(), "La disponibilidad no fue actualizada correctamente");

        Publicacion nuevaPublicacion = new Publicacion("987-654-321", "Java Avanzado", "Editorial UNISON", "Tecnología");
        publicacionED.setPublicacion(nuevaPublicacion);
        assertEquals(nuevaPublicacion, publicacionED.getPublicacion(), "La publicación no fue actualizada correctamente");
    }

    @Test
    void pruebaEquals() {
        PublicacionED ped1 = new PublicacionED(publicacion, 100, 75);
        PublicacionED ped2 = new PublicacionED(publicacion, 50, 25);
        PublicacionED ped3 = new PublicacionED(new Publicacion("987-654-321"), 100, 75);

        assertTrue(publicacionED.equals(ped1), "Dos PublicacionED con la misma publicación deberían ser iguales");
        assertTrue(publicacionED.equals(ped2), "Dos PublicacionED con la misma publicación deberían ser iguales a pesar de diferentes existencias y disponibilidades");
        assertFalse(publicacionED.equals(ped3), "Dos PublicacionED con diferentes publicaciones no deberían ser iguales");
    }

    @Test
    void pruebaHashCode() {
        PublicacionED ped1 = new PublicacionED(publicacion, 100, 75);
        assertEquals(publicacionED.hashCode(), ped1.hashCode(), "Dos PublicacionED con la misma publicación deberían tener el mismo código hash");
    }

    @Test
    void pruebaToString() {
        assertEquals(publicacion + ", 100, 75", publicacionED.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
