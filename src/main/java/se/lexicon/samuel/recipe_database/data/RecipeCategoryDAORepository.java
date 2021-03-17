package se.lexicon.samuel.recipe_database.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.samuel.recipe_database.model.entity.RecipeCategory;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeCategoryDAORepository implements RecipeCategoryDAO{

    private EntityManager em;

    @Autowired
    public RecipeCategoryDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeCategory findById(Integer recipeCategoryId) {
        return em.find(RecipeCategory.class, recipeCategoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeCategory> findAll() {
        return em
                .createQuery("SELECT recipeCategory FROM RecipeCategory recipeCategory", RecipeCategory.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory create(RecipeCategory recipeCategory) {
         em.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return em.merge(recipeCategory);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeCategoryId) {
        RecipeCategory toDelete = findById(recipeCategoryId);
        if(recipeCategoryId != null){
            em.remove(toDelete);
            System.out.println("Recipe category with ID " + recipeCategoryId + " has been removed.");
        }
        throw new IllegalArgumentException("Recipe category " + recipeCategoryId + " Cannot be found");
    }
}
