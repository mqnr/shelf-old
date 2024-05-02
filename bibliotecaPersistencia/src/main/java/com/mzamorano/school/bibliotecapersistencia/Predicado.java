package com.mzamorano.school.bibliotecapersistencia;

public interface Predicado<T> {
    boolean satisface(T item);
}
