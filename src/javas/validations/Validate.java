package javas.validations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validate {
    String fieldName = "";
    String fieldName() default fieldName;
}
