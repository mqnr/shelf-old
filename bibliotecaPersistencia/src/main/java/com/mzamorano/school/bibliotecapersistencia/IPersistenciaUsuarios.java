package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ValidacionException;
import com.mzamorano.school.objetosnegocio.Usuario;

import java.util.List;

public interface IPersistenciaUsuarios {
    Usuario obtener(String numeroCredencial);
    boolean agregar(Usuario usuario) throws ValidacionException;
    Usuario actualizar(Usuario revista) throws ValidacionException;
    boolean eliminar(String numeroCredencial);
    List<Usuario> buscar();
    List<Usuario> buscar(Predicado<Usuario> filtros);
}
