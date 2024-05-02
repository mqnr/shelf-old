package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ResultadoValidacion;
import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Revista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersistenciaRevistas implements IPersistenciaRevistas {
    private static final Validador<Revista> validador = new ValidadorRevista();
    private final HashMap<String, Revista> revistas = new HashMap<>();

    public List<Revista> buscar() {
        return new ArrayList<>(revistas.values());
    }

    @Override
    public List<Revista> buscar(Predicado<Revista> filtros) {
        return revistas.values().stream()
                .filter(filtros::satisface)
                .toList();
    }

    @Override
    public boolean agregar(Revista revista) throws ValidacionException {
        ResultadoValidacion resultado = validador.validar(revista);
        if (resultado.hayErrores()) {
            throw new ValidacionException(resultado.getErrores());
        }
        return revistas.putIfAbsent(revista.getIsbn(), revista) == null;
    }

    @Override
    public Revista obtener(String isbn) {
        return revistas.get(isbn);
    }

    @Override
    public boolean actualizar(Revista revista) throws ValidacionException {
        ResultadoValidacion resultado = validador.validar(revista);
        if (resultado.hayErrores()) {
            throw new ValidacionException(resultado.getErrores());
        }
        return revistas.replace(revista.getIsbn(), revista) != null;
    }

    @Override
    public boolean eliminar(String isbn) {
        return revistas.remove(isbn) != null;
    }

    @Override
    public boolean eliminar(Revista revista) {
        return revistas.remove(revista.getIsbn()) != null;
    }
}
