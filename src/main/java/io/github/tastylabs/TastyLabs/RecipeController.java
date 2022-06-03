package io.github.tastylabs.TastyLabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/")
    public ResponseEntity<Recipe> getAll() {
//        recipeService.add(new Recipe());
        return ResponseEntity.of(Optional.of(recipeService.list().get(0)));
    }
}
