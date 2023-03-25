/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomasgusewelle.recipebox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates the Recipe object and all of it's needed fields and methods
 *
 * @author Thomas Gusewelle
 */

//TODO: Create edit recipe method

public class Recipe {

    private String recipeName;
    private int servings;
    private ArrayList<Ingredient> recipeIngredients;
    private double totalRecipeCalories;
    private Scanner scnr = new Scanner(System.in);

   
    /**
     *
     */
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<Ingredient>();
        this.totalRecipeCalories = 0.0;
    }

    // Field member accessor and mutators
    /**
     * @return the recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * @param recipeName the recipeName to set
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * @return the servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * @param servings the servings to set
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * @return the recipeIngredients
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * @param recipeIngredients the recipeIngredients to set
     */
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * @return the totalRecipeCalories
     */
    public double getTotalRecipeCalories() {
        return totalRecipeCalories;
    }

    /**
     * @param totalRecipeCalories the totalRecipeCalories to set
     */
    public void setTotalRecipeCalories(double totalRecipeCalories) {
        this.totalRecipeCalories = totalRecipeCalories;
    }

    // User defined methods
    /**
     * Loops through the ingredients and adds their cost together returning
     * total cost.
     *
     * @return Total recipe cost
     */
    public float calcTotalCost() {
        float cost = 0.0f;
        for (int i = 0; i < recipeIngredients.size(); i++) {
            cost += recipeIngredients.get(i).getCost();
        }

        return cost;
    }

    /**
     * Prints out the details of the a recipe
     */
    public void printRecipe() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Recipe name: " + getRecipeName());
        System.out.println("Servings: " + getServings());
        System.out.println("Total Cost: $" + df.format(calcTotalCost()));
        System.out.println("Ingredients");
        for (int i = 0; i < recipeIngredients.size(); i++) {
            Ingredient ingredient = recipeIngredients.get(i);
            System.out.println("Name: " + ingredient.getNameIngredient() + " Cups: " + ingredient.getNumCups() + " Total Calories: " + ingredient.getTotalCalories());
        }

    }

    /**
     * Takes input and sets name, servings, and creates the ingredients for the
     * recipe
     *
     * @return new Recipe object
     */
    public Recipe createNewRecipe() {
        Recipe recipe = new Recipe();
        while (recipe.recipeName.trim().length() <= 0) {
            System.out.println("Please enter a name for the recipe.");
            String _name = scnr.nextLine();
            if (_name.trim().length() == 0) {
                System.out.println("Please enter a valid name");
            } else {
                recipe.setRecipeName(_name);
            }
        };

        while (recipe.servings <= 0) {
            System.out.println("Please enter the number of servings the recipe makes:");
            int _servings = scnr.nextInt();
            if (_servings <= 0) {
                System.out.println("Please enter a valid number.");
            } else {
                recipe.setServings(_servings);
            }
        }
        System.out.println("You will now input the ingredients for the recipe");
        boolean inputIngredients = true;
        while (inputIngredients) {
            Ingredient _ing = new Ingredient();
            _ing.createIngredient(_ing);
            recipe.recipeIngredients.add(_ing);
            System.out.println("Would you like to enter another ingredient? (y or n)");
            String _input = scnr.next();
            if (_input.toLowerCase().equals("n")) {
                inputIngredients = false;
            }
        }
        return recipe;

    }

}
