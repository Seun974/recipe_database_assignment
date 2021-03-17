package se.lexicon.samuel.recipe_database.data;

import se.lexicon.samuel.recipe_database.model.entity.Recipe;

import java.util.Collection;

public interface RecipeDAO {
    Recipe findById(Integer recipeId);
    Collection<Recipe> findAll();
    Recipe create(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Integer recipeId);
}
