package com.mzamorano.school.objetosservicio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Una {@code Fecha} es una abstracción sobre un {@code GregorianCalendar},
 * que provee algunos métodos útiles para que trabajar con fechas sea más intuitivo.
 *
 * <p>{@code Fecha} provee una visión diferente sobre el tiempo a la normalmente presentada por la
 * librería estándar de Java. En concreto, la API de {@code Fecha} espera y devuelve meses indexados a partir del uno.
 * Por ejemplo, si {@code getMes()} devuelve 3, debe ser interpretado como el mes de marzo.
 *
 * <p>Tener esto en mente es de suma importancia. Hay que tener cuidado con la distinción entre los métodos
 * de {@code Fecha} y los métodos de las clases de las que hereda, puesto que estos tendrán una visión incompatible
 * sobre el tiempo. En el ejemplo anterior, {@code get(Calendar.MONTH)} devolvería 2 (representando el mes de marzo),
 * como es convencional en Java.
 */
public class Fecha extends GregorianCalendar {
    /**
     * Construye una {@code Fecha} usando el constructor por defecto de {@link GregorianCalendar}.
     */
    public Fecha() {
        super();
    }

    /**
     * Construye una {@code Fecha} con el día, mes y año dados.
     *
     * @param dia el día del mes (1-31) dependiendo del mes y el año.
     * @param mes el mes del año (1-12), donde 1 es enero y 12 es diciembre.
     * @param anho el año, representando el año completo (por ejemplo, 2024 y no 24).
     */
    public Fecha(int dia, int mes, int anho) {
        super(anho, mes - 1, dia);
        // Si alguno cambió, no fue una fecha válida
        if (get(Calendar.YEAR) != anho || get(Calendar.MONTH) != mes - 1 || get(Calendar.DAY_OF_MONTH) != dia) {
            throw new IllegalArgumentException("Fecha inválida: " + dia + "/" + mes + "/" + anho);
        }
    }

    /**
     * Construye una {@code Fecha} copiando el día, mes, y año de una instancia existente.
     *
     * @param fecha la {@code Fecha} a copiar.
     */
    public Fecha(Fecha fecha) {
        super();
        setDia(fecha.getDia());
        setMes(fecha.getMes());
        setAnho(fecha.getAnho());
    }

    /**
     * Construye una {@code Fecha} copiando el día, mes, y año de una instancia existente.
     *
     * @param fecha el objeto {@code Date} que se utiliza para establecer el tiempo de esta instancia.
     */
    public Fecha(Date fecha) {
        super();
        setTime(fecha);
    }

    /**
     * Construye una {@code Fecha} a partir de una cadena de texto que representa una fecha.
     * La cadena debe estar en el formato "dd/mm/aaaa" (por ejemplo, "31/01/2024").
     *
     * @param s la cadena de texto que representa la fecha en el formato "dd/mm/aaaa".
     * @throws IllegalArgumentException si la cadena no está en el formato esperado o si representa una fecha inválida.
     */
    public Fecha(String s) throws IllegalArgumentException {
        super();
        String[] partes = s.split("/");
        if (partes.length != 3) {
            throw new IllegalArgumentException(
                    "Cadena de fecha proporcionada \"" + s + "\" no está en el formato dd/mm/aaaa");
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anho = Integer.parseInt(partes[2]);

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes inválido: " + mes);
        }
        set(anho, mes - 1, dia); // Usaremos un "truco" para verificar si el día fue válido
        if (get(Calendar.MONTH) != mes - 1) { // Si se dio la vuelta al siguiente mes, el día fue inválid
            throw new IllegalArgumentException("Día inválido: " + dia);
        }
    }


