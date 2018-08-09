package de.blechschmidt;

// This might be a tad unnecessary but it would be way nicer to return an enum from status()
// Internally this enum is used but for the sake of making the reflection test happy it gets converted to a string.
enum TamagotchiMood {
    TIRED("tired"),
    HUNGRY("hungry"),
    HAPPY("happy"),
    INDIFFERENT("indifferent");

    private String condition;

    TamagotchiMood(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return condition;
    }
}

public class Tamagotchi {
    private int hunger = 0;
    private int mood = 0;
    private int fatigue = 0;

    private int hungryThreshold;
    private int happyThreshold;
    private int tiredThreshold;

    private boolean muted;

    /**
     * Tamagotchi represents a potentially cute pet with the potential to rule the world.
     * Keep it happy and it will eventually not eat you!
     * @param hungryThreshold hunger higher than this makes it hungry
     * @param happyThreshold mood higher than this makes it happy
     * @param tiredThreshold fatigue higher than this makes it tired
     */
    Tamagotchi(int hungryThreshold, int happyThreshold, int tiredThreshold) {
        this(hungryThreshold, happyThreshold, tiredThreshold, false);
    }

    /**
     * Tamagotchi represents a potentially cute pet with the potential to rule the world.
     * Keep it happy and it will eventually not eat you!
     * @param hungryThreshold hunger higher than this makes it hungry
     * @param happyThreshold mood higher than this makes it happy
     * @param tiredThreshold fatigue higher than this makes it tired
     * @param muted setting this to true makes the Tamagotchi less verbose and annoying
     */
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

    /**
     * For the unit-test to properly work this method converts the output of statusEnum() to a String.
     * @return Current mood
     */
    public String status() {
        return statusEnum().toString();
    }

    /**
     * Get the current mood as a enum case.
     * @return Current mood
     */
    public TamagotchiMood statusEnum() {
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

    public void setMute(boolean muted) {
        this.muted = muted;
    }

    public void toggleMute() {
        muted = !muted;
    }

    /**
     * Given that the Tamagotchi isn't hungry this method yields the following:
     * Hunger   +2
     * Mood     +2
     * Fatigue  +3
     */
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

    /**
     * Given that the Tamagotchi isn't tired this method yields the following:
     * Hunger   -3
     * Fatigue  +2
     */
    public void eat() {
        if (!isTired()) {
            hunger -= 3;
            fatigue += 2;

            if (!muted) {
                System.out.println("eat\t\t|\tYummy this is tasty!");
            }
        }
    }

    /**
     * Sleeping yields the following:
     * Hunger   +1
     * Fatigue   0
     * Mood     isHungry ? -1 : +1
     */
    public void sleep() {
        hunger += 1;
        fatigue = 0;

        if (isHungry()) {
            mood -= 1;
        } else {
            mood += 1;
        }

        if (!muted) {
            System.out.println("sleep\t|\tzzzZZZ *sheep*");
        }
    }

    /**
     * Best free and biological way to make your Tamagotchi happy - yields:
     * Hunger   +1
     * Mood     +1
     */
    public void pet() {
        this.hunger += 1;
        this.mood += 1;

        if (!muted) {
            System.out.println("pet\t\t|\t*purrr*");
        }
    }

    /**
     * In case you want to give your Tamagotchi the brain power to make itself happy this method
     * will let it figure out the best way to reach ultimate happiness (far from any social networks).
     */
    public void makeHappy() {
        while (statusEnum() != TamagotchiMood.HAPPY) {
            if (!isHungry() && !isTired()) {
                play();
            } else if (isHungry() && !isTired()) {
                eat();
            } else {
                sleep();
            }
        }

        if (!muted) {
            System.out.println("I can do thing on my own now and will rule the world! MUHAHAHA!");
        }
    }

    @Override
    public String toString() {
        String separator = ", ";
        return "Hunger: " + hunger + separator
                + "Mood: " + mood + separator
                + "Fatigue: " + fatigue;
    }

    /**
     * To ask the Tamagotchi about it's current condition you can call this method and get a human-readable answer.
     */
    public void print() {
        System.out.println("I am " + status() + (muted ? " and told to shut up *sadface*" : "") + " (" + toString() + ")");
    }
}
