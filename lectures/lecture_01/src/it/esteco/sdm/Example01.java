package it.esteco.sdm;

public class Example01 {

    private String number;

    public Example01(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "This is example no " + number;
    }

    public static void main(String[] args) {
        System.out.println(new Example01("01"));
    }

}