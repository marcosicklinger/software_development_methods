package it.units.sdm;

public interface List <T> extends Collection <T> {

    void add(T value);

    default T get(int index) { return getValues()[index]; };

    void insertAt(int index, T value);

    void remove(int index);

    default int indexOf(T value) throws Exception {
        int i = 0;
        T[] elements = getValues();
        for (T element : elements) {
            if (value.equals(element)) return i;
            i++;
        }
        throw new Exception("No element");
    };

}
