package com.mzamorano.school.bibliotecapersistencia.validacion;

import java.util.ArrayList;
import java.util.List;

public class ResultadoValidacion {
    private final List<String> errores = new ArrayList<>();

    public void agregarError(String s) {
        errores.add(s);
    }

    public boolean hayErrores() {
        return !errores.isEmpty();
    }

    public void arrojarErrores() throws ValidacionException {
        if (hayErrores()) {
            throw new ValidacionException(errores);
        }
    }

    public List<String> getErrores() {
        return errores;
    }
}
