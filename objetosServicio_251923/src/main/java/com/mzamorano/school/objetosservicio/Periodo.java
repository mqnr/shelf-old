package com.mzamorano.school.objetosservicio;

/**
 * Representa un periodo de tiempo entre dos instancias de {@link Fecha}, incluyendo ambas fechas en el intervalo.
 */
public class Periodo {
    private Fecha desde;
    private Fecha hasta;

    /**
     * Construye un {@code Periodo} con las fechas de inicio y fin dadas.
     *
     * @param desde la fecha de inicio del periodo.
     * @param hasta la fecha de fin del periodo.
     */
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * Devuelve la fecha de inicio de este periodo.
     *
     * @return la fecha de inicio del periodo.
     */
    public Fecha getDesde() {
        return desde;
    }

    /**
     * Establece una nueva fecha de inicio para este periodo.
     *
     * @param desde la nueva fecha de inicio del periodo.
     */
    public void setDesde(Fecha desde) {
        this.desde = desde;
    }

    /**
     * Devuelve la fecha de fin de este periodo.
     *
     * @return la fecha de fin del periodo.
     */
    public Fecha getHasta() {
        return hasta;
    }

    /**
     * Establece una nueva fecha de fin para este periodo.
     *
     * @param hasta la nueva fecha de fin del periodo.
     */
    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }

    /**
     * Determina si una fecha específica está contenida dentro del periodo, incluyendo los límites.
     *
     * @param fecha la fecha a verificar.
     * @return {@code true} si la fecha está dentro del periodo (incluyendo las fechas de inicio y fin),
     *         {@code false} en caso contrario.
     */
    public boolean contiene(Fecha fecha) {
        if (fecha.equals(desde) || fecha.equals(hasta)) {
            return true;
        }
        return fecha.after(desde) && fecha.before(hasta);
    }

    /**
     * Devuelve una representación en cadena de este periodo, mostrando las fechas de inicio y fin.
     *
     * @return una cadena que representa el periodo, en el formato "desde a hasta".
     */
    @Override
    public String toString() {
        return desde + " a " + hasta;
    }
}
