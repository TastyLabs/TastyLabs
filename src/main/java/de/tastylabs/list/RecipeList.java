package de.tastylabs.list;

import de.tastylabs.exception.ElementNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class RecipeList {
    ListElement first;

    public RecipeList() {
        first = new Completion();
    }

    public void add(DataElement element) {
        first = new Node(first, element);
    }

    public List<DataElement> search(List<String> query) {
        return first.search(query);
    }

    public DataElement get(String id) throws ElementNotFoundException {
        return first.get(id);
    }

    public DataElement get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return first.get(index);
        }
    }

    public DataElement getRandom() {
        return get((int) (Math.random() * size()));
    }

    public int size() {
        return first.size();
    }
}
