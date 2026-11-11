package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();

        System.out.println("=== Завдання 3 ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        task4();
        task5();
        task6();
    }

    private static void task1() {
        System.out.println("=== Завдання 1 ===");

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        // 3. get() на порожньому об'єкті кидає виняток
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
        System.out.println();
    }

    private static void task2() {
        System.out.println("=== Завдання 2 ===");

        List<BookData> books = new ArrayList<>();
        books.add(new BookData("Кобзар", "Т. Шевченко", 4, 18));
        books.add(new BookData("Clean Code", "R. Martin", 10, 47));
        books.add(new BookData("Тигролови", "І. Багряний", 5, 24));
        books.add(new BookData("Effective Java", "J. Bloch", 2, 9));
        books.add(new BookData("Лісова пісня", "Леся Українка", 3, 12));

        Collections.sort(books);
        for (BookData book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    private static void task4() {
        System.out.println();
        System.out.println("=== Завдання 4 ===");

        Integer[] numbers = {5, 12, 7, 8, 21, 30, 3, 4};
        Integer[] even = ArrayUtils.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні: " + Arrays.toString(even));

        String[] cities = {"Одеса", "Київ", "Львів", "Ізмаїл", "Рені", "Херсон"};
        String[] longNames = ArrayUtils.filter(cities, s -> s.length() > 5);
        System.out.println("Назви довші за 5 літер: " + Arrays.toString(longNames));
        System.out.println();
    }

    private static void task5() {
        System.out.println("=== Завдання 5 ===");

        String[] languages = {"Java", "Python", "C++", "Kotlin"};
        System.out.println("Java у масиві: " + ArrayUtils.contains(languages, "Java"));
        System.out.println("Go у масиві: " + ArrayUtils.contains(languages, "Go"));

        Integer[] primes = {2, 3, 5, 7, 11, 13};
        System.out.println("7 у масиві: " + ArrayUtils.contains(primes, 7));
        System.out.println("9 у масиві: " + ArrayUtils.contains(primes, 9));
        System.out.println();
    }

    private static void task6() {
        System.out.println("=== Завдання 6 ===");

        int[] marks = {74, 91, 60, 88, 95, 70};

        GenericTwoTuple<Integer, Integer> range = minMax(marks);
        System.out.println("Мінімум і максимум: " + range);
        System.out.println("Різниця: " + (range.second - range.first));

        GenericTwoTuple<String, Integer> word = longestWord(new String[]{"дім", "університет", "лабораторна"});
        System.out.println("Найдовше слово: " + word.first + ", довжина " + word.second);

        GenericThreeTuple<Integer, Integer, Double> stats = statistics(marks);
        System.out.println("Статистика (min, max, avg): " + stats);
        System.out.printf("Середній бал: %.2f%n", stats.three);

        GenericThreeTuple<String, Integer, Double> order = new GenericThreeTuple<>("Монітор", 2, 7499.50);
        String product = order.getFirst();
        int quantity = order.getSecond();
        double price = order.three;
        System.out.println("Замовлення: " + order);
        System.out.printf("До сплати за %s: %.2f грн%n", product, quantity * price);
    }

    private static GenericTwoTuple<Integer, Integer> minMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        for (int n : numbers) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return new GenericTwoTuple<>(min, max);
    }

    private static GenericTwoTuple<String, Integer> longestWord(String[] words) {
        String longest = words[0];
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }
        return new GenericTwoTuple<>(longest, longest.length());
    }

    private static GenericThreeTuple<Integer, Integer, Double> statistics(int[] numbers) {
        GenericTwoTuple<Integer, Integer> range = minMax(numbers);
        double sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return new GenericThreeTuple<>(range.first, range.second, sum / numbers.length);
    }
}
