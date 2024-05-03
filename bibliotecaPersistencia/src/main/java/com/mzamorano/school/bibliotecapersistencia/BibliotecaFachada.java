package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.Revista;
import com.mzamorano.school.objetosnegocio.Usuario;

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

    public Revista obtenerRevista(String isbn) {
        return persistenciaRevistas.obtener(isbn);
    }

    public boolean agregarRevista(Revista revista) throws ValidacionException {
        return persistenciaRevistas.agregar(revista);
    }

    public Revista actualizarRevista(Revista revista) throws ValidacionException {
        return persistenciaRevistas.actualizar(revista);
    }

    public boolean eliminarRevista(String isbn) {
        return persistenciaRevistas.eliminar(isbn);
    }

    public List<Revista> buscarRevistas() {
        return persistenciaRevistas.buscar();
    }

    public List<Revista> buscarRevistas(Predicado<Revista> filtros) {
        return persistenciaRevistas.buscar(filtros);
    }

    public Usuario obtenerUsuario(String numeroCredencial) {
        return persistenciaUsuarios.obtener(numeroCredencial);
    }

    public boolean agregarUsuario(Usuario usuario) throws ValidacionException {
        return persistenciaUsuarios.agregar(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario) throws ValidacionException {
        return persistenciaUsuarios.actualizar(usuario);
    }

    public boolean eliminarUsuario(String numeroCredencial) {
        return persistenciaRevistas.eliminar(numeroCredencial);
    }

    public List<Usuario> buscarUsuarios() {
        return persistenciaUsuarios.buscar();
    }

    public List<Usuario> buscarUsuarios(Predicado<Usuario> filtros) {
        return persistenciaUsuarios.buscar(filtros);
    }
}
