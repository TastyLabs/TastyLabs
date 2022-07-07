package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.LinkedList;
import java.util.List;

public class Completion extends ListElement{

    @Override
    List<Recipe> search(List<String> query) {
        return new LinkedList<>();
    }

    @Override
    Recipe get(String id) throws RecipeNotFoundException {
        throw new RecipeNotFoundException("No recipe with id " + id);
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
