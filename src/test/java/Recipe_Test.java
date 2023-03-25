
import com.thomasgusewelle.recipebox.Recipe;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author prestonhollow
 */
public class Recipe_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Testing user inputs. You should see your recipe printed out after answering the prompts");
        Recipe recipe = new Recipe().createNewRecipe();
        recipe.printRecipe();

        

      
        
    }
    
}
