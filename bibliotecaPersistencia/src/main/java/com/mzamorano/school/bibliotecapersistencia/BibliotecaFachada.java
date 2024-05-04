package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.PublicacionED;
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

    public Revista agrezarRevista(Revista revista) throws ValidacionException {
        boolean ok = persistenciaRevistas.agregar(revista);
        if (ok) {
            return null;
        }
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

    public Usuario agrezarUsuario(Usuario usuario) throws ValidacionException {
        boolean ok = persistenciaUsuarios.agregar(usuario);
        if (ok) {
            return null;
        }
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

    public PublicacionED obtenerInventario(String isbn) {
        return persistenciaInventarios.obtener(isbn);
    }

    public PublicacionED inventariar(Revista revista) throws ValidacionException {
        return inventariar(revista, 1);
    }

    public PublicacionED inventariar(Revista revista, int cantidad) throws ValidacionException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
        }

        var existente = persistenciaInventarios.obtener(revista.getIsbn());
        // Si la revista ya existe, nuestra vida es fácil: podemos usar la
        // cantidad dada como existencia y disponibilidad.
        if (existente == null) {
            var inventario = new PublicacionED(revista, cantidad, cantidad);
            // Agregar primero a la persistencia de inventarios para ver si hay
            // algún error de validación.
            persistenciaInventarios.agregar(inventario);
            // Si no hay ningún error de validación, podemos añadir la revista
            // al repositorio de revistas si no está ahí ya.
            agrezarRevista(revista);
            return inventario;
        }

        // Creamos un nuevo inventario con las nuevas copias que hay.
        var inventario = new PublicacionED(
                revista,
                existente.getExistencia() + cantidad,
                existente.getDisponibilidad() + cantidad
        );

        // Igual que antes: primero revisamos si hay algún error de validación,
        // y si no, podemos agregarla al repositorio de revistas si no está.
        persistenciaInventarios.actualizar(inventario);
        agrezarRevista(revista);

        return inventario;
    }

    public void desinventariar(Revista revista) throws ValidacionException {
        desinventariar(revista, 1);
    }

    public void desinventariar(Revista revista, int cantidad) throws ValidacionException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor que 0");
        }
        var existente = persistenciaInventarios.obtener(revista.getIsbn());
        if (existente == null) {
            // TODO: algo mejor - esto es temporal
            throw new IllegalArgumentException("No se puede desinventariar una revista sin inventario");
        }

        var inventario = new PublicacionED(
                revista,
                existente.getExistencia() - cantidad,
                existente.getDisponibilidad() - cantidad
        );
        persistenciaInventarios.actualizar(inventario);
        agrezarRevista(revista);
    }
}
