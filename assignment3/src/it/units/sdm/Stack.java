package it.units.sdm;

public interface Stack <T> extends Collection <T> {

    void push(T value);

    T pop();

    default T top() throws Exception { return getValues()[getSize() - 1]; };

}