    /**
     * Devuelve el día del mes de esta instancia de {@code Fecha}.
     *
     * @return el día del mes representado por esta instancia.
     */
    public int getDia() {
        return get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Establece el día del mes para esta instancia de {@code Fecha}.
     *
     * @param dia el nuevo día del mes a establecer (1-31, dependiendo del mes y año).
     */
    public void setDia(int dia) {
        set(Calendar.DAY_OF_MONTH, dia);
    }

    /**
     * Devuelve el mes de esta instancia de {@code Fecha}, ajustado a un índice basado en 1.
     *
     * @return el mes del año representado por esta instancia, donde 1 es enero y 12 es diciembre.
     */
    public int getMes() {
        return get(Calendar.MONTH) + 1;
    }

    /**
     * Establece el mes para esta instancia de {@code Fecha}, esperando un índice basado en 1.
     *
     * @param mes el nuevo mes a establecer (1-12, donde 1 es enero y 12 es diciembre).
     */
    public void setMes(int mes) {
        set(Calendar.MONTH, mes - 1);
    }


    /**
     * Devuelve el año de esta instancia de {@code Fecha}.
     *
     * @return el año representado por esta instancia.
     */
    public int getAnho() {
        return get(Calendar.YEAR);
    }

    /**
     * Establece el año de esta instancia de {@code Fecha}.
     *
     * @param anho el nuevo año a establecer, representando el año completo (por ejemplo, 2024 y no 24).
     */
    public void setAnho(int anho) {
        set(Calendar.YEAR, anho);
    }

    /**
     * Establece la fecha de esta instancia de {@code Fecha} usando los valores especificados para el día, mes y año.
     * Antes de establecer la nueva fecha, limpia la configuración actual de tiempo de esta instancia.
     *
     * @param dia el día del mes (1-31) dependiendo del mes y el año.
     * @param mes el mes del año (1-12), donde 1 es enero y 12 es diciembre.
     * @param anho el año, representando el año completo (por ejemplo, 2024 y no 24).
     */
    public void setFecha(int dia, int mes, int anho) {
        clear();
        set(anho, mes - 1, dia);
    }

    /**
     * Establece la fecha de esta instancia de {@code Fecha} al valor especificado.
     *
     * @param fecha el objeto {@code Date} que representa la nueva fecha a ser establecida para esta instancia.
     * @see #setFecha(int, int, int)
     */
    public void setFecha(Date fecha) {
        setTime(fecha);
    }

    /**
     * Calcula una fecha en el futuro a partir de esta instancia de {@code Fecha}, agregando
     * una cantidad específica de días, meses y años.
     *
     * @param dias la cantidad de días a agregar.
     * @param meses la cantidad de meses a agregar.
     * @param anhos la cantidad de años a agregar.
     * @return una nueva instancia de {@code Fecha} que representa una fecha en el futuro.
     * @see #vencimiento(int)
     * @see #vencimiento(int, int)
     */
    public Fecha vencimiento(int dias, int meses, int anhos) {
        var fecha = new Fecha(this);

        fecha.add(Calendar.DAY_OF_MONTH, dias);
        fecha.add(Calendar.MONTH, meses);
        fecha.add(Calendar.YEAR, anhos);

        return fecha;
    }

    /**
     * Calcula una fecha en el futuro a partir de esta instancia de {@code Fecha}, agregando
     * una cantidad específica de días y meses.
     *
     * @param dias la cantidad de días a agregar.
     * @param meses la cantidad de meses a agregar.
     * @return una nueva instancia de {@code Fecha} que representa una fecha en el futuro.
     * @see #vencimiento(int)
     * @see #vencimiento(int, int, int)
     */
    public Fecha vencimiento(int dias, int meses) {
        var fecha = new Fecha(this);

        fecha.add(Calendar.DAY_OF_MONTH, dias);
        fecha.add(Calendar.MONTH, meses);

        return fecha;
    }

    /**
     * Calcula una fecha en el futuro a partir de esta instancia de {@code Fecha}, agregando
     * una cantidad específica de días.
     *
     * @param dias la cantidad de días a agregar.
     * @return una nueva instancia de {@code Fecha} que representa una fecha en el futuro.
     * @see #vencimiento(int, int)
     * @see #vencimiento(int, int, int)
     */
    public Fecha vencimiento(int dias) {
        var fecha = new Fecha(this);
        fecha.add(Calendar.DAY_OF_MONTH, dias);
        return fecha;
    }

    /**
     * Calcula el número de días de diferencia entre esta instancia de {@code Fecha} y otra fecha proporcionada.
     * Este método ignora el componente de tiempo de ambas fechas, enfocándose únicamente en la diferencia de días.
     *
     * @param desde la instancia de {@code Fecha} desde la cual se calcula el lapso de días hasta esta instancia.
     *              Debe representar una fecha anterior a esta para obtener un resultado positivo.
     * @return el número de días como un entero que han pasado desde la fecha proporcionada ({@code desde})
     *         hasta esta instancia de fecha. Si {@code desde} es después de esta fecha, el resultado será negativo.
     */
    public int lapso(Fecha desde) {
        LocalDate fechaDesde = desde.toZonedDateTime().toLocalDate();
        LocalDate estaFecha = this.toZonedDateTime().toLocalDate();

        return (int) ChronoUnit.DAYS.between(fechaDesde, estaFecha);
    }

    /**
     * Devuelve una representación en cadena de esta fecha, utilizando lenguaje natural en español,
     * por ejemplo, "21 de agosto de 2023".
     *
     * @return una cadena que representa la fecha de esta instancia con el formato "día de mes de año",
     *         utilizando nombres de meses en español.
     */
    public String toDateString() {
        Month mes = Month.of(getMes());
        String nombreMes = mes.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es"));

        return getDia() + " de " + nombreMes + " de " + getAnho();
    }

    /**
     * Devuelve una representación en cadena de esta fecha.
     * El formato de la fecha devuelta es "dd/MM/aaaa".
     *
     * @return una cadena que representa la fecha de esta instancia en el formato día/mes/año.
     */
    @Override
    public String toString() {
        Date fecha = getTime();
        var formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fecha);
    }
}
