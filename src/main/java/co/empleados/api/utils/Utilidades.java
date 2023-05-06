package co.empleados.api.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

final public class Utilidades {
    /**
     * Función para crear una cadena que diga la cantidad de años, meses y días que han pasado a partir de una fecha dada.
     *
     * @param fecha Fecha a partir de la cual se calculará la cantidad de años, meses y días.
     * @return Cadena con la cantidad de años, meses y días que han pasado a partir de la fecha dada.
     */
    public static String calcularTiempoTranscurrido(Date fecha) {
        if (fecha == null) {
            return "";
        }
        LocalDate nacimiento = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(nacimiento, hoy);

        int years = periodo.getYears();
        int months = periodo.getMonths();
        int days = periodo.getDays();

        return String.format("%d años, %d meses y %d días", years, months, days);
    }
}
