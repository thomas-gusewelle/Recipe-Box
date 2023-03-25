/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomasgusewelle.recipebox;

import java.util.Scanner;

/**
 * Ingredient class that defines the name, cups,
 * caloriesPerCup, and total calories of an ingredient for a recipe. Contains
 * methods to set and get all values with validation included on all setting
 * methods.
 * @author Thomas Gusewelle
 */
public class Ingredient {

    private String nameIngredient;
    private float numCups;
    private float numCaloriesPerCup;
    private double totalCalories;
    private float cost;

    Scanner scrn = new Scanner(System.in);

    //Constructor
    /**
     *
     */
    public Ingredient() {
        nameIngredient = "";
        numCups = 0.0f;
        numCaloriesPerCup = 0.0f;
        totalCalories = 0.0;
        cost = 0.0f;
    }

    // User Methods
    /**
     *
     * @return Ingredient name
     */
    public String getNameIngredient() {
        return nameIngredient;
    }

    /**
     * Takes user input and sets the name of the ingredient
     */
    public void setIngredientName() {
        String _name;

        do {
            System.out.println("Please enter the name of the ingredient");
            _name = scrn.nextLine().trim();
            if (_name.length() > 0) {
                nameIngredient = _name;
            } else {
                System.out.print("No name entered. ");
            }

        } while (_name.length() == 0);

    }

    /**
     *
     * @return The number of cups of the ingredient
     */
    public float getNumCups() {
        return numCups;
    }

    // TODO: Expand to inlcude other measurement types. i.e. tbsp and tsp    
    /**
     * Takes and validates user input and sets numCups. Input is constrained to
     * 0 -100
     */
//    used float rather than int because num of cups can be a decimal point but not more than 2 decimal places
    public void setNumCups() {
        float _numCups;

        do {
            System.out.println("Please enter the number of cups required for this ingredient (0-100)");
            _numCups = scrn.nextFloat();
            if (_numCups < 100.0 && _numCups > 0.0) {
                numCups = _numCups;
            } else {
                System.out.println("Please enter a valid number of cups between 0 and 100");
            }
        } while (_numCups >= 100.0 || _numCups <= 0.0);
    }

    /**
     * Takes and validates input to set the number of calories per cup of
     * ingredient. Input is constrained to 0 - 10,000
     */
    public void setNumCaloriesPerCup() {
        float _numCaloriesPerCup;

        do {
            System.out.println("Please enter the number of calories per cup for this ingredient (0-10000)");
            _numCaloriesPerCup = scrn.nextFloat();
            if (_numCaloriesPerCup < 10000 && _numCaloriesPerCup > 0) {
                numCaloriesPerCup = _numCaloriesPerCup;

                setTotalCalories();
            } else {
                System.out.println("Please enter a valid number of calories between 0 and 10000");
            }

        } while (_numCaloriesPerCup <= 0.0 || _numCaloriesPerCup >= 10000.0);
    }

    /**
     *
     * @return The number of calories per cup
     */
    public float getNumCaloriesPerCup() {
        return numCaloriesPerCup;
    }

    // private method that sets total calories. Only called in setNumCaloriesPerCup(). 
    //    Checks to make sure no value is 0 first.
    private void setTotalCalories() {
        if (numCaloriesPerCup > 0 && numCups > 0) {
            totalCalories = numCaloriesPerCup * numCups;
        } else {
            if (numCaloriesPerCup <= 0) {
                setNumCaloriesPerCup();
            }
            if (numCups <= 0) {
                setNumCups();
            }
        }

    }

    /**
     *
     * @return Cost of ingredient
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Takes user input and sets the cost of the ingredient
     */
//    used float because of currency restriction to two decimal places
    public void setCost() {
        while (this.cost == 0.0f) {
            System.out.println("Please enter the cost of the ingredient");
            float _cost = scrn.nextFloat();
            if (_cost <= 0.0f) {
                System.out.println("Please enter a valid cost above $0.00");
            } else {
                this.cost = _cost;
            }
        }
    }

    /**
     *
     * @return Total calories of an ingredient
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     * Wrapper method that takes in ingredient object and prompts for details
     *
     * @param ing of type Ingredient
     */
    public void createIngredient(Ingredient ing) {

        ing.setIngredientName();
        ing.setNumCups();
        ing.setNumCaloriesPerCup();
        ing.setCost();
    }
}
