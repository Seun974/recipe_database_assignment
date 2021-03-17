package se.lexicon.samuel.recipe_database.model.entity;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.samuel.recipe_database.model.misc.Measurement;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientId;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "ingredient_id", table = "ingredient")
    private Ingredient ingredient;

    private double amount;

    private Measurement measurement;

    @ManyToOne(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "recipe_id", table = "recipes")
    private Recipe recipes;

    public RecipeIngredient(String recipeIngredientId, Ingredient ingredient, double amount, Measurement measurement, Recipe recipes) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipes = recipes;
    }
    //constructor takes only the enum and the Recipe entity
    public RecipeIngredient(Measurement measurement, Recipe recipes) {
        this.measurement = measurement;
        this.recipes = recipes;
    }

    public RecipeIngredient() {
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipe) {
        this.recipes = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(recipeIngredientId, that.recipeIngredientId) && Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientId, ingredient, amount);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                '}';
    }
}
