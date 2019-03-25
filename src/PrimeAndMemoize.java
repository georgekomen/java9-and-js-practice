import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PrimeAndMemoize {
   public static Map<Function<Integer, Boolean>, Boolean> cachedResults = new HashMap();

    public static Function<Integer, Boolean> isPrime = (Integer number) -> {
        if (number <= 1) return false;

            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    };
}
