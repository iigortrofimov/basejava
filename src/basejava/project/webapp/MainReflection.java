package basejava.project.webapp;

import basejava.project.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, RuntimeException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        Class mClassObject = Resume.class;
        String fullClassName = mClassObject.getName();
        System.out.println(fullClassName);
        Method[] methods = mClassObject.getMethods();
        System.out.println(Arrays.toString(methods));

        String methodName = "toString";
        Method toStringMethod = mClassObject.getMethod(methodName);
        System.out.println(toStringMethod.invoke(r));


    }
}
