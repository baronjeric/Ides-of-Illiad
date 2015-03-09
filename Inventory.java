import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory
{
    ArrayList<Integer> listInt = new ArrayList<Integer>();
    ArrayList<String> listString = new ArrayList<String>();
    
    int counter = 0;
    int i = 0;
    int holder;
    int response;
    int consumableCheck = 0;
    int itemSold = 0;
    
    Item item;
    Hero hero1;
    
    Scanner input = new Scanner(System.in);
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void passItem(Item item)
    {
        this.item = item;
    }
    
    public void addToInv(String itemNames, int itemQty)
    {
        //check to see if there was a null drop
        if(itemNames == "")
        {
        }
        else
        {

        
            //checking to see if the item is in the list
            for(i = 0; i<listString.size(); i++)
            {
                if(listString.get(i) == itemNames)
                {
                    counter++;
                    holder = i;
                    break;
                }
                        
            }
            
            if(counter > 0) //greater than 0 means its on the list. No need to add the string. Just the qty.
            {
                listInt.set(holder,listInt.get(holder) + itemQty);
                counter = counter * 0;
                i = i * 0;
                holder = holder * 0;
            }
            else
            {
                listString.add(itemNames);
                listInt.add(itemQty);
                i = i * 0;
                holder = holder * 0;
            }
            
        
        }
    }
    
    public void showHeroInv()
    {
        
        System.out.println("Your inventory is: ");
        for(i = 0; i<listInt.size(); i++)
        {
            System.out.println("Item Name: " + listString.get(i) + " Qty Remaining: " + listInt.get(i));
        }
        
        
    }
    
    public int showHeroInvConsume()
    {
        System.out.println("Inventory Listing: ");
        
        
        if(listString.size() == 0)
        {
            System.out.println("You have nothing in inventory.");
            return 0;
        }
        else
        {
            
            for(i = 0; i<listInt.size(); i++)
            {
                System.out.println("Enter: " + i + " for " + listString.get(i) + "." + " Qty Remaining: " + listInt.get(i));
            }
        }
        response = input.nextInt();
        
        //need to check if the item is consumable
        for(int y = 0; y<item.consumableItems.length; y++)
        {
            if(listString.get(response) == item.consumableItems[y])
            {
                consumableCheck++;
                
            }

       
        }
        
        if(consumableCheck > 0)
        {
            System.out.println("You have consumed a " + listString.get(response) + "!");
            item.itemMgr(listString.get(response));
            useInventory(listString.get(response));
            Main.pause();
            
        }
        else
        {
            System.out.println(listString.get(response));
            System.out.println("That item is not consumable.");
            Main.pause();
        
        }
        consumableCheck = consumableCheck * 0;
        return 1;
    }
    
    public void useInventory(String itemNames)
    {
        for(i = 0; i<listString.size(); i++)
        {
            if(listString.get(i) == itemNames)
            {
                holder = i;
                listInt.set(i,listInt.get(i) - 1);
                break;
            }
                    
        }
        
        if(listInt.get(holder) == 0)
        {
            listString.remove(holder);
            listInt.remove(holder);
            i = i * 0;
            holder = holder * 0;
        }
      
    }
    
    public void showWeapon()
    {
        int check = 0;
        int numberHolder = 0;
        
        ArrayList<String> tempWeap = new ArrayList<String>();
        
        //This cycles through every item in hero inventory to see if it matches ANY item in the weapon array. If there is a match it is added to a temporary arraylist
        for(int a = 0; a < listString.size(); a++)
        {
            for(int b = 0; b < item.weapons.length; b++)
            {
                if(listString.get(a) == item.weapons[b])
                {
                    
                    tempWeap.add(listString.get(a));
                    check++;
                }        
                
            }

        }

        //this checks to see if there are ANY wepaons. If there were, it prints out the temporary list of weapons.
        if(check == 0)
        {
            System.out.println("You have no weapons in inventory.");
            Main.pause();
        }
        else
        {
            System.out.println("Which of the following weapons would you like to equip?");
            for(int c = 0; c < tempWeap.size(); c++)
            {
                System.out.println("Enter: " + c + " for " + tempWeap.get(c));
            }
        
        
            int response2 = input.nextInt();
            
            //After calling for UI, searches array of weapons to add the attack of that weapon to the heroes attack. 
            for(int d = 0; d < item.weapons.length; d++)
            {
                if(tempWeap.get(response2) == item.weapons[d])
                {
                    hero1.characterAbilInt[1] = 2 + item.weaponsDmg[d];
                    System.out.println("Your damage is now: " + hero1.characterAbilInt[1]);
                    Main.pause();
                    break;
                }
            }
            
        
        
        }
        
        check = check * 0;
        numberHolder = numberHolder * 0;
        
    }
    
    public void showArmorHead()
    {
        int check = 0;
        int numberHolder = 0;
        
        ArrayList<String> tempArmorHead = new ArrayList<String>();
        
        //This cycles through every item in hero inventory to see if it matches ANY item in the weapon array. If there is a match it is added to a temporary arraylist
        for(int a = 0; a < listString.size(); a++)
        {
            for(int b = 0; b < item.armorHead.length; b++)
            {
                if(listString.get(a) == item.armorHead[b])
                {
                    
                    tempArmorHead.add(listString.get(a));
                    check++;
                }        
                
            }

        }

        //this checks to see if there are ANY wepaons. If there were, it prints out the temporary list of weapons.
        if(check == 0)
        {
            System.out.println("You have no head Armor in inventory.");
            Main.pause();
        }
        else
        {
            System.out.println("Which of the following Head Armor pieces would you like to equip?");
            for(int c = 0; c < tempArmorHead.size(); c++)
            {
                System.out.println("Enter: " + c + " for " + tempArmorHead.get(c));
            }
        
        
            int response2 = input.nextInt();
            
            //After calling for UI, searches array of weapons to add the attack of that weapon to the heroes attack. 
            for(int d = 0; d < item.armorHead.length; d++)
            {
                if(tempArmorHead.get(response2) == item.armorHead[d])
                {
                    hero1.characterAbilInt[3] = 0 + item.armorHeadProt[d];
                    System.out.println("Your Head Armor is now: " + (hero1.characterAbilInt[3]));
                    Main.pause();
                    break;
                }
            }
            
        }
        
        check = check * 0;
        numberHolder = numberHolder * 0;
        
    }
    
    public void showArmorChest()
    {
        int check = 0;
        int numberHolder = 0;
        
        ArrayList<String> tempArmorChest = new ArrayList<String>();
        
        //This cycles through every item in hero inventory to see if it matches ANY item in the weapon array. If there is a match it is added to a temporary arraylist
        for(int a = 0; a < listString.size(); a++)
        {
            for(int b = 0; b < item.armorChest.length; b++)
            {
                if(listString.get(a) == item.armorChest[b])
                {
                    
                    tempArmorChest.add(listString.get(a));
                    check++;
                }        
                
            }

        }

        //this checks to see if there are ANY wepaons. If there were, it prints out the temporary list of weapons.
        if(check == 0)
        {
            System.out.println("You have no Chest Armor in inventory.");
            Main.pause();
        }
        else
        {
            System.out.println("Which of the following Chest Armor pieces would you like to equip?");
            for(int c = 0; c < tempArmorChest.size(); c++)
            {
                System.out.println("Enter: " + c + " for " + tempArmorChest.get(c));
            }
        
        
            int response2 = input.nextInt();
            
            //After calling for UI, searches array of weapons to add the attack of that weapon to the heroes attack. 
            for(int d = 0; d < item.armorChest.length; d++)
            {
                if(tempArmorChest.get(response2) == item.armorChest[d])
                {
                    hero1.characterAbilInt[4] = 0 + item.armorChestProt[d];
                    System.out.println("Your Chest Armor is now: " + (hero1.characterAbilInt[4]));
                    Main.pause();
                    break;
                }
            }
            
        }
        
        check = check * 0;
        numberHolder = numberHolder * 0;
        
    }
    
    public void showArmorFeet()
    {
        int check = 0;
        int numberHolder = 0;
        
        ArrayList<String> tempArmorFeet = new ArrayList<String>();
        
        //This cycles through every item in hero inventory to see if it matches ANY item in the weapon array. If there is a match it is added to a temporary arraylist
        for(int a = 0; a < listString.size(); a++)
        {
            for(int b = 0; b < item.armorFeet.length; b++)
            {
                if(listString.get(a) == item.armorFeet[b])
                {
                    
                    tempArmorFeet.add(listString.get(a));
                    check++;
                }        
                
            }

        }

        //this checks to see if there are ANY wepaons. If there were, it prints out the temporary list of weapons.
        if(check == 0)
        {
            System.out.println("You have no feet Armor in inventory.");
            Main.pause();
        }
        else
        {
            System.out.println("Which of the following Feet Armor pieces would you like to equip?");
            for(int c = 0; c < tempArmorFeet.size(); c++)
            {
                System.out.println("Enter: " + c + " for " + tempArmorFeet.get(c));
            }
        
        
            int response2 = input.nextInt();
            
            //After calling for UI, searches array of weapons to add the attack of that weapon to the heroes attack. 
            for(int d = 0; d < item.armorFeet.length; d++)
            {
                if(tempArmorFeet.get(response2) == item.armorFeet[d])
                {
                    hero1.characterAbilInt[5] = 0 + item.armorFeetProt[d];
                    System.out.println("Your feet Armor is now: " + (hero1.characterAbilInt[5]));
                    Main.pause();
                    break;
                }
            }
            
        }
        
        check = check * 0;
        numberHolder = numberHolder * 0;
        
    }
    
    public void showHeroInvSellTradable(int vendorGold, String vendorName)
    {
        int tempHolder = 0;
        int sellValue = 0;
        
        System.out.println("Inventory Listing: ");
        
        //check to see if there is anything in inventory
        if(listString.size() == 0)
        {
            System.out.println("You have nothing in inventory.");
            
        }
        else
        {
            
            for(i = 0; i<listInt.size(); i++)
            {
                System.out.println("Enter: " + i + " for " + listString.get(i) + "." + " Qty Remaining: " + listInt.get(i));
            }
        
           
            System.out.println("Which item would you like to sell?");
            
            int response3 = input.nextInt();
            
            System.out.println(vendorName + " examines the " + listString.get(response3) + " carefully.");
            
            //need to check if the item is tradable
            for(int y = 0; y<item.tradableItems.length; y++)
            {
                if(listString.get(response3) == item.tradableItems[y])
                {
                    consumableCheck++;
                    break;
                }
                
            }
            
            if(consumableCheck > 0)
            {
                
                //need to check what the item will sell for
                for(int a = 0; a < item.tradableItems.length; a++)
                {
                    if(listString.get(response3) == item.tradableItems[a])
                    {
                        tempHolder = tempHolder + item.tradableItemsSell[a];
                 
                    }
                    
                  
                }

                Main.pause();
                
                System.out.println("How many would you like to sell?");
                
                int response4 = input.nextInt();
                
                //check if there's enough qty
                if(response4 > listInt.get(response3))
                {
                    System.out.println("You do not have enough in inventory to sell.");
                }
                else
                {
                    sellValue = (tempHolder * response4);
                    System.out.println("I can offer you: " + sellValue + " gold for your " + listString.get(response3));
                    Main.pause();
                    System.out.println("Is this acceptable?");
                    System.out.println("Enter: 0 for YES");
                    System.out.println("Enter: 1 for NO");
       
                    int response5 = input.nextInt();
                    
                    if(response5 == 0)
                    {
                        hero1.gold = hero1.gold + sellValue;
                        useInventory(listString.get(response3));
                        System.out.println("You now have " + hero1.gold + " gold.");
                        Main.pause();
                        
                    }
                    else
                    {
                        System.out.println("Suit yourself, " + vendorName + " mutters.");
                    }
                       
      
               
                }
            }
            else
            {
                System.out.println("I have no interest in buying that unfortunately.");
                Main.pause();
                
            }
            
            consumableCheck = consumableCheck * 0;
        }
    }
    
    public void showHeroInvSellWeaps(int vendorGold, String vendorName)
    {
        int tempHolder = 0;
        int sellValue = 0;
        
        System.out.println("Inventory Listing: ");
        
        //check to see if there is anything in inventory
        if(listString.size() == 0)
        {
            System.out.println("You have nothing in inventory.");
            
        }
        else
        {
            
            for(i = 0; i<listInt.size(); i++)
            {
                System.out.println("Enter: " + i + " for " + listString.get(i) + "." + " Qty Remaining: " + listInt.get(i));
            }
        
           
            System.out.println("Which item would you like to sell?");
            
            int response3 = input.nextInt();
            
            System.out.println(vendorName + " examines the " + listString.get(response3) + " carefully.");
            
            //need to check if the item is tradable
            for(int y = 0; y<item.sellableWeapons.length; y++)
            {
                if(listString.get(response3) == item.sellableWeapons[y])
                {
                    consumableCheck++;
                    break;
                }
                
            }
            
            if(consumableCheck > 0)
            {
                
                //need to check what the item will sell for
                for(int a = 0; a < item.sellableWeapons.length; a++)
                {
                    if(listString.get(response3) == item.sellableWeapons[a])
                    {
                        tempHolder = tempHolder + item.sellableWeaponsAmt[a];
                 
                    }
                    
                  
                }

                Main.pause();
                
                System.out.println("How many would you like to sell?");
                
                int response4 = input.nextInt();
                
                //check if there's enough qty
                if(response4 > listInt.get(response3))
                {
                    System.out.println("You do not have enough in inventory to sell.");
                }
                else
                {
                    sellValue = (tempHolder * response4);
                    System.out.println("I can offer you: " + sellValue + " gold for your " + listString.get(response3));
                    Main.pause();
                    System.out.println("Is this acceptable?");
                    System.out.println("Enter: 0 for YES");
                    System.out.println("Enter: 1 for NO");
       
                    int response5 = input.nextInt();
                    
                    if(response5 == 0)
                    {
                        hero1.gold = hero1.gold + sellValue;
                        System.out.println("You now have " + hero1.gold + " gold.");
                        useInventory(listString.get(response3));
                        itemSold++;
                        Main.pause();
                        
                    }
                    else
                    {
                        System.out.println("Suit yourself, " + vendorName + " mutters.");
                        Main.pause();
                    }
                       
      
               
                }
            }
            else
            {
                System.out.println("I have no interest in buying that unfortunately.");
                Main.pause();
                
            }
            
            consumableCheck = consumableCheck * 0;
        }
        
        
    }
}

     
       
