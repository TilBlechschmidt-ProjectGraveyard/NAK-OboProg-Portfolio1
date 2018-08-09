package de.blechschmidt;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Tamagotchi tmg = new Tamagotchi(3, 50, 10);
        tmg.makeHappy();
        tmg.print();

        main.testNumbers();
    }

    public void testNumbers() {
        Numbers numbers = new Numbers();

        for (int i = 0; i < 10; i++) {
            System.out.println(numbers.fibonacci(i));
        }
    }
}
