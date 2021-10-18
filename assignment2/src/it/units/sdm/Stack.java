package it.units.sdm;

public interface Stack extends Collection {

    void push(String string);

    String pop();

    String top() throws Exception;

}