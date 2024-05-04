package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.PublicacionED;

import java.util.List;

public interface IPersistenciaInventarios {
    PublicacionED obtener(String isbn);
    boolean agregar(PublicacionED inventario) throws ValidacionException;
    PublicacionED actualizar(PublicacionED inventario) throws ValidacionException;
    boolean eliminar(String isbn);
    List<PublicacionED> buscar();
    List<PublicacionED> buscar(Predicado<PublicacionED> filtros);
}
