package pl.javaskills.creditapp.core.validation.reflection;

import pl.javaskills.creditapp.core.exception.ValidationException;

import java.lang.reflect.Field;

public interface FieldAnnotationProcessor {
    void process(Object object, Field field) throws IllegalAccessException, ValidationException;
}
