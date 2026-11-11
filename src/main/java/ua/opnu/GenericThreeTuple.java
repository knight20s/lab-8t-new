package ua.opnu;

/**
 * Кортеж з трьох елементів. Перші два зберігаються у вкладеному GenericTwoTuple (композиція).
 */
public class GenericThreeTuple<T, V, S> {

    private final GenericTwoTuple<T, V> pair;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.pair = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    public T getFirst() {
        return pair.first;
    }

    public V getSecond() {
        return pair.second;
    }

    public S getThree() {
        return three;
    }

    @Override
    public String toString() {
        return "(" + pair.first + "," + pair.second + "," + three + ")";
    }
}
