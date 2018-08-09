package de.blechschmidt;

public class Tamagotchi {
    private int hunger = 0;
    private int mood = 0;
    private int fatigue = 0;

    private int hungryThreshold;
    private int happyThreshold;
    private int tiredThreshold;

    private boolean muted;

    Tamagotchi(int hungryThreshold, int happyThreshold, int tiredThreshold) {
        this(hungryThreshold, happyThreshold, tiredThreshold, false);
    }

    Tamagotchi(int hungryThreshold, int happyThreshold, int tiredThreshold, boolean muted) {
        this.hungryThreshold = hungryThreshold;
        this.happyThreshold = happyThreshold;
        this.tiredThreshold = tiredThreshold;
        this.muted = muted;
    }

    private boolean isHungry() {
        return hunger > hungryThreshold;
    }

    private boolean isHappy() {
        return mood > happyThreshold;
    }

    private boolean isTired() {
        return fatigue > tiredThreshold;
    }

    public void mute(boolean muted) {
        this.muted = muted;
    }

    public void toggleMute() {
        muted = !muted;
    }

    public void play() {
        if (!isHungry()) {
            hunger += 2;
            mood += 2;
            fatigue += 3;

            if (!muted) {
                System.out.println("play\t|\tPlaying is fun!");
            }
        }
    }

    public void eat() {
        if (!isTired()) {
            hunger -= 3;
            fatigue -= 2;

            if (!muted) {
                System.out.println("eat\t\t|\tYummy this is tasty!");
            }
        }
    }

    public void sleep() {
        if (!muted) {
            System.out.println("sleep\t|\tzzzZZZ *sheep*");
        }

        hunger += 1;
        fatigue = 0;

        if (isHungry()) {
            mood -= 1;
        } else {
            mood += 1;
        }
    }

    public void pet() {
        if (!muted) {
            System.out.println("pet\t\t|\t*purrr*");
        }

        this.hunger += 1;
        this.mood += 1;
    }

    public void makeHappy() {
        if (!muted) {
            System.out.println("I can do thing on my own now and will rule the world! MUHAHAHA!");
        }

        while (status() != TamagotchiMood.HAPPY) {
            if (!isHungry() && !isTired()) {
                play();
            } else if (isHungry() && !isTired()) {
                eat();
            } else {
                sleep();
            }
        }
    }

    TamagotchiMood status() {
        if (isTired()) {
            return TamagotchiMood.TIRED;
        } else if (isHungry()) {
            return TamagotchiMood.HUNGRY;
        } else if (isHappy()) {
            return TamagotchiMood.HAPPY;
        } else {
            return TamagotchiMood.INDIFFERENT;
        }
    }

    public String toString() {
        return status().toString();
    }

    public void print() {
        System.out.println("I am " + toString() + (muted ? " and told to shut up *sadface*" : ""));
    }
}
