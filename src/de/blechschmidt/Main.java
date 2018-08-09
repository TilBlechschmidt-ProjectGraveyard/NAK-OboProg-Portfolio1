package de.blechschmidt;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        main.buyATamagotchi();
    }
    
    void buyATamagotchi() {
        Tamagotchi mizutamatchi = new Tamagotchi(0, 0, 0);
        mizutamatchi.print();
        mizutamatchi.makeHappy();
        mizutamatchi.print();
    }
}
