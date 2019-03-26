import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PrimeAndMemoize {
    private static Map<Function, Map<Integer, Boolean>> isPrimeCachedResults = new HashMap();

    private static Function<Integer, Boolean> isPrime = (final Integer number) -> {
        if (number <= 1) return false;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    };

    private static Boolean memoize(final Function function, Integer number) {
        if (isPrimeCachedResults.containsKey(function)) {
            if (isPrimeCachedResults.get(function).containsKey(number)) {
                System.out.println("Result got from cache for: " + number);
                return isPrimeCachedResults.get(function).get(number);
            } else {
                final Boolean result = (Boolean) function.apply(number);

                System.out.println("Caching computed value for: " + number);
                isPrimeCachedResults.get(function).put(number, result);
                return result;
            }
        } else {
            final Boolean result = (Boolean) function.apply(number);

            Map<Integer, Boolean> resultMap = new HashMap<>();
            resultMap.put(number, result);

            System.out.println("Caching computed value for: " + number);
            isPrimeCachedResults.put(function, resultMap);
            return result;
        }
    }


    private static Boolean memoizedIsPrime(Integer number) {
        return memoize(isPrime, number);
    }

    public static void testIsPrime() {
        // Test prime number function
        System.out.println("............Test prime number function..");
        System.out.println("Actual: true, Got: " + PrimeAndMemoize.isPrime.apply(2));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.isPrime.apply(-1));
        System.out.println("Actual: true, Got: " + PrimeAndMemoize.isPrime.apply(101));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.isPrime.apply(999999998));
    }

    public static void testMemoize() {
        // Test memoizer
        System.out.println("............Test Memoizer...............");
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.memoizedIsPrime(999999998));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.memoizedIsPrime(999999998)); // result from cache
    }
}
