package javas.validations;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
    String MESAGE = "Este campo não deve estar com valor null";
    String message() default MESAGE;
}
