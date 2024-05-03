package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.Revista;

import java.util.List;

public interface IPersistenciaRevistas {
    Revista obtener(String isbn);
    boolean agregar(Revista revista) throws ValidacionException;
    boolean actualizar(Revista revista) throws ValidacionException;
    boolean eliminar(String isbn);
    List<Revista> buscar();
    List<Revista> buscar(Predicado<Revista> filtros);
}
