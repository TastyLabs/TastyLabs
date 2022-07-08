package de.tastylabs.controller;

import de.tastylabs.exception.InvalidRecipeException;
import de.tastylabs.exception.ElementNotFoundException;
import de.tastylabs.repository.Recipe;
import de.tastylabs.service.RecipeStoringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RecipeController {
    private final RecipeStoringService recipeStoringService;

    public RecipeController(RecipeStoringService recipeStoringService) {
        this.recipeStoringService = recipeStoringService;
    }

    @GetMapping("/")
    public String getSuggestions(Model model) {
        model.addAttribute("recipes", recipeStoringService.getSuggestions());
        return "list";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam("q") String query) {
        model.addAttribute("recipes", recipeStoringService.search(query));
        return "list";
    }

    @GetMapping("/recipe/{id}")
    public String getRecipe(Model model, @PathVariable String id) throws ElementNotFoundException {
        model.addAttribute("recipe", recipeStoringService.get(id));
        return "detail";
    }

    @PostMapping("/create")
    public void create(@RequestParam String title, @RequestParam String ingredients, @RequestParam String preparation, HttpServletRequest request, HttpServletResponse response) throws InvalidRecipeException {
        Recipe recipe = new Recipe(title, ingredients, preparation, request.getRemoteAddr());
        recipeStoringService.add(recipe);
        response.setHeader("Location", "/recipe/" + recipe.getId());
        response.setStatus(303);
    }
}
