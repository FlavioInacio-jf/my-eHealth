package javas.validations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsEnum {
    Class<? extends Enum<?>> enumClass();
    String[] values() default {};
    String MESAGE = "Valor informado é inválido";
    String message() default MESAGE;
}
