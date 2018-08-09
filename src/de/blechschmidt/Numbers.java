package de.blechschmidt;

public class Numbers {

    // Constructor
    public Numbers() {}


    // Methods
    /**
     * Calculates the nth number of the fibonacci sequence. The sequence starts with 0, 1, 1, 2, 3, ...
     * @param fibonacciSequenceIndex
     * @return The requested value from the sequence.
     */
    public int fibonacci(int fibonacciSequenceIndex) {
        int lowerKnownFibonacciNumber = 0;
        int upperKnownFibonacciNumber = 1;

        // Repeat until the correct fibonacci number is reached.
        for (int currentIndex = 0; currentIndex  < fibonacciSequenceIndex; currentIndex ++) {
            // Add and swap.
            int previousUpperKnownFibonacciNumber = upperKnownFibonacciNumber;
            upperKnownFibonacciNumber = lowerKnownFibonacciNumber + upperKnownFibonacciNumber;
            lowerKnownFibonacciNumber = previousUpperKnownFibonacciNumber;
        }

        return lowerKnownFibonacciNumber;
    }
