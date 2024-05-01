package com.mzamorano.school.bibliotecapersistencia;

import com.mzamorano.school.objetosnegocio.Revista;

public class FiltrosRevista implements Validador<Revista> {
    private String editorialEspecificada;
    private String clasificacionEspecificada;

    public FiltrosRevista conEditorial(String editorial) {
        editorialEspecificada = editorial;
        return this;
    }

    public FiltrosRevista conClasificacion(String clasificacion) {
        clasificacionEspecificada = clasificacion;
        return this;
    }

    @Override
    public boolean validar(Revista revista) {
        // Si el filtro de editorial fue especificado y la revista no lo cumple, devolver False
        if (editorialEspecificada != null && !revista.getEditorial().equalsIgnoreCase(editorialEspecificada)) {
            return false;
        }
        // Ahora que ya verificamos que cumple el filtro de editorial:
        // si el filtro de clasificación no fue especificado, o la revista lo cumple, devolver True
        return clasificacionEspecificada == null || revista.getClasificacion().equalsIgnoreCase(clasificacionEspecificada);
    }
}
