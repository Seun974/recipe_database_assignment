package se.lexicon.samuel.recipe_database.data;

import se.lexicon.samuel.recipe_database.entity.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {
    RecipeCategory findById(Integer recipeCategoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory update(RecipeCategory recipeCategory);
    void delete(Integer recipeCategoryId);
}
