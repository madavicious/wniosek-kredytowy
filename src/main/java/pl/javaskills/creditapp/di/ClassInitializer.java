package pl.javaskills.creditapp.di;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClassInitializer {

    private Map<String, Object> instances = new HashMap<>();

    public Object createInstance(Class classToInstantiate) throws Exception {
        return getInstance(classToInstantiate);
    }

    private Object getInstance(Class classToInstantiate) throws Exception {
        System.out.println("Creating instance of class " + classToInstantiate.getCanonicalName());
        if(instances.containsKey(classToInstantiate.getCanonicalName())){
            System.out.println("Instance of class " + classToInstantiate.getName() + " returned form cache.");
            return instances.get(classToInstantiate.getCanonicalName());
        }
        Object instance = classToInstantiate.getConstructor().newInstance();

        for(Field field : classToInstantiate.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Inject.class)){
                System.out.println("Dependency " + field.getName() + " found in class " + classToInstantiate.getName());
                Object dependencyInstance = getInstance(field.getType());
                Field dependencyField = instance.getClass().getDeclaredField(field.getName());
                dependencyField.setAccessible(true);
                dependencyField.set(instance, dependencyInstance);
                System.out.println("Dependency " + field.getName() + " injectet into class " + classToInstantiate.getName());

            }
        }
        System.out.println("Instance of class " + classToInstantiate.getCanonicalName() + " created.");
        instances.put(classToInstantiate.getCanonicalName(), instance);
        return instance;
    }

    public void registerInstance(Object instance){
        instances.put(instance.getClass().getCanonicalName(), instance);
    }
}
