package pl.javaskills.creditapp.core.validation.reflection;

import pl.javaskills.creditapp.core.exception.ValidationException;

public interface ClassAnnotationProcessor {
    void process(Object object, Class aClass) throws IllegalAccessException, ValidationException;
}
