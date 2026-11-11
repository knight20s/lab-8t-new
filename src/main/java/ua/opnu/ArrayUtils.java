package ua.opnu;

import java.util.Arrays;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    /**
     * Завдання 4. Повертає масив з елементів, які задовольняють предикат.
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        // фактично result має тип Object[], тому копіюємо в масив того ж типу,
        // що й input, інакше присвоєння в Integer[] чи String[] впаде з ClassCastException
        return (T[]) Arrays.copyOfRange(result, 0, counter, input.getClass());
    }

    /**
     * Завдання 5. Перевіряє, чи входить element у масив.
     * T має реалізовувати Comparable, V - це T або його підклас.
     */
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}
