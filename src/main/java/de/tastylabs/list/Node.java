package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class Node extends ListElement{
    private final ListElement next;
    private final Recipe recipe;

    public Node(ListElement next, Recipe recipe) {
        this.next = next;
        this.recipe = recipe;
    }

    @Override
    List<Recipe> search(List<String> query) {
        List<Recipe> result = next.search(query);
        for (String word : query) {
            if (recipe.getId().contains(word) || recipe.getTitle().contains(word) || recipe.getIngredients().contains(word) || recipe.getPreparation().contains(word)) {
                result.add(recipe);
            }
        }
        return result;
    }

    @Override
    Recipe get(String id) throws RecipeNotFoundException {
        if (recipe.getId().equals(id)) {
            return recipe;
        } else {
            return next.get(id);
        }
    }

    @Override
    Recipe get(int index) {
        if (index == 0) {
            return recipe;
        } else {
            return next.get(index -1);
        }
    }

    @Override
    int size() {
        return next.size() + 1;
    }
}
