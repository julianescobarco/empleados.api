package co.empleados.api.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MayorEdadRestriccionValidator.class)
public @interface MayorEdadRestriccion {
    String message() default "El empleado debe tener al menos 18 años";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
