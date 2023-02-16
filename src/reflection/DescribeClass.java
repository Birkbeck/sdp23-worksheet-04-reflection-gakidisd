package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class DescribeClass {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length != 1)
            System.out.println("Usage: "); // TODO: describe how to use the utility

        // TODO: implement the functionality for Question 1
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Give a class name. Press enter to stop searching for a class.");
            String className = scanner.nextLine();

            if (className == ""){
                System.out.println("Bye!");
                break;
            }

            Class<?> c = classNamePrinter(className);
            System.out.println("Do you want to see the class hierarchy?(y/n)");
            String hierarchy = scanner.nextLine();
            if (hierarchy.toLowerCase().equals("y")){
                System.out.println("Class hierarchy for " + c.getName());
                showClassHierarchy(c);
            }
            System.out.println("\nBelow you see the modifiers of the class");
            checkClass(c);
            showInterfaces(c);
            showFields(c);
            showMethods(c);
        }
    }

    public static<T>  T classNamePrinter(String className) throws ClassNotFoundException {
        Class<?> c = Class.forName(className);
        System.out.println("Class names: ");
        System.out.println("\t\tPackage Name of the class: " + c.getName());
        System.out.println("\t\tSimple name of the class: " + c.getSimpleName());
        return (T) c;
    }


    public static void showClassHierarchy(Class<?> c){
        if (c.getSuperclass() == null){
            System.out.println("\t" + c.getName());
            return;
        }
        showClassHierarchy(c.getSuperclass());
        System.out.println("\t" + c.getName());
    }

    public static void checkClass(Class<?> c){
        int mod = c.getModifiers();
        boolean isPublic = Modifier.isPublic(mod);
        System.out.println("\t\tIs public: " + isPublic);
        boolean isFinal = Modifier.isFinal(mod);
        System.out.println("\t\tIs final: " + isFinal);
        boolean isAbstract = Modifier.isAbstract(mod);
        System.out.println("\t\tIs abstract: " + isAbstract);
        boolean isNative = Modifier.isNative(mod);
        System.out.println("\t\tIs native: " + isNative);
        System.out.println(c + " is " + Modifier.toString(mod));
    }

    public static void showInterfaces(Class<?> c){
        Class<?>[] interfaces = c.getInterfaces();
        System.out.println("\nThe interfaces of the class " + c.getName() + " are the below:");
        int count = 1;
        for (Class<?> intf : interfaces){
            System.out.println(count);
            System.out.println("\t\t" + intf);
            checkClass(intf);
            System.out.println();
            count ++;
        }
    }

    public static void showFields(Class<?> c){
        Field[] fields = c.getDeclaredFields();
        System.out.println("\nThe fields of the class " + c.getName() + " are the below:");
        for (Field field:fields){
            System.out.println("\t\t"+field);
        }
    }

    public static void showMethods(Class<?> c){
        Method[] methods = c.getDeclaredMethods();
        System.out.println("\nThe methods of the class " + c.getName() + " are the below:");
        for (Method method:methods){
            System.out.println("\t\t" + method);
        }
    }
}
