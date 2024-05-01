package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

public interface IPersistenciaRevistas {
    void agregar(Revista revista);
    Revista obtenerPorIsbn(String isbn);
    void actualizar(Revista revista);
    void eliminar(Revista revista);
    void eliminarPorIsbn(String isbn);
}
