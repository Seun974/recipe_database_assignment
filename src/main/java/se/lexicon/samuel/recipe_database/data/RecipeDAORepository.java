package se.lexicon.samuel.recipe_database.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.samuel.recipe_database.model.entity.Recipe;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeDAORepository implements RecipeDAO{

    private EntityManager em;
    @Autowired
    public RecipeDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public Recipe findById(Integer recipeId) {
        return em.find(Recipe.class, recipeId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Recipe> findAll() {
        return em
                .createQuery("SELECT recipe FROM Recipe recipe", Recipe.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe create(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe update(Recipe recipe) {
        return em.merge(recipe);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeId) {
        Recipe toDelete = findById(recipeId);
        if(recipeId != null){
            em.remove(toDelete);
            System.out.println("Recipe with Id " + recipeId + " has been removed.");
        }else{
            throw new IllegalArgumentException("Recipe with Id " + recipeId + "not found.");
        }
    }
}
