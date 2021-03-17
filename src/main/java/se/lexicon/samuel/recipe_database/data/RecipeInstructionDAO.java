package se.lexicon.samuel.recipe_database.data;

import se.lexicon.samuel.recipe_database.model.entity.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {

    RecipeInstruction findById(Integer recipeInstructionId);
    Collection<RecipeInstruction> findAll();
    RecipeInstruction create(RecipeInstruction recipeInstruction);
    RecipeInstruction update(RecipeInstruction recipeInstruction);
    void delete(Integer recipeInstructionId);


}
