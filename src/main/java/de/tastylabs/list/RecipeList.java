package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class RecipeList {
    ListElement first;

    public RecipeList() {
        // TODO: Initialise the first attribute
    }

    public void add(Recipe recipe) {
        // TODO: Add new recipe to the list
    }

    public List<Recipe> search(List<String> query) {
        // TODO: Return the result of the method call on the first list element
        return null;
    }

    public Recipe get(String id) throws RecipeNotFoundException {
        // TODO: Return the result of the method call on the first list element
        return null;
    }

    public Recipe get(int index) {
        // TODO: First check, if the index is greater then or equal to the list size
        if (true) {
            throw new IndexOutOfBoundsException();
        } else {
            // TODO: Return the result of the method call on the first list element
            return null;
        }
    }

    public Recipe getRandom() {
        // TODO: Return a random recipe
        // Tip: To get a random index use: (int) (Math.random() * size())
        // Math.random() will generate a random number between 0 and 1, which is multiplied with the size a random index.
        // (int) means, that the double is then casted to a int value.
        return null;
    }

    public int size() {
        // TODO: Return the result of the method call on the first list element
        return 0;
    }
}
