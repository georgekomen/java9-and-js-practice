public class Main {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // Test prime number function
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrime(2));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrime(-1));
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrime(101));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrime(999999998));
    }
}
