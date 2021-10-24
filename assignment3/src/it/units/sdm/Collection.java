package it.units.sdm;

public interface Collection <T> {

    default boolean isEmpty() { return getSize() == 0; };

    int getSize();

    boolean contains(T value);

    T[]  getValues();

}
