package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class InstantiateClass {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        if (args.length < 1)
            System.out.println("Usage: "); // TODO: describe how to use the utility

        // TODO: implement the functionality for Question 2
        System.out.println("Please give the name of the class that you want to initiate.");
        String className = scanner.nextLine();

        System.out.println("Please give the number of parameters that you would like to pass.");
        int numOfParams = Integer.valueOf(scanner.nextLine());
        String[] params = new String[numOfParams];

        for (int i = 1; i <= numOfParams; i++) {
            System.out.println("Give the parameter num " + i);
            String param = scanner.nextLine();
            params[i-1] = param;
        }

        try {
            String c = createObject(className,params);
        }  catch (Exception e){
            e.printStackTrace(System.err);
        }

        }



    public static<T> T createObject(String className, String[] params)
        throws  ClassNotFoundException, InstantiationException, IllegalAccessException,
            NoSuchMethodException, IllegalArgumentException, InvocationTargetException
    {
        Class<?> c = Class.forName(className);
        Constructor<?> constructor = c.getConstructor(String.class);
        return (T) constructor.newInstance(params);

    }
}
