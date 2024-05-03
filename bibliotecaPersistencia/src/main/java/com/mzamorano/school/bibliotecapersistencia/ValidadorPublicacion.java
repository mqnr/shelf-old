package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.bibliotecapersistencia.validacion.ResultadoValidacion;
import com.mzamorano.school.bibliotecapersistencia.validacion.Validador;
import com.mzamorano.school.objetosnegocio.Publicacion;
import com.mzamorano.school.objetosnegocio.Revista;
import com.mzamorano.school.objetosservicio.Fecha;

import java.time.Year;
import java.util.List;

public class ValidadorPublicacion implements Validador<Publicacion> {
    private static final List<String> PERIODICIDADES_VALIDAS = List.of("diaria", "semanal", "quincenal", "mensual");
    private static final List<String> CLASIFICACIONES_VALIDAS = List.of("ciencia", "tecnología", "computación", "arquitectura");

    @Override
    public ResultadoValidacion validar(Publicacion publicacion) {
        var resultado = new ResultadoValidacion();
        if (publicacion == null) {
            resultado.agregarError("Valores null no permitidos");
            return resultado;
        }

        validarIsbn(publicacion, resultado);
        validarTitulo(publicacion, resultado);
        validarClasificacion(publicacion, resultado);

        if (publicacion instanceof Revista) {
            validarFecha((Revista)publicacion, resultado);
            validarPeriodicidad((Revista)publicacion, resultado);
        }

        return resultado;
    }

    private void validarIsbn(Publicacion publicacion, ResultadoValidacion resultado) {
        if (publicacion.getIsbn() == null || publicacion.getIsbn().isEmpty()) {
            resultado.agregarError("El ISBN no debe estar vacío");
            return;
        }
        if (publicacion.getIsbn().length() < 10) {
            resultado.agregarError("El ISBN debe contener al menos 10 caracteres");
        }
    }

    private void validarTitulo(Publicacion publicacion, ResultadoValidacion resultado) {
        if (publicacion.getTitulo() == null || publicacion.getTitulo().isEmpty()) {
            resultado.agregarError("El título de la revista no debe estar vacío");
        }
    }

    private void validarClasificacion(Publicacion publicacion, ResultadoValidacion resultado) {
        if (!CLASIFICACIONES_VALIDAS.contains(publicacion.getClasificacion().toLowerCase())) {
            resultado.agregarError("La clasificación " + publicacion.getClasificacion() + " no es de las clasificaciones válidas");
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
}