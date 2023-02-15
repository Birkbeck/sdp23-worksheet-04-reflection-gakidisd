package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Autograder {

    static final String CLASS_NAME = "StudentClass.java"; // TODO: insert the class name to be tested

    StudentClass student = new StudentClass(3);
    Class<?> c = student.getClass();

    public Autograder() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    }


    @Test
    public void testMoreThanFourFields() {
        // TODO: add testing code
        Field[] fields = c.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println(c);
        Assertions.assertFalse(fields.length < 4);
    }

    @Test
    public void testNonPrivateFields() {
        // TODO: add testing code
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields){
            Assertions.assertFalse(Modifier.isPublic(field.getModifiers()));

        }
    }

    // TODO: add a test for each of the remaining items of Question 3
    @Test
    public void testArray(){
        Field[] fields = c.getDeclaredFields();
        for (Field field: fields){
            Assertions.assertFalse(field.getType().isArray());
        }
    }


    @Test
    public void testHelpers(){
        ArrayList<Method> helpers = new ArrayList<>();
        Method[] methods = c.getDeclaredMethods();

        for (Method method : methods){
            int mod = method.getModifiers();
            if (Modifier.isPrivate(mod) && Modifier.isStatic(mod)){
                helpers.add(method);
            }
        }
        Assertions.assertFalse(helpers.size() < 3);
    }

    @Test
    public void testThrows(){
        Method[] methods = c.getDeclaredMethods();
        for (Method method: methods){
            Assertions.assertFalse(method.getExceptionTypes().length > 0);
        }
    }

    @Test
    public void testIntMethod(){
        Method[] methods = c.getDeclaredMethods();
        for (Method method: methods){
            Assertions.assertFalse(method.getReturnType().getName() == "int");
        }
    }

    @Test
    public void testZeroArgMethod(){
        Constructor[] constructors = c.getDeclaredConstructors();
        int indicator = 0;
        for (Constructor constructor :  constructors){
            if (constructor.getParameters().length == 0){
                indicator = 1;
            }
        }
        Assertions.assertFalse(indicator == 0);
    }




}
