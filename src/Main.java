public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        PrimeNumberAndMemoize.testIsPrime(); // question 1 a
        PrimeNumberAndMemoize.testMemoizedIsPrime(); // question 1 b & c
        CollectionSearch.testSearchCollection(); // question 2
    }
}
