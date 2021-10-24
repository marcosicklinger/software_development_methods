package it.units.sdm;

import java.util.Arrays;
import java.lang.reflect.*;

public class GenericStack <T extends Object> implements Stack <T> {

    protected T[] data;
    protected int size;

    GenericStack(T[] data) {
        size = data.length;
        this.data = (T[]) Array.newInstance(data.getClass().getComponentType(), size);
        System.arraycopy(data, 0, this.data, 0, size);
    }

    @Override
    public int getSize() { return size; };

    @Override
    public boolean contains(T value) {
        for(int i = 0; i < size; i++) {
            if (data[i].equals(value)) return true;
        }
        return false;
    };

    @Override
    public T[] getValues( ) {
        T[] values = (T[]) Array.newInstance(data.getClass().getComponentType(), size);
        System.arraycopy(data, 0, values, 0, size);
        return values;
    };

    @Override
    public void push(T value) {
        T[] new_data = (T[]) Array.newInstance(data.getClass().getComponentType(), size + 1);
        System.arraycopy(data, 0, new_data, 0, size);
        new_data[size] = value;
        data = Arrays.copyOf(new_data, size + 1);
        size = size + 1;
    };

    @Override
    public T pop() {
        T to_pop = data[size - 1];
        data = Arrays.copyOf(data, size - 1);
        size = size - 1;
        return to_pop;
    };

    @Override
    public String toString() {
        String string = getClass().getName() + "\n";
        for (T element : data) {
            string += element + "\n";
        }
        return string;
    }

    public static void main(String[] args) {
        Integer array[] = {1,2,3,4,5};
        GenericStack<Integer> IntStack = new GenericStack<Integer>(array);
        System.out.println("printing stack:");
        System.out.print(IntStack);

        System.out.println("size: " + IntStack.getSize());

        int v = 5;
        System.out.println("Does it contain " + v + "?" + " " + IntStack.contains(v));

        System.out.println("Values contained are:");
        Integer[] values = IntStack.getValues();
        for (int element : values) {
            System.out.println(element);
        }

        System.out.println("pushing " + v + ":");
        IntStack.push(v);
        System.out.print(IntStack);

        System.out.println("popping:");
        IntStack.pop();
        System.out.print(IntStack);

    }

}
