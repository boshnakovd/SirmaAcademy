package objectAr;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] stringArray = ArrayCreator.create(5, "Hello");
        System.out.println(arrayToString(stringArray));


        Integer[] integerArray = ArrayCreator.create(Integer.class, 5, 42);
        System.out.println(arrayToString(integerArray));
    }


    public static <T> String arrayToString(T[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}