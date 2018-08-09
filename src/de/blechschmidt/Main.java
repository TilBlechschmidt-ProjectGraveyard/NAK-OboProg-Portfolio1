package de.blechschmidt;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        main.testNumbers();
    }

    public void testNumbers() {
        Numbers numbers = new Numbers();

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.fibonacci(i));
        }

        for (int i = 1; i < 4000; i ++) {
            System.out.print(i);
            System.out.print(": ");
            System.out.println(numbers.roman(i));
        }
    }
}
