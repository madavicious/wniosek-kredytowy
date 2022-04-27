package pl.javaskills.creditapp.core.validation.reflection;

import pl.javaskills.creditapp.core.annotation.NotNull;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.validation.ValidationUtils;

import java.lang.reflect.Field;

public class NotNullAnnotationProcessor implements FieldAnnotationProcessor{
    @Override
    public void process(Object object, Field field) throws IllegalAccessException, ValidationException {
        if (field.isAnnotationPresent(NotNull.class)){
            NotNull annotation = field.getAnnotation(NotNull.class);
            Object fieldValue = field.get(object);
            ValidationUtils.validateNotNull(field.getName(), fieldValue);
        }
    }
}
