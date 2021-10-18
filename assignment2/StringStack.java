import Collection.*;
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
    public void getValues(String[] values) {
        this.values = values;
    }

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
    public boolean isEmpty() {
        if (getSize() == 0) return true;
        return false;
    }

    public void push(String string) {
        size = size + 1;
        List list = new ArrayList<String>(Arrays.asList(this.values));
        list.add(string);
        this.values = list.toArray(this.values);
    }

    @Override 
    public String pop() {
        size = size - 1;
        return this.values[size];
    }

    @Override
    public String top() {
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

    public static void main(String[] args) {
        System.out.println("TESTING StringStack CLASS");
        if (args == null) {
            System.out.println("No argument passed ... quitting application");
            return;
        }
        StringStack stack = new StringStack(args);
        System.out.print(stack);
    }

}
