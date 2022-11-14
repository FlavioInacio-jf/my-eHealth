package javas.validations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface NotEmpty {
    String MESAGE = "Este campo não deve estar vazio";
    String message() default MESAGE;
    String regexp() default "";
}
