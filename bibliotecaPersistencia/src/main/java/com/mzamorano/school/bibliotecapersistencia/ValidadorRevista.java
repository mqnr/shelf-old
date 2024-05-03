package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ResultadoValidacion;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Revista;
import com.mzamorano.school.objetosservicio.Fecha;

import java.time.Year;
import java.util.List;

public class ValidadorRevista implements Validador<Revista> {
    private static final List<String> PERIODICIDADES_VALIDAS = List.of("diaria", "semanal", "quincenal", "mensual");
    private static final List<String> CLASIFICACIONES_VALIDAS = List.of("ciencia", "tecnología", "computación", "arquitectura");

    @Override
    public ResultadoValidacion validar(Revista revista) {
        var resultado = new ResultadoValidacion();
        if (revista == null) {
            resultado.agregarError("Valores null no permitidos");
            return resultado;
        }
        validarTitulo(revista, resultado);
        validarIsbn(revista, resultado);
        validarFecha(revista, resultado);
        validarPeriodicidad(revista, resultado);
        validarClasificacion(revista, resultado);
        return resultado;
    }

    private void validarTitulo(Revista revista, ResultadoValidacion resultado) {
        if (revista.getTitulo() == null || revista.getTitulo().isEmpty()) {
            resultado.agregarError("El título de la revista no debe estar vacío");
        }
    }

    private void validarIsbn(Revista revista, ResultadoValidacion resultado) {
        if (revista.getIsbn() == null || revista.getIsbn().isEmpty()) {
            resultado.agregarError("El ISBN no debe estar vacío");
            return;
        }
        if (revista.getIsbn().length() < 10) {
            resultado.agregarError("El ISBN debe contener al menos 10 caracteres");
        }
    }

    private void validarFecha(Revista revista, ResultadoValidacion resultado) {
        Fecha ultimoDeAnho = new Fecha(31, 12, Year.now().getValue());
        if (revista.getFecha() == null || revista.getFecha().after(ultimoDeAnho)) {
            resultado.agregarError("La fecha no puede estar en un año futuro");
        }
    }

    private void validarPeriodicidad(Revista revista, ResultadoValidacion resultado) {
        if (!PERIODICIDADES_VALIDAS.contains(revista.getPeriodicidad().toLowerCase())) {
            resultado.agregarError("La periodicidad " + revista.getPeriodicidad() + " no es una de las periodicidades válidas");
        }
    }

    private void validarClasificacion(Revista revista, ResultadoValidacion resultado) {
        if (!CLASIFICACIONES_VALIDAS.contains(revista.getClasificacion().toLowerCase())) {
            resultado.agregarError("La clasificación " + revista.getClasificacion() + " no es de las clasificaciones válidas");
        }
    }
}
