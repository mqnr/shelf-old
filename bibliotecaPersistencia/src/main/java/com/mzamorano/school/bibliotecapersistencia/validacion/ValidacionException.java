package com.mzamorano.school.bibliotecapersistencia.validacion;

import java.util.List;

public class ValidacionException extends Exception {
    private final List<String> errores;

    public ValidacionException(List<String> errores) {
        super("La validación falló con uno o más errores: " + String.join(", ", errores));
        this.errores = errores;
    }

    public List<String> getErrores() {
        return errores;
    }
}