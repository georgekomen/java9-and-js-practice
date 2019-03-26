import java.util.ArrayList;
import java.util.List;

public class CollectionSearch<T> {

    private int searchFromCollection(List<T> list, T searchTerm) {
        return list.indexOf(searchTerm);
    }

    public static void testSearchCollection() {
        // Test collection search
        System.out.println("............Collection search...............");
        CollectionSearch<Integer> integerCollectionSearch = new CollectionSearch<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(9);
        System.out.println("Actual -1, Got: " + integerCollectionSearch.searchFromCollection(integerList, -3));
        System.out.println("Actual 2, Got: " + integerCollectionSearch.searchFromCollection(integerList, 3));
        System.out.println("Actual 0, Got: " + integerCollectionSearch.searchFromCollection(integerList, 1));
        System.out.println("Actual 4, Got: " + integerCollectionSearch.searchFromCollection(integerList, 9));
    }
}
