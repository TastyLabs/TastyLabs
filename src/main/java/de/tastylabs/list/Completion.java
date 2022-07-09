package de.tastylabs.list;

import de.tastylabs.exception.ElementNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.LinkedList;
import java.util.List;

public class Completion extends ListElement{

    @Override
    List<DataElement> search(List<String> query) {
        return new LinkedList<>();
    }

    @Override
    Recipe get(String id) throws ElementNotFoundException {
        throw new ElementNotFoundException("No recipe with id " + id);
    }

    @Override
    Recipe get(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    int size() {
        return 0;
    }
}
