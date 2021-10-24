package it.units.sdm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericList <T extends Object> implements List <T>{

    protected T[] data;
    protected int size;

    GenericList(T[] data) {
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
    public T[]  getValues() {
        T[] values = (T[]) Array.newInstance(data.getClass().getComponentType(), size);
        System.arraycopy(data, 0, values, 0, size - 1);
        return values;
    };

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public void add(T value) {
        T[] new_values = (T[]) Array.newInstance(data.getClass().getComponentType(), size + 1);
        System.arraycopy(data, 0, new_values, 0, size);
        new_values[size] = value;
        data = Arrays.copyOf(new_values, size + 1);
        size = size + 1;
    }

    @Override
    public void insertAt(int index, T value) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        T[] new_values = (T[]) Array.newInstance(data.getClass().getComponentType(), size + 1);
        System.arraycopy(data, 0, new_values, 0, index);
        System.arraycopy(data, index, new_values, index + 1, size - index);
        new_values[index] = value;
        data = Arrays.copyOf(new_values, size + 1);
        size = size + 1;
    }

    @Override
    public void remove(int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bound");
        T[] new_values = (T[]) Array.newInstance(data.getClass().getComponentType(), size - 1);
        System.arraycopy(data, 0, new_values, 0, index);
        System.arraycopy(data, index + 1, new_values, index, size - index - 1);
        data = Arrays.copyOf(new_values, size - 1);
        size = size - 1;
    }

    @Override
    public String toString() {
        String string = getClass().getName() + "\n";
        for (T element : data) {
            string += element + "\n";
        }
        return string;
    }

    public static void main(String[] args) {
        GenericList<Integer> IntList = new GenericList<>(new Integer[5]);
        for (int i = 0; i < 6; i++) {
            IntList.set(i,5-i);
            IntList.add(i);
        }
        System.out.print(IntList);

        int v = 12;
        int index = 7;
        System.out.println("inserting " + v + " at " + index);
        IntList.insertAt(index, v);
        System.out.print(IntList);

        System.out.println("removing element number " + index);
        IntList.remove(index);
        System.out.print(IntList);
    }

}
