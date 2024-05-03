package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ResultadoValidacion;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Usuario;

public class ValidadorUsuario implements Validador<Usuario> {
    @Override
    public ResultadoValidacion validar(Usuario usuario) {
        var resultado = new ResultadoValidacion();
        if (usuario == null) {
            resultado.agregarError("Valores null no permitidos");
            return resultado;
        }
        validarNombre(usuario, resultado);
        validarDireccion(usuario, resultado);
        validarTelefono(usuario, resultado);
        return resultado;
    }

    private void validarNombre(Usuario usuario, ResultadoValidacion resultado) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            resultado.agregarError("El nombre del usuario no puede estar vacio");
            return;
        }
        if (usuario.getNombre().length() < 5) {
            resultado.agregarError("El nombre del usuario debe tener al menos 5 caracteres");
        }
    }

    private void validarDireccion(Usuario usuario, ResultadoValidacion resultado) {
        // De acuerdo a nuestra lógica de negocio, no proporcionar una
        // dirección está completamente bien; sin embargo, si una es
        // proporcionada, debe tener al menos 10 caracteres.
        if (usuario.getDireccion() != null && usuario.getDireccion().length() < 10) {
            resultado.agregarError("Si es proporcionada, la dirección del usuario debe tener al menos 10 caracteres");
        }
    }

    private void validarTelefono(Usuario usuario, ResultadoValidacion resultado) {
        if (usuario.getTelefono() == null || usuario.getTelefono().isEmpty()) {
            resultado.agregarError("Un usuario debe tener un número de teléfono");
            return;
        }
        if (usuario.getTelefono().length() < 8) {
            resultado.agregarError("El número de teléfono debe tener al menos 8 caracteres");
        }
    }
}
