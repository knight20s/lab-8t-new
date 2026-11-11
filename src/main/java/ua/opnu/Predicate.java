package ua.opnu;

/**
 * Узагальнена версія предиката з лабораторної роботи 7.
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T value);
}
