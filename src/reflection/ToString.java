package reflection;

import java.lang.reflect.Field;

public class ToString {
    public static String toString(Object object) {
        // TODO: implement the functionality for Question 4
        StringBuilder sb = new StringBuilder();
        sb.append(object.getClass().getName()).append(" {");

        try {
            // Get all fields for the object's class, including private ones
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                // Set the field to be accessible, in case it's private
                field.setAccessible(true);

                sb.append(field.getName()).append("=");
                Object value = field.get(object);
                if (value == null) {
                    sb.append("null");
                } else if (value.getClass().isArray()) {
                    sb.append(arrayToString(value));
                } else {
                    sb.append(value.toString());
                }
                sb.append(", ");
            }
            // Remove the trailing comma and space
            if (sb.length() > 2) {
                sb.setLength(sb.length() - 2);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append("}");
        return sb.toString();
    }

    private static String arrayToString(Object array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int length = java.lang.reflect.Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = java.lang.reflect.Array.get(array, i);
            if (element == null) {
                sb.append("null");
            } else {
                sb.append(element.toString());
            }
            sb.append(", ");
        }
        // Remove the trailing comma and space
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }
}

