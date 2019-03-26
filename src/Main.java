public class Main {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        PrimeAndMemoize.testIsPrime();
        PrimeAndMemoize.testMemoize();
        CollectionSearch.testSearchCollection();
    }
}
