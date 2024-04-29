package com.mzamorano.school.objetosservicio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FechaTest {
    @Test
    void testConstruccionFechaConParametros() {
        Fecha fecha = new Fecha(15, 2, 2024); // 15 de Febrero de 2024
        assertEquals(15, fecha.getDia(), "El día debe ser 15.");
        assertEquals(2, fecha.getMes(), "El mes debe ser 2 (Febrero).");
        assertEquals(2024, fecha.getAnho(), "El año debe ser 2024.");
    }

    @Test
    void testFechaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fecha(32, 1, 2021); // Fecha inválida: 29 de febrero de 2021 no es año bisiesto
        }, "Debería lanzar una excepción para el 29 de febrero en un año no bisiesto.");
    }

    @Test
    void testFechaFebreroInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fecha(29, 2, 2021); // Fecha inválida: 29 de febrero de 2021 no es año bisiesto
        }, "Debería lanzar una excepción para el 29 de febrero en un año no bisiesto.");
    }

    @Test
    void testFechaMinimaValida() {
        Fecha fecha = new Fecha(1, 1, 1);
        assertEquals(1, fecha.getDia());
        assertEquals(1, fecha.getMes());
        assertEquals(1, fecha.getAnho(), "Debería manejar la fecha mínima válida del calendario gregoriano.");
    }

    @Test
    void testConfiguracionFechaMaxima() {
        Fecha fecha = new Fecha(31, 12, 9999);
        assertEquals(31, fecha.getDia());
        assertEquals(12, fecha.getMes());
        assertEquals(9999, fecha.getAnho(), "Debería manejar la fecha máxima válida en el calendario gregoriano.");
    }

    @Test
    void testFormatoFechaInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Fecha("31-12-2020"); // Formato inválido usando guiones en lugar de barras
        }, "Debería lanzar una excepción por el formato de fecha incorrecto.");
    }

    @Test
    void testAjusteFecha() {
        Fecha fecha = new Fecha(1, 1, 2020); // 1 de Enero de 2020
        fecha.setDia(31);
        fecha.setMes(12); // Cambiar a 31 de Diciembre de 2020
        fecha.setAnho(2021); // Cambiar año a 2021
        assertEquals("31/12/2021", fecha.toString(), "La fecha ajustada debe ser 31/12/2021.");
    }

    @Test
    void testTransicionFinDeMes() {
        Fecha fecha = new Fecha(31, 1, 2020);
        fecha.setMes(2); // Attempting to set to February 2020, which has 29 days
        // Check for the actual rollover date, which would be March 2 in 2020
        assertEquals(2, fecha.getDia(), "Debería ajustarse al 2 de marzo de 2020, debido al desbordamiento.");
        assertEquals(3, fecha.getMes(), "Debería ser marzo después del desbordamiento.");
        assertEquals(2020, fecha.getAnho(), "El año debería seguir siendo 2020.");
    }

    @Test
    void testTransicionDeAno() {
        Fecha fecha = new Fecha(31, 12, 2020);
        Fecha nuevaFecha = fecha.vencimiento(1); // Añadir un día para pasar al siguiente año
        assertEquals(1, nuevaFecha.getDia(), "El día de la nueva fecha debería ser 1.");
        assertEquals(1, nuevaFecha.getMes(), "El mes de la nueva fecha debería ser 1 (enero).");
        assertEquals(2021, nuevaFecha.getAnho(), "El mes de la nueva fecha debería ser 2021.");
    }

    @Test
    void testVencimientoDias() {
        Fecha fechaInicio = new Fecha(1, 1, 2020); // 1 de Enero de 2020
        Fecha fechaVencimiento = fechaInicio.vencimiento(30); // Agregar 30 días
        Fecha fechaEsperada = new Fecha(31, 1, 2020); // 31 de Enero de 2020
        assertEquals(fechaEsperada.getDia(), fechaVencimiento.getDia());
        assertEquals(fechaEsperada.getMes(), fechaVencimiento.getMes());
        assertEquals(fechaEsperada.getAnho(), fechaVencimiento.getAnho());
    }

    @Test
    void testVencimientoDiasMesesAnhos() {
        Fecha fechaInicio = new Fecha(1, 1, 2020); // 1 de Enero de 2020
        Fecha fechaVencimiento = fechaInicio.vencimiento(10, 1, 1); // Agregar 10 días, 1 mes y 1 año
        Fecha fechaEsperada = new Fecha(11, 2, 2021); // 11 de Febrero de 2021
        assertEquals(fechaEsperada.getDia(), fechaVencimiento.getDia());
        assertEquals(fechaEsperada.getMes(), fechaVencimiento.getMes());
        assertEquals(fechaEsperada.getAnho(), fechaVencimiento.getAnho());
    }

    @Test
    void testLapsoDias() {
        Fecha fechaInicio = new Fecha(1, 1, 2020);
        Fecha fechaFin = new Fecha(2, 1, 2020);
        int lapso = fechaFin.lapso(fechaInicio);
        assertEquals(1, lapso, "El lapso debe ser de 1 día.");
    }

    @Test
    void testRepresentacionCadena() {
        Fecha fecha = new Fecha(21, 8, 2023); // 21 de Agosto de 2023
        String representacionEsperada = "21 de agosto de 2023";
        assertEquals(representacionEsperada, fecha.toDateString(), "La representación en cadena debe coincidir.");
    }
}
