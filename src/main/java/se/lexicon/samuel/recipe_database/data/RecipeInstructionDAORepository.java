package se.lexicon.samuel.recipe_database.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.samuel.recipe_database.entity.RecipeInstruction;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeInstructionDAORepository implements RecipeInstructionDAO{

    private EntityManager em;

    @Autowired
    public RecipeInstructionDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeInstruction findById(Integer recipeInstructionId) {
        return em.find(RecipeInstruction.class, recipeInstructionId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeInstruction> findAll() {
        return em
                .createQuery("SELECT recipeInstruction FROM RecipeInstruction recipeInstruction", RecipeInstruction.class)
                .getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        em.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return em.merge(recipeInstruction);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeInstructionId) {
        RecipeInstruction toDelete = findById(recipeInstructionId);
        if(toDelete != null){
            em.remove(toDelete);
            System.out.println("Recipe Instruction " + recipeInstructionId + " has been removed");
        }else{
            throw new IllegalArgumentException("Recipe Instruction with ID " + recipeInstructionId + " not found.");
        }
    }
}
