/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.thomasgusewelle.recipebox;

import java.util.ArrayList;
import java.util.Scanner;
//import com.thomasgusewelle.Ingredient;

/**
 * Program that creates a recipe box and allows users to create and delete
 * recipes in the recipe box.
 *
 * @author prestonhollow
 */
public class RecipeBox {

    private ArrayList<Recipe> listOfRecipes;

    /**
     * @return the listOfRecipes
     */
    public ArrayList<Recipe> getListOfRecipes() {
        return listOfRecipes;
    }

    /**
     * @param listOfRecipes the listOfRecipes to set
     */
    public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }

    // Constructor
    /**
     *
     */
    public RecipeBox() {
        this.listOfRecipes = new ArrayList<Recipe>();
    }

    // User Methods
    /**
     * Prints the details of the provided recipe
     *
     * @param selectedRecipe
     */
    public void printAllRecipeDetails(Recipe selectedRecipe) {
        selectedRecipe.printRecipe();
    }

    /**
     * Loops over recipe list and prints all of the names of the recipes
     */
    public void printAllRecipeNames() {
        for (int i = 0; i < getListOfRecipes().size(); i++) {
            System.out.println(getListOfRecipes().get(i).getRecipeName());
        }
    }

    /**
     * Instantiates a new recipe, gets all of its details, and adds it to the
     * recipe box ArrayList
     */
    public void addNewRecipe() {
        Recipe recipe = new Recipe().createNewRecipe();
        getListOfRecipes().add(recipe);
    }

    /**
     * Removes the first instance of the provided recipe from the listOfRecipes
     *
     * @param recipe
     */
    public void deleteRecipe(Recipe recipe) {
//        int index = listOfRecipes.indexOf(recipe);
        this.listOfRecipes.remove(recipe);
    }

    /**
     * Creates a recipe box and provides the menu options for user input
     *
     * @param args
     */
//    TODO: Implement ability to edit recipe
    public static void main(String[] args) {
        // Create a Recipe Box

        RecipeBox myRecipeBox = new RecipeBox();
        Scanner menuScnr = new Scanner(System.in);

        /**
         * Print a menu for the user to select one of the two options if the
         * list is empty or one of five options is the ArrayList.size() >= 1:
         *
         */
        if (myRecipeBox.listOfRecipes.size() <= 0) {
            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Close App
                           
                           Please select a menu item:""");
        } else {
            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Print a Recipe's Details
                           3. Print All Recipe Names
                           4. Delete a Recipe
                           5. Close App
                           
                           Please select a menu item:""");
        }
        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
//            
            int input = menuScnr.nextInt();
            if (myRecipeBox.listOfRecipes.size() <= 0) {

                switch (input) {
                    case 1 ->
                        myRecipeBox.addNewRecipe();

                    case 2 -> {
                        System.exit(0);
                    }
                    default -> {
                        if (myRecipeBox.listOfRecipes.size() <= 0) {
                            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Close App
                           
                           Please select a menu item:""");
                        } else {
                            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Print a Recipe's Details
                           3. Print All Recipe Names
                           4. Delete a Recipe
                           5. Close App
                           
                           Please select a menu item:""");
                        }
                    }

                }
            } else {
                switch (input) {
                    case 1 ->
                        myRecipeBox.addNewRecipe();
                    case 2 -> {
                        System.out.println("Which recipe? Select the number from the list.\n");
                        for (int i = 0; i < myRecipeBox.getListOfRecipes().size(); i++) {
                            System.out.println((i + 1) + ": " + myRecipeBox.getListOfRecipes().get(i).getRecipeName());
                        }
                        int selectedRecipeNum = menuScnr.nextInt();
                        myRecipeBox.printAllRecipeDetails(myRecipeBox.getListOfRecipes().get(selectedRecipeNum - 1));
                    }
                    case 3 -> {
                        for (int j = 0; j < myRecipeBox.getListOfRecipes().size(); j++) {
                            System.out.println((j + 1) + ": " + myRecipeBox.getListOfRecipes().get(j).getRecipeName());
                        }
                    }
                    case 4 -> {
                        System.out.println("Which recipe? Select the number from the list.\n");
                        for (int i = 0; i < myRecipeBox.getListOfRecipes().size(); i++) {
                            System.out.println((i + 1) + ": " + myRecipeBox.getListOfRecipes().get(i).getRecipeName());
                        }
                        int selectedRecipeNum = menuScnr.nextInt();
                        myRecipeBox.deleteRecipe(myRecipeBox.listOfRecipes.get(selectedRecipeNum - 1));
                    }
                    case 5 -> {
                        System.exit(0);
                    }
                    default -> {
                        if (myRecipeBox.listOfRecipes.size() <= 0) {
                            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Close App
                           
                           Please select a menu item:""");
                        } else {
                            System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Print a Recipe's Details
                           3. Print All Recipe Names
                           4. Delete a Recipe
                           5. Close App
                           
                           Please select a menu item:""");
                        }
                    }

                }
            }
            if (myRecipeBox.listOfRecipes.size() <= 0) {
                System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Close App
                           
                           Please select a menu item:""");
            } else {
                System.out.println("""
                           Menu
                           1. Add Recipe
                           2. Print a Recipe's Details
                           3. Print All Recipe Names
                           4. Delete a Recipe
                           5. Close App
                           
                           Please select a menu item:""");
            }

        }

    }

}
