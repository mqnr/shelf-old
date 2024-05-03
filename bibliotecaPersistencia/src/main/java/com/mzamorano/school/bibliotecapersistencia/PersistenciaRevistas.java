package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Publicacion;
import com.mzamorano.school.objetosnegocio.Revista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersistenciaRevistas implements IPersistenciaRevistas {
    private static final Validador<Publicacion> validador = new ValidadorPublicacion();
    private final HashMap<String, Revista> revistas = new HashMap<>();

    @Override
    public Revista obtener(String isbn) {
        return revistas.get(isbn);
    }

    @Override
    public boolean agregar(Revista revista) throws ValidacionException {
        validador.validar(revista).arrojarErrores();
        return revistas.putIfAbsent(revista.getIsbn(), revista) == null;
    }

    @Override
    public Revista actualizar(Revista revista) throws ValidacionException {
        validador.validar(revista).arrojarErrores();
        return revistas.replace(revista.getIsbn(), revista);
    }

    @Override
    public boolean eliminar(String isbn) {
        return revistas.remove(isbn) != null;
    }

    @Override
    public List<Revista> buscar() {
        return new ArrayList<>(revistas.values());
    }

    @Override
    public List<Revista> buscar(Predicado<Revista> filtros) {
        return revistas.values().stream()
                .filter(filtros::satisface)
                .toList();
    }
}
