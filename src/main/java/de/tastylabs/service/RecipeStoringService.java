package de.tastylabs.service;

import de.tastylabs.exception.InvalidRecipeException;
import de.tastylabs.exception.RecipeNotFoundException;
import de.tastylabs.list.RecipeList;
import de.tastylabs.repository.Recipe;
import de.tastylabs.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeStoringService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeStoringService.class);
    private final RecipeRepository recipeRepository;
    private final RecipeList recipeList;

    public RecipeStoringService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        this.recipeList = new RecipeList();
    }

    public Recipe get(String id) throws RecipeNotFoundException {
        LOGGER.debug("Searching for recipe with id {}", id);
        return recipeList.get(id);
    }

    public List<Recipe> search(String query) {
        LOGGER.debug("Searching for recipes matching with '" + query + "'");
        return recipeList.search(Arrays.asList(query.split(" ")));
    }

    public List<Recipe> getSuggestions() {
        LOGGER.debug("Getting suggestions");
        List<Recipe> result = new LinkedList<>();
        for (int i = 0; i < 25; i++) {
            result.add(recipeList.getRandom());
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public Recipe add(Recipe recipe) throws InvalidRecipeException {
        LOGGER.debug("Adding new recipe with the title " + recipe.getTitle());
        recipeList.add(recipe);
        return recipe;
    }
}
