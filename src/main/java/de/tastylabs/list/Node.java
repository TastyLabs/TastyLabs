package de.tastylabs.list;

import de.tastylabs.exception.ElementNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class Node extends ListElement{
    private final ListElement next;
    private final DataElement element;

    public Node(ListElement next, DataElement element) {
        this.next = next;
        this.element = element;
    }

    @Override
    List<DataElement> search(List<String> query) {
        List<DataElement> result = next.search(query);
        for (String word : query) {
            if (element.getId().contains(word) || element.getTitle().contains(word) || element.getIngredients().contains(word) || element.getPreparation().contains(word)) {
                result.add(element);
            }
        }
        return result;
    }

    @Override
    DataElement get(String id) throws ElementNotFoundException {
        if (element.getId().equals(id)) {
            return element;
        } else {
            return next.get(id);
        }
    }

    @Override
    DataElement get(int index) {
        if (index == 0) {
            return element;
        } else {
            return next.get(index -1);
        }
    }

    @Override
    int size() {
        return next.size() + 1;
    }
}
