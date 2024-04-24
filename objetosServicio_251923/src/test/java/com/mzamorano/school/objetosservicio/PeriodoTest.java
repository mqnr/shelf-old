package com.mzamorano.school.objetosservicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeriodoTest {
    private Periodo periodo;
    private Fecha desde;
    private Fecha hasta;
    private Fecha dentro;
    private Fecha fuera;

    @BeforeEach
    void setUp() {
        desde = new Fecha(1, 1, 2020);
        hasta = new Fecha(31, 12, 2020);
        dentro = new Fecha(15, 6, 2020); // Una fecha dentro del período
        fuera = new Fecha(1, 1, 2021); // Una fecha fuera del período

        periodo = new Periodo(desde, hasta);
    }

    @Test
    void testConstruccionDePeriodoYGetters() {
        assertEquals(desde, periodo.getDesde(), "La fecha de inicio debe coincidir con el parámetro del constructor.");
        assertEquals(hasta, periodo.getHasta(), "La fecha de fin debe coincidir con el parámetro del constructor.");
    }

    @Test
    void testSetDesde() {
        Fecha nuevaFechaInicio = new Fecha(1, 1, 2019);
        periodo.setDesde(nuevaFechaInicio);
        assertEquals(nuevaFechaInicio, periodo.getDesde(), "La fecha de inicio debe actualizarse.");
    }

    @Test
    void testSetHasta() {
        Fecha nuevaFechaFin = new Fecha(31, 12, 2021);
        periodo.setHasta(nuevaFechaFin);
        assertEquals(nuevaFechaFin, periodo.getHasta(), "La fecha de fin debe actualizarse.");
    }

    @Test
    void testContiene() {
        assertTrue(periodo.contiene(desde), "El período debe contener su fecha de inicio.");
        assertTrue(periodo.contiene(hasta), "El período debe contener su fecha de fin.");
        assertTrue(periodo.contiene(dentro), "El período debe contener una fecha dentro de sus límites.");
        assertFalse(periodo.contiene(fuera), "El período no debe contener una fecha fuera de sus límites.");
    }

    @Test
    void testToString() {
        String esperado = desde + " a " + hasta;
        assertEquals(esperado, periodo.toString(), "La representación en cadena debe coincidir con el formato 'desde a hasta'.");
    }
}