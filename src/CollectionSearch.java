import java.util.ArrayList;
import java.util.List;

public class CollectionSearch<T> {

    /**
     * @param list - collection of generic type
     * @param searchTerm - object to be searched inside the collection
     * @return index of object searched in the collection
     */
    private int searchFromCollection(List<T> list, T searchTerm) {
        return list.indexOf(searchTerm);
    }

    public static void testSearchCollection() {
        System.out.println("............Collection search...............");
        CollectionSearch<Integer> integerCollectionSearch = new CollectionSearch<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(9);
        System.out.println("Expected: -1, Actual: " + integerCollectionSearch.searchFromCollection(integerList, -3));
        System.out.println("Expected: 2, Actual: " + integerCollectionSearch.searchFromCollection(integerList, 3));
        System.out.println("Expected: 0, Actual: " + integerCollectionSearch.searchFromCollection(integerList, 1));
        System.out.println("Expected: 4, Actual: " + integerCollectionSearch.searchFromCollection(integerList, 9));
    }
}
