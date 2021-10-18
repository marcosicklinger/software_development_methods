package it.units.sdm;

import java.lang.*;

public class StringList implements List{

    protected String[] values;
    protected int size;

    StringList(String[] values) {
        this.values = values;
        this.size = this.values.length;
    }

    @Override
    public int getSize() { return this.size; }

    @Override
    public void getValues (String[] values) { this.values = values; }

    @Override
    public boolean isEmpty() { return getSize() == 0; }

    @Override
    public boolean contains(String string) {
        for (int i = 0; i < this.size; i++) {
            if (string.equals(this.values[i])) return true;
        }
        return false;
    }

    @Override
    public void add(String string) {
        String[] new_values = new String[this.size + 1];
        for (int i = 0; i < this.size; i++) {
            new_values[i] = this.values[i];
        }
        new_values[this.size] = string;
        this.values = new_values;
        this.size = this.size + 1;
    }

    @Override
    public String get(int index) {
        if (index >= this.size) throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        return this.values[index];
    }

    @Override
    public void insertAt(int index, String string) {
        if (index >= this.size) throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        String[] new_values = new String[this.size + 1];
        for (int i = 0; i < this.size + 1; i++) {
            if (i < index) {
                new_values[i] = this.values[i];
            } else if (i > index) {
                new_values[i] = this.values[i - 1];
            } else new_values[index] = string;
        }
        this.values = new_values;
        this.size = this.size + 1;
    }

    @Override
    public void remove(int index) {
        if (index >= this.size) throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        String[] new_values = new String[size - 1];
        for (int i = 0; i < this.size; i++) {
            if (i < index) {
                new_values[i] = this.values[i];
            } else if (i > index) new_values[i - 1] = this.values[i];
        }
        this.values = new_values;
        this.size = this.size - 1;
    }

    @Override
    public int indexOf(String string) throws Exception {
        for (int i = 0; i < this.size; i++) {
            if (string.equals(this.values[i])) return i;
        }
        throw new Exception("No element matching " + string);
    }

    @Override
    public String toString() {
        String string = "class StringList \n";
        for (int i = 0; i < size; i++) {
            string += this.values[i] + "\n";
        }
        return string;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("TESTING StringList CLASS");
        if (args == null) {
            System.out.println("No argument passed ... quitting application");
            return;
        }
        StringList list = new StringList(args);
        System.out.println("Is instantiated StringList object empty? " + list.isEmpty());
        System.out.println("printing instance of object StringList");
        System.out.print(list);
        System.out.println("list size is: " + list.getSize());
        list.add("sssssh");
        System.out.println("printing instance of object StringList after adding");
        System.out.print(list);
        list.remove(3);
        System.out.println("printing instance of object StringList after removing");
        System.out.print(list);
        System.out.println("get 4-th element from StringList object instance " + list.get(4));
        System.out.println("index of 'ff' is " + list.indexOf("ff"));
        list.insertAt(3, "hhhh");
        System.out.println("printing instance of object StringList after inserting");
        System.out.print(list);

        list.insertAt(24, "");
        System.out.println(list.get(24));
    }

}
