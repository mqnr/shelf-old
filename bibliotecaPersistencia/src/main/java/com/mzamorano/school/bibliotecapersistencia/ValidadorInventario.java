package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ResultadoValidacion;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Publicacion;
import com.mzamorano.school.objetosnegocio.PublicacionED;

public class ValidadorInventario implements Validador<PublicacionED> {
    private static final Validador<Publicacion> validadorPublicacion = new ValidadorPublicacion();
    private static final int LIMITE_EXISTENCIA = 10;

    @Override
    public ResultadoValidacion validar(PublicacionED inventario) {
        var resultado = new ResultadoValidacion();
        if (inventario == null) {
            resultado.agregarError("Valores null no permitidos");
            return resultado;
        }

        validadorPublicacion.validar(inventario.getPublicacion())
                .getErrores()
                .forEach(resultado::agregarError);

        validarExistencia(inventario, resultado);
        validarDisponibilidad(inventario, resultado);
        return resultado;
    }

    private void validarExistencia(PublicacionED inventario, ResultadoValidacion resultado) {
        if (inventario.getExistencia() < 0) {
            resultado.agregarError("La existencia no puede ser menor a 0");
        }
        if (inventario.getExistencia() > LIMITE_EXISTENCIA) {
            resultado.agregarError("La existencia excede el límite de " + LIMITE_EXISTENCIA);
        }
    }

    private void validarDisponibilidad(PublicacionED inventario, ResultadoValidacion resultado) {
        if (inventario.getDisponibilidad() < 0) {
            resultado.agregarError("La disponibilidad no puede ser menor a 0");
        }
        if (inventario.getDisponibilidad() < inventario.getExistencia()) {
            resultado.agregarError("La disponibilidad debe ser menor que la existencia");
        }
    }
}
