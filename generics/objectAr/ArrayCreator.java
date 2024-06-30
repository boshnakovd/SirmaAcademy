package objectAr;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {


    public static <T> T[] create(int length, T item) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(item.getClass(), length);
        Arrays.fill(array, item);
        return array;
    }


    public static <T> T[] create(Class<T> clazz, int length, T item) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array, item);
        return array;
    }
}