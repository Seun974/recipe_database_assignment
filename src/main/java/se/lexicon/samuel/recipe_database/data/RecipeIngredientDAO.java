package se.lexicon.samuel.recipe_database.data;

import se.lexicon.samuel.recipe_database.entity.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO {
    RecipeIngredient findById(Integer recipeIngredientId);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient create(RecipeIngredient recipeIngredient);
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    void delete(Integer recipeIngredientId);
}
