import java.util.List;

public class CollectionSearch<T> {

    public int searchFromCollection(List<T> list, T searchTerm) {
        return list.indexOf(searchTerm);
    }
}
