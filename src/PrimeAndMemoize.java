import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PrimeAndMemoize {
   public static Map<Integer, Boolean> isPrimeCachedResults = new HashMap();

    public static Function<Integer, Boolean> isPrime = (final Integer number) -> {
        if (number <= 1) return false;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    };

    public static Boolean memoize(final Function<Integer, Boolean> function, Integer number) {
        if (function == isPrime) {
            if (isPrimeCachedResults.containsKey(number)) {
                System.out.println("Result got from cache for: " + number);
                return isPrimeCachedResults.get(number);
            } else {
                final Boolean result = function.apply(number);
                isPrimeCachedResults.put(number, result);
                System.out.println("Caching computed value for: " + number);
                return result;
            }
        } else {
            // handle any other function here
            return false;
        }
    }
}
