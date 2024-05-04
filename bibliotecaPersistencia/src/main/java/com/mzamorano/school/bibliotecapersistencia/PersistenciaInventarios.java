package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.PublicacionED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenciaInventarios implements IPersistenciaInventarios {
    private final static Validador<PublicacionED> validador = new ValidadorInventario();
    private final Map<String, PublicacionED> inventarios = new HashMap<>();

    @Override
    public PublicacionED obtener(String isbn) {
        return inventarios.get(isbn);
    }

    @Override
    public boolean agregar(PublicacionED inventario) throws ValidacionException {
        if (inventario == null) {
            throw new NullPointerException("Valores null no permitidos");
        }
        validador.validar(inventario).arrojarErrores();
        return inventarios.putIfAbsent(
                inventario.getPublicacion().getIsbn(),
                inventario
        ) == null;
    }

    @Override
    public PublicacionED actualizar(PublicacionED inventario) throws ValidacionException {
        if (inventario == null) {
            throw new NullPointerException("Valores null no permitidos");
        }
        validador.validar(inventario).arrojarErrores();
        return inventarios.replace(
                inventario.getPublicacion().getIsbn(),
                inventario
        );
    }

    @Override
    public boolean eliminar(String isbn) {
        return inventarios.remove(isbn) != null;
    }

    @Override
    public List<PublicacionED> buscar() {
        return new ArrayList<>(inventarios.values());
    }

    @Override
    public List<PublicacionED> buscar(Predicado<PublicacionED> filtros) {
        return inventarios.values().stream()
                .filter(filtros::satisface)
                .toList();
    }
}
