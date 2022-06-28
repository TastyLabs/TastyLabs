package de.tastylabs.service;

import de.tastylabs.exception.InvalidRecipeException;
import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.list.RecipeList;
import de.tastylabs.repository.Recipe;
import de.tastylabs.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeStoringService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeStoringService.class);
    private final RecipeRepository recipeRepository;
    private final RecipeList list;

    public RecipeStoringService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        this.list = new RecipeList();
        // Initialise the list with the DB data
    }

    public Recipe get(String id) throws RecipeNotFoundException {
        LOGGER.debug("Searching for recipe with id {}", id);
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException("No recipe found with id " + id));
        // TODO: Load the recipe with the id from the list.
//        return null;
    }

    public List<Recipe> search(String query) {
        LOGGER.debug("Searching for recipes matching with '" + query + "'");
        String[] words = query.split(" ");
        List<Recipe> result = new LinkedList<>();
        List<Recipe> recipes = recipeRepository.findAll();
        for (String word : words) {
            for (Recipe recipe : recipes) {
                if (recipe.getId().contains(word) || recipe.getTitle().contains(word) || recipe.getIngredients().contains(word) || recipe.getPreparation().contains(word)) {
                    result.add(recipe);
                }
            }
        }
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
        // TODO: Return a list of recipes which match the query
//        return null;
    }

    public List<Recipe> getSuggestions() {
        LOGGER.debug("Getting suggestions");
        return recipeRepository.findAll();
        // TODO: Return a list of some random recipes.
//        return null;
    }

    public Recipe add(Recipe recipe) throws InvalidRecipeException {
        LOGGER.debug("Adding new recipe with the title " + recipe.getTitle());
        // TODO: Check the recipe contains no illegal words.
        recipeRepository.save(recipe);
        System.out.println(recipeRepository.findAll());
        // TODO: Add the recipe to the list.
        return recipe;
    }
}
