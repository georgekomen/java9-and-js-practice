import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PrimeNumberAndMemoize {
    private static final Map<Function, Map<Integer, Boolean>> isPrimeCachedResults = new HashMap();

    /**
     * @param number - number to be tested if is prime or not
     *
     */
    private static Function<Integer, Boolean> isPrime = (final Integer number) -> {
        if (number <= 1) return false;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    };

    /**
     * @param function - function whose results should be cached and returned previously cached results
     * @param number - parameter of the function above
     * @returns boolean result
     */
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


    /**
     * @param number - parameter
     * Memoized version of isPrime function
     * @return
     */
    private static Boolean memoizedIsPrime(Integer number) {
        return memoize(isPrime, number);
    }

    public static void testIsPrime() {
        System.out.println("............Test prime number function..");
        System.out.println("Actual: true, Got: " + PrimeNumberAndMemoize.isPrime.apply(2));
        System.out.println("Actual: false, Got: " + PrimeNumberAndMemoize.isPrime.apply(-1));
        System.out.println("Actual: true, Got: " + PrimeNumberAndMemoize.isPrime.apply(101));
        System.out.println("Actual: false, Got: " + PrimeNumberAndMemoize.isPrime.apply(999999998));
    }

    public static void testMemoizedIsPrime() {
        System.out.println("............Test Memoizer...............");
        System.out.println("Actual: false, Got: " + PrimeNumberAndMemoize.memoizedIsPrime(999999998));
        System.out.println("Actual: false, Got: " + PrimeNumberAndMemoize.memoizedIsPrime(999999998)); // result from cache
    }
}
