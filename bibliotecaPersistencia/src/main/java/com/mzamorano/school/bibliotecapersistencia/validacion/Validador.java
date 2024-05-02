package com.mzamorano.school.bibliotecapersistencia.validacion;

public interface Validador<T> {
    ResultadoValidacion validar(T t);
}
