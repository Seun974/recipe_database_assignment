package se.lexicon.samuel.recipe_database.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.samuel.recipe_database.entity.Ingredient;

import javax.persistence.EntityManager;
import java.util.Collection;

public class IngredientDAORepository implements IngredientDAO{

    private EntityManager em;

    @Autowired
    public IngredientDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredient findById(Integer ingredientId) {
        return em.find(Ingredient.class, ingredientId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Ingredient> findAll() {
        return em
                .createQuery("SELECT ingredient FROM Ingredient ingredient", Ingredient.class)
                .getResultList();

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient create(Ingredient ingredient) {
        em.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient update(Ingredient ingredient) {
        return em.merge(ingredient);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer ingredientId) {
        Ingredient toDelete =findById(ingredientId);
        if(toDelete != null){
            em.remove(toDelete);
            System.out.println("Ingredient with ID " + ingredientId + " has been removed");
        }else{
            throw new IllegalArgumentException("Ingredient with ID " + ingredientId + " not found.");
        }
    }
}
