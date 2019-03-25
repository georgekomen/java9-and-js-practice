public class Main {

    public static void main(String[] args) {
        test();

    }

    private static void test() {
        // Test prime number function
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrimePredicate().test(2));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrimePredicate().test(-1));
        System.out.println("Actual true, Got: " + PrimeAndMemoize.isPrimePredicate().test(101));
        System.out.println("Actual false, Got: " + PrimeAndMemoize.isPrimePredicate().test(999999998));
    }
}
