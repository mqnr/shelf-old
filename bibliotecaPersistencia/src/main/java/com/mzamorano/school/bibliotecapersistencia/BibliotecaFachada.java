package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

public class BibliotecaFachada {
    private final IPersistenciaInventarios persistenciaInventarios;
    private final IPersistenciaPrestamos persistenciaPrestamos;
    private final IPersistenciaRevistas persistenciaRevistas;
    private final IPersistenciaUsuarios persistenciaUsuarios;

    public BibliotecaFachada(IPersistenciaInventarios persistenciaInventarios, IPersistenciaPrestamos persistenciaPrestamos, IPersistenciaRevistas persistenciaRevistas, IPersistenciaUsuarios persistenciaUsuarios) {
        this.persistenciaInventarios = persistenciaInventarios;
        this.persistenciaPrestamos = persistenciaPrestamos;
        this.persistenciaRevistas = persistenciaRevistas;
        this.persistenciaUsuarios = persistenciaUsuarios;
    }

    public boolean agregarRevista(Revista revista) {
        return persistenciaRevistas.agregar(revista);
    }

    public boolean actualizarRevista(Revista revista) {
        return persistenciaRevistas.actualizar(revista);
    }

    public boolean eliminarRevista(String isbn) {
        return persistenciaRevistas.eliminar(isbn);
    }

    public boolean eliminarRevista(Revista revista) {
        return persistenciaRevistas.eliminar(revista);
    }
}
