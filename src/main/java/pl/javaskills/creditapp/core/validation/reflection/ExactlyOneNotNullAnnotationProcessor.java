package pl.javaskills.creditapp.core.validation.reflection;

import pl.javaskills.creditapp.core.annotation.ExacltyOneNotNull;
import pl.javaskills.creditapp.core.exception.ExactlyOneNotNullException;
import pl.javaskills.creditapp.core.exception.ValidationException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExactlyOneNotNullAnnotationProcessor implements ClassAnnotationProcessor{
    @Override
    public void process(Object object, Class aClass) throws IllegalAccessException, ValidationException {
        if(aClass.isAnnotationPresent(ExacltyOneNotNull.class)){
            ExacltyOneNotNull annotation = (ExacltyOneNotNull) aClass.getAnnotation(ExacltyOneNotNull.class);

            List<Field> fields = new ArrayList<>();
            for (String fieldName : annotation.value()){
                for (Field field : aClass.getDeclaredFields()){
                    field.setAccessible(true);
                    if (field.getName().equals(fieldName)){
                        fields.add(field);
                    }
                }
            }
            int numOfNotNullFields = 0;
            Set<String> fieldNames = new HashSet<>();
            for (Field field : fields){
                fieldNames.add(field.getName());
                if (field.get(object) != null){
                    numOfNotNullFields++;
                }
            }
            if (numOfNotNullFields != 1){
                throw new ExactlyOneNotNullException(fieldNames);
            }
        }
    }
}
