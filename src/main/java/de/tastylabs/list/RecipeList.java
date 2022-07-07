package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class RecipeList {
    ListElement first;

    public RecipeList() {
        first = new Completion();
    }

    public void add(Recipe recipe) {
        first = new Node(first, recipe);
    }

    public List<Recipe> search(List<String> query) {
        return first.search(query);
    }

    public Recipe get(String id) throws RecipeNotFoundException {
        return first.get(id);
    }

    public Recipe get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            return first.get(index);
        }
    }

    public Recipe getRandom() {
        return get((int) (Math.random() * size()));
    }

    public int size() {
        return first.size();
    }
}
