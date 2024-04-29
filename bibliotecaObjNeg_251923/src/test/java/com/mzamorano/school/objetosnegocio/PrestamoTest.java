package com.mzamorano.school.objetosnegocio;

import static org.junit.jupiter.api.Assertions.*;

import com.mzamorano.school.objetosservicio.Fecha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrestamoTest {
    private Usuario usuario;
    private Publicacion publicacion;
    private Fecha fechaPrestamo;
    private Prestamo prestamo;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("001122", "Juan Pérez", "Calle Falsa 123", "555-12345");
        publicacion = new Publicacion("123-456-789", "Principios de Java", "Editorial Universitaria", "Educación");
        fechaPrestamo = new Fecha(10, 3, 2024); // Assuming Fecha has a constructor with day, month, year
        prestamo = new Prestamo(usuario, publicacion, fechaPrestamo, 30);
    }

    @Test
    void pruebaConstructorVacio() {
        Prestamo p = new Prestamo();
        assertNull(p.getUsuario(), "El usuario debería ser null después de usar el constructor vacío");
        assertNull(p.getPublicacion(), "La publicación debería ser null después de usar el constructor vacío");
        assertNull(p.getFechaPrestamo(), "La fecha del préstamo debería ser null después de usar el constructor vacío");
        assertEquals(0, p.getTiempoPrestamo(), "El tiempo de préstamo debería ser 0 después de usar el constructor vacío");
    }

    @Test
    void pruebaConstructorCompleto() {
        assertNotNull(prestamo.getUsuario(), "El usuario no debería ser null");
        assertEquals(usuario, prestamo.getUsuario(), "El usuario no coincide con el proporcionado en el constructor");
        assertNotNull(prestamo.getPublicacion(), "La publicación no debería ser null");
        assertEquals(publicacion, prestamo.getPublicacion(), "La publicación no coincide con la proporcionada en el constructor");
        assertNotNull(prestamo.getFechaPrestamo(), "La fecha del préstamo no debería ser null");
        assertEquals(fechaPrestamo, prestamo.getFechaPrestamo(), "La fecha del préstamo no coincide con la proporcionada en el constructor");
        assertEquals(30, prestamo.getTiempoPrestamo(), "El tiempo de préstamo no coincide con el proporcionado en el constructor");
    }

    @Test
    void pruebaConstructorConUsuarioYPublicacion() {
        Prestamo p = new Prestamo(usuario, publicacion);
        assertEquals(usuario, p.getUsuario(), "El usuario debería coincidir con el proporcionado");
        assertEquals(publicacion, p.getPublicacion(), "La publicación debería coincidir con la proporcionada");
        assertNull(p.getFechaPrestamo(), "La fecha del préstamo debería ser null");
        assertEquals(0, p.getTiempoPrestamo(), "El tiempo de préstamo debería ser 0");
    }

    @Test
    void pruebaSetters() {
        Usuario nuevoUsuario = new Usuario("003344", "Ana López", "Avenida Principal 456", "555-67890");
        Publicacion nuevaPublicacion = new Publicacion("987-654-321", "Java Avanzado", "Editorial Profesional", "Tecnología");
        Fecha nuevaFecha = new Fecha(11, 4, 2024);

        prestamo.setUsuario(nuevoUsuario);
        assertEquals(nuevoUsuario, prestamo.getUsuario(), "El usuario no fue actualizado correctamente");

        prestamo.setPublicacion(nuevaPublicacion);
        assertEquals(nuevaPublicacion, prestamo.getPublicacion(), "La publicación no fue actualizada correctamente");

        prestamo.setFechaPrestamo(nuevaFecha);
        assertEquals(nuevaFecha, prestamo.getFechaPrestamo(), "La fecha del préstamo no fue actualizada correctamente");

        prestamo.setTiempoPrestamo(45);
        assertEquals(45, prestamo.getTiempoPrestamo(), "El tiempo de préstamo no fue actualizado correctamente");
    }

    @Test
    void pruebaEquals() {
        Prestamo p1 = new Prestamo(usuario, publicacion, fechaPrestamo, 30);
        Prestamo p2 = new Prestamo(usuario, publicacion, new Fecha(11, 4, 2024), 15);
        Prestamo p3 = new Prestamo(new Usuario("003344"), new Publicacion("987-654-321"), fechaPrestamo, 30);

        assertTrue(prestamo.equals(p1), "Dos préstamos con el mismo usuario y publicación deberían ser iguales");
        assertTrue(prestamo.equals(p2), "Dos préstamos con el mismo usuario y publicación deberían ser iguales, independientemente de fecha y duración");
        assertFalse(prestamo.equals(p3), "Dos préstamos con diferentes usuarios o publicaciones no deberían ser iguales");
    }

    @Test
    void pruebaHashCode() {
        Prestamo p1 = new Prestamo(usuario, publicacion);
        assertEquals(prestamo.hashCode(), p1.hashCode(), "Dos préstamos con el mismo usuario y publicación deberían tener el mismo código hash");
    }

    @Test
    void pruebaToString() {
        assertEquals(usuario + ", " + publicacion + ", " + fechaPrestamo + ", " + 30, prestamo.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
