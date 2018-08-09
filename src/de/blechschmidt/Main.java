package de.blechschmidt;

public class Main {

    public static void main(String[] args) {
        Tamagotchi tmg = new Tamagotchi(3, 50, 10);
        tmg.makeHappy();
        tmg.print();
    }
}
