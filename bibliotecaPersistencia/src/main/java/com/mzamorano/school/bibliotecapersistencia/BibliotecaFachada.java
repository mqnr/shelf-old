package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

import java.util.List;

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

    public List<Revista> buscarRevistas() {
        return persistenciaRevistas.buscar();
    }

    public List<Revista> buscarRevistas(Validador<Revista> filtros) {
        return persistenciaRevistas.buscar(filtros);
    }

    public boolean agregarRevista(Revista revista) {
        return persistenciaRevistas.agregar(revista);
    }

    public Revista obtenerRevista(String isbn) {
        return persistenciaRevistas.obtener(isbn);
    }

    public boolean eliminarRevista(String isbn) {
        return persistenciaRevistas.eliminar(isbn);
    }
}
