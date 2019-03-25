public class Main {

    public static void main(String[] args) {
        test();

    }

    private static void test() {
        // Test prime number function
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrime.apply(2));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrime.apply(-1));
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrime.apply(101));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrime.apply(999999998));

        // Test memoizer
        System.out.println("Actual false, Got: " + PrimeAndMemoize.memoize(PrimeAndMemoize.isPrime,999999998));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.memoize(PrimeAndMemoize.isPrime,999999998)); // result from cache
    }
}
