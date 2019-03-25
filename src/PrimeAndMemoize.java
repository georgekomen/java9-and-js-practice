import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PrimeAndMemoize {
   public static Map<Integer, Boolean> cachedIsPrimeResults = new HashMap();

    public static Function<Integer, Boolean> isPrime = (final Integer number) -> {
        if (number <= 1) return false;

            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    };

    public static Boolean memoize(Integer integer) {
        if (cachedIsPrimeResults.containsKey(integer)) {
            System.out.println("From cache " + integer);
            return cachedIsPrimeResults.get(integer);
        } else {
            final Boolean result = isPrime.apply(integer);
            cachedIsPrimeResults.put(integer, result);
            System.out.println("Enter cache " + integer);
            return result;
        }
    }
}
