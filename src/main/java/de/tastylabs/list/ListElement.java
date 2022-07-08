package de.tastylabs.list;

import de.tastylabs.exception.ElementNotFoundException;

import java.util.List;

public abstract class ListElement {
    abstract List<DataElement> search(List<String> query);

    abstract DataElement get(String id) throws ElementNotFoundException;

    abstract DataElement get(int index);

    abstract int size();
}
