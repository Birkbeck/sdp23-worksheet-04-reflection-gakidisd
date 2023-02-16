package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Object> argsList = new ArrayList<>();

        for (int i = 1; i <= numOfParams; i++) {
            System.out.println("Give the parameter num " + i);
            String param = scanner.nextLine();
            argsList.add(param);
        }

        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(getParameterTypes(argsList));
            Object[] args1 = argsList.toArray();
            Object object = constructor.newInstance(args1);
        }  catch (Exception e){
            e.printStackTrace(System.err);
        }

        }

    public static Class<?>[] getParameterTypes(List<Object> argsList){
        Class<?>[] paramTypes = new Class[argsList.size()];
        for (int i = 0; i < argsList.size(); i++) {
            Object arg = argsList.get(i);
            paramTypes[i] = arg.getClass();
        }
        return  paramTypes;
    }
}
