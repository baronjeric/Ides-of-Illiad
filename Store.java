import java.util.Random;
import java.util.Scanner;

public class Store
{
    Hero hero1;
    
    int response;
    int response2;
    
    int qtyPurchased;
    String itemPurchased;
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    //the showInventory would come off of any vendor class. Laurel, as a healer, has 3 variables in her class that show itemnames, item qty, item price
    public void showInventory(String itemNames[], int itemQty[], int itemPrice[])
    {
       Scanner input = new Scanner(System.in); 
        
       for(int counter = 0; counter < itemNames.length; counter++)
       {
          System.out.print("Enter " + counter + " : ");
          System.out.print("Item Name: " + itemNames[counter]+ " ");
          System.out.print(" Item Qty: " + itemQty[counter]+ " ");
          System.out.print(" Item Price: " + itemPrice[counter]+ " ");
          System.out.println(" ");
       }
 
       response = input.nextInt();
       
       System.out.println("How many " + itemNames[response] + " would you like?");
       
       response2 = input.nextInt();
       
       if(response2 > itemQty[response])
       {
           System.out.println("The vendor does not have enough inventory.");
       }
       else if(hero1.gold < itemPrice[response] * response2)
       {
           System.out.println("You do not have enough gold.");
       }
       else
       {
           itemQty[response] = itemQty[response] - response2;
           System.out.println("You purchased " + response2 + " " + itemNames[response] + "!");
           qtyPurchased = response2;
           itemPurchased = itemNames[response];
           hero1.changeGold(-itemPrice[response] * response2);
           System.out.println("Your remaining gold is: " + hero1.gold);

        }

    }
    
    public void addStoreInventoryConsumable(int itemQty[])
    {
        Random dice = new Random();
        
        for(int counter = 0; counter < itemQty.length; counter++)
        {
            
            int roll = dice.nextInt(8)+5;
            itemQty[counter] = itemQty[counter] + roll;
            
        }
    }
    
    public void addStoreInventoryWeapons(int itemQty[])
    {
        Random dice = new Random();
        
        for(int counter = 0; counter < itemQty.length; counter++)
        {
            
            int roll = dice.nextInt(3)+1;
            itemQty[counter] = itemQty[counter] + roll;
            
        }
    }
    
}
       