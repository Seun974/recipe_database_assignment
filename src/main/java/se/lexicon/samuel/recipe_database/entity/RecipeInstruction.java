package se.lexicon.samuel.recipe_database.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeInstructionId;
    private String recipeInstruction;

    public RecipeInstruction(String recipeInstructionId, String recipeInstruction) {
        this.recipeInstructionId = recipeInstructionId;
        this.recipeInstruction = recipeInstruction;
    }

    public RecipeInstruction() {
    }

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(recipeInstructionId, that.recipeInstructionId) && Objects.equals(recipeInstruction, that.recipeInstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeInstructionId, recipeInstruction);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "recipeInstructionId='" + recipeInstructionId + '\'' +
                ", recipeInstruction='" + recipeInstruction + '\'' +
                '}';
    }
}
