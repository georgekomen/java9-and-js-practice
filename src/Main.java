public class Main {

    public static void main(String[] args) {
        runTests();
    }

    /**
     * Run this method to test the functions inside the declared classes
     * You should be able to view expected and actual result logged in your terminal
     * An improvement i can do here is use Assert J unit
     */
    private static void runTests() {
        PrimeNumberAndMemoize.testIsPrime(); // question 1 a
        PrimeNumberAndMemoize.testMemoizedIsPrime(); // question 1 b & c
        CollectionSearch.testSearchCollection(); // question 2
    }
}
