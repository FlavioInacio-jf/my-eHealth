package javas.validations;

import javas.errors.CustomError;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class Validation {
    private final Object object;
    public Validation (Object object) {
        this.object = object;
    }
    public void validate() throws IllegalAccessException {
        Class<?> classe = this.object.getClass();
        for(Field field : classe.getDeclaredFields()) {
            if (field.isAnnotationPresent(Validate.class)) {
                field.setAccessible(true);
                String name = field.getAnnotation(Validate.class).fieldName();
                this.validateNotEmpty(field, name);
                this.validateNotNull(field, name);
                this.validateNumericOnly(field, name);
                this.validateIsEnum(field, name);
            }

        }
    }
    private String getFieldName (Field field) {
        return field.getName();
    }

    private void validateNotEmpty(Field field, String name) throws IllegalAccessException {
        if (field.isAnnotationPresent(NotEmpty.class)) {
            String message = field.getAnnotation(NotEmpty.class).message();
            if (field.get(this.object) == null || field.get(this.object).toString().trim().equals("")) {
                throw new CustomError(name.isEmpty() ? getFieldName(field) : name, message);
            }
        }
    }

    private void validateNotNull(Field field, String name) throws IllegalAccessException {
        if (field.isAnnotationPresent(NotNull.class)) {
            String message = field.getAnnotation(NotNull.class).message();
            if (field.get(this.object) == null) {
                throw new CustomError(name.isEmpty() ? getFieldName(field) : name, message);
            }
        }
    }

    private void validateNumericOnly(Field field, String name) throws IllegalAccessException {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (field.isAnnotationPresent(NumericOnly.class)) {
            String message = field.getAnnotation(NumericOnly.class).message();
            if (field.get(this.object) == null) {
                throw new CustomError(name.isEmpty() ? getFieldName(field) : name, message);
            }
            if (pattern.matcher((CharSequence) field.get(this.object)).matches()) {
                throw new CustomError(name.isEmpty() ? getFieldName(field) : name, message);
            }
        }
    }

    private boolean validateIsEnum(Field field, String name) throws IllegalAccessException {
        if (field.isAnnotationPresent(IsEnum.class)) {
            String message = field.getAnnotation(IsEnum.class).message();
            String [] validValues = field.getAnnotation(IsEnum.class).values();
            String value = field.get(this.object).toString();
            for (String validValue : validValues) {
                if (validValue.trim().equalsIgnoreCase(value.trim())) {
                    return true;
                }
            }
            throw new CustomError(name.isEmpty() ? getFieldName(field) : name, message);
        }
        return true;
    }
}
