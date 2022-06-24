package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;
import java.util.Objects;

public abstract class ListElement {
    abstract List<Recipe> search(List<String> query);

    abstract Recipe get(String id) throws RecipeNotFoundException;

    abstract Recipe get(int index);

    abstract int size();
}
