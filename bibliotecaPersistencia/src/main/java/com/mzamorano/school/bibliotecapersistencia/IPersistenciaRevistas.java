package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

public interface IPersistenciaRevistas {
    void agregarRevista(Revista revista);
    Revista obtenerRevistaPorIsbn(String isbn);
    void actualizarRevista(Revista revista);
    void eliminarRevista(Revista revista);
    void eliminarRevistaPorIsbn(String isbn);
}
