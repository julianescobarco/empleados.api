package co.empleados.api.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class MayorEdadRestriccionValidator implements ConstraintValidator<MayorEdadRestriccion, Date> {
    /**
     * Valida que la fecha de nacimiento sea mayor a 18 años.
     *
     * @param date    Fecha de nacimiento.
     * @param context Contexto de la validación.
     * @return True si la fecha de nacimiento es mayor a 18 años, false de lo contrario.
     */
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(birthdate, now) >= 18;
    }
}
