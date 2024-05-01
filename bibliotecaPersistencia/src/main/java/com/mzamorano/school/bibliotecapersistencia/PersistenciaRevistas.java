package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersistenciaRevistas implements IPersistenciaRevistas {
    private final HashMap<String, Revista> revistas = new HashMap<>();

    public List<Revista> buscar() {
        return new ArrayList<>(revistas.values());
    }

    @Override
    public List<Revista> buscar(Validador<Revista> filtros) {
        return revistas.values().stream()
                .filter(filtros::validar)
                .toList();
    }

    @Override
    public boolean agregar(Revista revista) {
        if (revista == null) {
            throw new IllegalArgumentException("Valores null no permitidos");
        }
        return revistas.putIfAbsent(revista.getIsbn(), revista) == null;
    }

    @Override
    public Revista obtener(String isbn) {
        return revistas.get(isbn);
    }

    @Override
    public boolean actualizar(Revista revista) {
        if (revista == null) {
            throw new IllegalArgumentException("Valores null no permitidos");
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
