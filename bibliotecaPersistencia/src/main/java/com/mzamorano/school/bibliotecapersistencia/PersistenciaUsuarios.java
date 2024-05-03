package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenciaUsuarios implements IPersistenciaUsuarios {
    private static final Validador<Usuario> validador = new ValidadorUsuario();
    private final Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public Usuario obtener(String numeroCredencial) {
        return usuarios.get(numeroCredencial);
    }

    @Override
    public boolean agregar(Usuario usuario) throws ValidacionException {
        validador.validar(usuario).arrojarErrores();
        return usuarios.putIfAbsent(usuario.getNumCredencial(), usuario) == null;
    }

    @Override
    public Usuario actualizar(Usuario usuario) throws ValidacionException {
        validador.validar(usuario).arrojarErrores();
        return usuarios.replace(usuario.getNumCredencial(), usuario);
    }

    @Override
    public boolean eliminar(String numeroCredencial) {
        return usuarios.remove(numeroCredencial) != null;
    }

    @Override
    public List<Usuario> buscar() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public List<Usuario> buscar(Predicado<Usuario> filtros) {
        return usuarios.values().stream()
                .filter(filtros::satisface)
                .toList();
    }
}
