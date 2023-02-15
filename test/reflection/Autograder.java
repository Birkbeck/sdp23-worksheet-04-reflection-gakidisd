package reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Autograder {

    static final String CLASS_NAME = "StudentClass.java"; // TODO: insert the class name to be tested

    StudentClass student = new StudentClass();
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
}
