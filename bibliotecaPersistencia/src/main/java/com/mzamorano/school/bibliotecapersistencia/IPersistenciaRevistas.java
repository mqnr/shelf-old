package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

public interface IPersistenciaRevistas {
    boolean agregar(Revista revista);
    Revista obtener(String isbn);
    boolean actualizar(Revista revista);
    boolean eliminar(String isbn);
    boolean eliminar(Revista revista);
}
