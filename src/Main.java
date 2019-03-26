import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        // Test prime number function
        System.out.println("............Test prime number function..");
        System.out.println("Actual: true, Got: " + PrimeAndMemoize.isPrime.apply(2));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.isPrime.apply(-1));
        System.out.println("Actual: true, Got: " + PrimeAndMemoize.isPrime.apply(101));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.isPrime.apply(999999998));

        // Test memoizer
        System.out.println("............Test Memoizer...............");
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.memoizedIsPrime(999999998));
        System.out.println("Actual: false, Got: " + PrimeAndMemoize.memoizedIsPrime(999999998)); // result from cache

        // Test collection search
        System.out.println("............Collection search...............");
        CollectionSearch<Integer> integerCollectionSearch = new CollectionSearch<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        System.out.println(integerCollectionSearch.searchFromCollection(integerList, -3));
    }
}
