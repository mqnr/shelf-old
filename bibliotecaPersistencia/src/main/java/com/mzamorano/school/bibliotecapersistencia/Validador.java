package com.mzamorano.school.bibliotecapersistencia;

public interface Validador<T> {
    boolean validar(T item);
}
