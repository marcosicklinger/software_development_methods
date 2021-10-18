package it.units.sdm;

import java.lang.*;
import java.util.*;

public class StringStack implements Stack {

    protected String[] values;
    protected int size;

    StringStack(String[] values) {
        this.getValues(values);
        size = this.values.length;
    }

    @Override
    public void getValues(String[] values) { this.values = values; }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < getSize(); i++) {
            if (value.equals(this.values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() { return getSize() == 0; }

    @Override
    public void push(String string) {
        String[] new_values = new String[size + 1];
        for (int i = 0; i < size; i++) {
            new_values[i] = this.values[i];
        }
        new_values[size] = string;
        this.values = new_values;
        size = size + 1;
    }

    @Override
    public String pop() {
        size = size - 1;
        return this.values[size];
    }

    @Override
    public String top() throws Exception {
        if (this.size == 0) throw new Exception("Empty stack");
        return values[this.getSize() - 1];
    }

    @Override
    public String toString() {
        String string = "class StringStack \n";
        for (int i = 0; i < size; i++) {
            string += this.values[i] + "\n";
        }
        return string;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("TESTING StringStack CLASS");
        if (args == null) {
            System.out.println("No argument passed ... quitting application");
            return;
        }
        StringStack stack = new StringStack(args);
        System.out.println("Is instantiated StringStack object empty? " + stack.isEmpty());
        System.out.println("printing instance of object StringStack");
        System.out.print(stack);
        System.out.println("stack size is: " + stack.getSize());
        stack.push("sssssh");
        System.out.println("printing instance of object StringStack after pushing");
        System.out.print(stack);
        stack.pop();
        System.out.println("printing instance of object StringStack after popping");
        System.out.print(stack);
        System.out.println("StringStack object instance contains 'dd' string: " + stack.contains("dd"));
        System.out.println("Top of StringStack object is: " + stack.top());
    }

}
