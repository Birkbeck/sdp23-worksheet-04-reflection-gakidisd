package reflection;

import java.lang.reflect.Modifier;
import java.util.Scanner;

public class DescribeClass {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length != 1)
            System.out.println("Usage: "); // TODO: describe how to use the utility

        // TODO: implement the functionality for Question 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a class name:");
        String className = scanner.nextLine();
        Class<?> c = classNamePrinter(className);

        System.out.println("Do you want to see the class hierarchy?(y/n)");
        String hierarchy = scanner.nextLine();
        if (hierarchy.toLowerCase().equals("y")){
            System.out.println("Class hierarchy for " + c.getName());
            showClassHierarchy(c);
        }

        System.out.println("\nBelow you see the modifiers of the class");
        checkClass(c);


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
}