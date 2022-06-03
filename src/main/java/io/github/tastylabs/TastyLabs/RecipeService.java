package io.github.tastylabs.TastyLabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> list() {
        return recipeRepository.findAll();
    }

    public Recipe add(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
