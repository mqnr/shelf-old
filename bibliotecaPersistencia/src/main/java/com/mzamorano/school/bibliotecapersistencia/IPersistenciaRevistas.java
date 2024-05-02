package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

import java.util.List;

public interface IPersistenciaRevistas {
    boolean agregar(Revista revista);
    List<Revista> buscar();
    List<Revista> buscar(Predicado<Revista> filtros);
    Revista obtener(String isbn);
    boolean actualizar(Revista revista);
    boolean eliminar(String isbn);
    boolean eliminar(Revista revista);
}
