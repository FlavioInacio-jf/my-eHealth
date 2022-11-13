package javas.validations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumericOnly {
    String MESAGE = "Este campo só deve conter números";
    String message() default MESAGE;
}
