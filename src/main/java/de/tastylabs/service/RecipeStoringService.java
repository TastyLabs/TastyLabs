package de.tastylabs.service;

import de.tastylabs.exception.InvalidRecipeException;
import de.tastylabs.exception.ElementNotFoundException;
import de.tastylabs.list.DataElement;
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

        LOGGER.debug("Loading recipes from DB into list");
        List<Recipe> recipes = recipeRepository.findAll();
        for(Recipe recipe : recipes) {
            recipeList.add(recipe);
        }
        LOGGER.debug("Done!");
    }

    public DataElement get(String id) throws ElementNotFoundException {
        LOGGER.debug("Searching for recipe with id {}", id);
        return recipeList.get(id);
    }

    public List<DataElement> search(String query) {
        LOGGER.debug("Searching for recipes matching with '" + query + "'");
        return recipeList.search(Arrays.asList(query.split(" ")));
    }

    public List<DataElement> getSuggestions() {
        LOGGER.debug("Getting suggestions");
        List<DataElement> result = new LinkedList<>();
        for (int i = 0; i < 25; i++) {
            result.add(recipeList.getRandom());
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    public Recipe add(Recipe recipe) throws InvalidRecipeException {
        LOGGER.debug("Adding new recipe with the title " + recipe.getTitle());
        recipeRepository.save(recipe);
        recipeList.add(recipe);
        return recipe;
    }
}
