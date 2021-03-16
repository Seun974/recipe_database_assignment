package se.lexicon.samuel.recipe_database.data;

import org.springframework.transaction.annotation.Transactional;
import se.lexicon.samuel.recipe_database.entity.RecipeIngredient;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeIngredientDAORepository implements RecipeIngredientDAO{

    private EntityManager em;

    public RecipeIngredientDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeIngredient findById(Integer recipeIngredientId) {
        return em.find(RecipeIngredient.class, recipeIngredientId);

    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeIngredient> findAll() {
        return em
                .createQuery("SELECT recipeIngredient FROM RecipeIngredient recipeIngredient", RecipeIngredient.class)
                .getResultList();

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        em.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return em.merge(recipeIngredient);

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeIngredientId) {
        RecipeIngredient toDelete = findById(recipeIngredientId);
        if(recipeIngredientId != null){
            System.out.println("Recipe ingredient ID " + recipeIngredientId + " has been deleted.");
        }else{
            throw new IllegalArgumentException("Recipe ingredient ID cannot be found.");
        }
    }
}
