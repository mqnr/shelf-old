package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.Revista;

import java.util.List;

public interface IPersistenciaRevistas {
    boolean agregar(Revista revista) throws ValidacionException;
    List<Revista> buscar();
    List<Revista> buscar(Predicado<Revista> filtros);
    Revista obtener(String isbn);
    boolean actualizar(Revista revista) throws ValidacionException;
    boolean eliminar(String isbn);
    boolean eliminar(Revista revista);
}
