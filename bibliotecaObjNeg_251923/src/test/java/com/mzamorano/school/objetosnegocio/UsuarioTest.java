package com.mzamorano.school.objetosnegocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("001122", "Juan Pérez", "Calle Falsa 123", "555-12345");
    }

    @Test
    void pruebaConstructorVacio() {
        Usuario u = new Usuario();
        assertNull(u.getNumCredencial(), "El número de credencial debería ser null después de usar el constructor vacío");
        assertNull(u.getNombre(), "El nombre debería ser null después de usar el constructor vacío");
        assertNull(u.getDireccion(), "La dirección debería ser null después de usar el constructor vacío");
        assertNull(u.getTelefono(), "El teléfono debería ser null después de usar el constructor vacío");
    }

    @Test
    void pruebaConstructorCompleto() {
        assertNotNull(usuario.getNumCredencial(), "El número de credencial no debería ser null después de ser inicializado");
        assertEquals("001122", usuario.getNumCredencial(), "El número de credencial no coincide con el valor proporcionado en el constructor");
        assertEquals("Juan Pérez", usuario.getNombre(), "El nombre no coincide con el valor proporcionado en el constructor");
        assertEquals("Calle Falsa 123", usuario.getDireccion(), "La dirección no coincide con el valor proporcionado en el constructor");
        assertEquals("555-12345", usuario.getTelefono(), "El teléfono no coincide con el valor proporcionado en el constructor");
    }

    @Test
    void pruebaConstructorConNumCredencial() {
        Usuario u = new Usuario("002233");
        assertEquals("002233", u.getNumCredencial(), "El número de credencial debería coincidir con el valor proporcionado");
        assertNull(u.getNombre(), "El nombre debería ser null cuando se utiliza el constructor solo con número de credencial");
        assertNull(u.getDireccion(), "La dirección debería ser null cuando se utiliza el constructor solo con número de credencial");
        assertNull(u.getTelefono(), "El teléfono debería ser null cuando se utiliza el constructor solo con número de credencial");
    }

    @Test
    void pruebaSetters() {
        usuario.setNumCredencial("003344");
        assertEquals("003344", usuario.getNumCredencial(), "El número de credencial no fue actualizado correctamente");

        usuario.setNombre("Ana López");
        assertEquals("Ana López", usuario.getNombre(), "El nombre no fue actualizado correctamente");

        usuario.setDireccion("Avenida Principal 456");
        assertEquals("Avenida Principal 456", usuario.getDireccion(), "La dirección no fue actualizada correctamente");

        usuario.setTelefono("555-67890");
        assertEquals("555-67890", usuario.getTelefono(), "El teléfono no fue actualizado correctamente");
    }

    @Test
    void pruebaEquals() {
        Usuario u1 = new Usuario("001122");
        Usuario u2 = new Usuario("001122");
        Usuario u3 = new Usuario("003344");

        assertEquals(usuario, u1, "Dos usuarios con el mismo número de credencial deberían ser iguales");
        assertEquals(usuario, u2, "Dos usuarios con el mismo número de credencial deberían ser iguales");
        assertNotEquals(usuario, u3, "Dos usuarios con diferentes números de credencial no deberían ser iguales");
    }

    @Test
    void pruebaHashCode() {
        Usuario u1 = new Usuario("001122");
        assertEquals(usuario.hashCode(), u1.hashCode(), "Dos usuarios con el mismo número de credencial deberían tener el mismo código hash");
    }

    @Test
    void pruebaToString() {
        assertEquals("001122, Juan Pérez, Calle Falsa 123, 555-12345", usuario.toString(), "La representación en cadena no coincide con el formato esperado");
    }
}
