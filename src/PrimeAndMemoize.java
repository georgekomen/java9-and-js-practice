import java.util.function.Predicate;

public class PrimeAndMemoize {


    public static Predicate<Integer> isPrimePredicate() {
        return PrimeAndMemoize::isPrime;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
