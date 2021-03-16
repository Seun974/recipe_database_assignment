package se.lexicon.samuel.recipe_database.data;

import se.lexicon.samuel.recipe_database.entity.Ingredient;

import java.util.Collection;

public interface IngredientDAO {
    Ingredient findById(Integer ingredientId);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Integer ingredientId);



}
