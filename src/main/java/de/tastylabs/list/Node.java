package de.tastylabs.list;

import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.repository.Recipe;

import java.util.List;

public class Node extends ListElement{
    private final ListElement next;
    private final Recipe recipe;

    public Node(ListElement next, Recipe recipe) {
        // TODO: Initialise the class variables
        this.next = next;
        this.recipe = recipe;
        // Since the parameters and the class attributes have the same name, you have to use this for accessing the class attributes
        // e.g.: this.attribute = attribute;
    }

    @Override
    List<Recipe> search(List<String> query) {
        // TODO: Find all recipes containing any of the query words
        List<Recipe> result = next.search(query);
        // First, get the result of the search on the next element. (result = ...)
        // Then, check for each word in the query, if either the id, the title, the ingredients or the preparation contain this word. The logical or is in Java || . If so, add it to the result list.
        for (String word : query) {
            if (recipe.getId().contains(word) || recipe.getTitle().contains(word) || recipe.getIngredients().contains(word) || recipe.getPreparation().contains(word)) {
                result.add(recipe);
            }
        }
        return result;
    }

    @Override
    Recipe get(String id) throws RecipeNotFoundException {
        // TODO: Find the recipe with the id
        // Check if the id of the recipe equals (!) the id of the parameter
        // To test if a string is equal to another, please use the equals method.
        // If the recipe has not the equal id, return the result of the method call on the next list element
        if (recipe.getId().equals(id)) {
            return recipe;
        } else {
            return next.get(id);
        }
    }

    @Override
    Recipe get(int index) {
        // TODO: Find the recipe with this index
        // Return the recipe if the index is 0
        // Otherwise, return the result of the method call on the next list element, whereby the index is reduced by 1
        if (index == 0) {
            return recipe;
        } else {
            return next.get(index -1);
        }
    }

    @Override
    int size() {
        // TODO: Return the size of the list
        // This is always the size of the following element plus 1
        return next.size() + 1;
    }
}
