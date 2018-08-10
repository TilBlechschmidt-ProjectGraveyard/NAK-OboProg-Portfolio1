package de.blechschmidt;

public class Numbers {

    // Constants for the roman number conversion.
    private final String[] romanSymbols = { "M", "D", "C", "L", "X", "V", "I" };
    private final int[] romanSymbolValues = { 1000, 500, 100, 50, 10, 5, 1 };

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

    /**
     * Calculates the roman number representation of a positive whole number larger than 0 and smaller than 4000.
     * @param arabicNumber The number to convert.
     * @return The roman representation of the given number.
     */
    public String roman(int arabicNumber) {
        StringBuilder romanNumber = new StringBuilder();

        // Iterate through the symbols beginning with the highest value.
        for (int romanNumberIndex = 0; romanNumberIndex < romanSymbolValues.length; romanNumberIndex++) {
            // Retrieve the information about the current symbol.
            String currentRomanSymbol = romanSymbols[romanNumberIndex];
            int currentRomanSymbolValue = romanSymbolValues[romanNumberIndex];
            int currentRomanSymbolValueFitCount = arabicNumber / currentRomanSymbolValue;

            // Replace 9 times the same symbol with 2 symbols in reversed order (eg. IX, XC).
            if (currentRomanSymbolValueFitCount == 9) {
                romanNumber.append(currentRomanSymbol);
                romanNumber.append(romanSymbols[romanNumberIndex - 2]);
                arabicNumber -= 9 * currentRomanSymbolValue;
            }

            // Replace 4 times the same symbol with 2 symbols in reversed order (eg. IV, XL).
            else if (currentRomanSymbolValueFitCount == 4) {
                romanNumber.append(currentRomanSymbol);
                romanNumber.append(romanSymbols[romanNumberIndex - 1]);
                arabicNumber -= 4 * currentRomanSymbolValue;
            }

            // If the symbol fits and the next symbol does not fit 9 times add it.
            // IOW: If we have a 9 do not add a V although it would fit because we want to add IX later.
            else if (romanNumberIndex == romanSymbolValues.length - 1 || arabicNumber / romanSymbolValues[romanNumberIndex + 1] != 9) {
                // Add the correct number of arguments.
                for (int i = 0; i < currentRomanSymbolValueFitCount; i++) {
                    romanNumber.append(currentRomanSymbol);
                }
                arabicNumber -= currentRomanSymbolValueFitCount * currentRomanSymbolValue;
            }
        }

        return romanNumber.toString();
    }
}
