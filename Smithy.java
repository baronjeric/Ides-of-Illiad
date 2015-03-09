import java.util.Scanner;

public class Smithy
{
    Hero hero1;
    LocationMgr loc1;
    Store store;
    Inventory inventory;
    int counter = 0;
    int storeCounter = 0;
    
    int itemPrice[]={30,80,150,10,25};
    int itemQty[]={0,0,0,0,0};
    String itemName[]={"Dagger", "Short Sword", "Spear", "Leather Hat", "Leather Boots"};
    int vendorGold = 100;
    String name = "Bergoth";
    
    Scanner input = new Scanner(System.in);
    
    public void passInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }
   
   
    public void passStore(Store store)
    {
        this.store = store;
    }
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void passLocationMgr(LocationMgr loc1)
    {
        this.loc1 = loc1;
    }
    
    public void bergoth()
    {
        
        
        System.out.println("Enter 1: I'd like to sell a few things.");
        System.out.println("Enter 2: Do you have anything for sale?");
        System.out.println("Enter 3: I have to be going.");
        int response = input.nextInt();
        
        switch(response)
        {
            case 1:
                sellSmithStuff();
                bergoth();
            case 2:
                if(storeCounter == 0)
                {
                    storeCounter++;
                    store.addStoreInventoryWeapons(itemQty);
                    store.showInventory(itemName, itemQty, itemPrice);
                    if(store.qtyPurchased > 0)
                    {
                        inventory.addToInv(store.itemPurchased, store.qtyPurchased);
                        store.qtyPurchased = 0;
                    }
                    bergoth();
                    break;
                }
                else
                {
                    store.showInventory(itemName, itemQty, itemPrice);
                    if(store.qtyPurchased > 0)
                    {
                        inventory.addToInv(store.itemPurchased, store.qtyPurchased);
                        store.qtyPurchased = 0;
                    }
                    bergoth();
                    break;
                }   
            case 3:
                System.out.println("Bergoth doesn't bother to look up from his forge as you leave.");
                loc1.locMgr();
                break;
           
                
                
        }
    }
        
    
    public void introBergoth()
    {
        switch (counter)
        {
            case 0:
                System.out.println("The sounds of hammer striking metal ring out in the air.");
                System.out.println("A bearded man with soot on his face and eyes that pierce you to the core inspect you head to toe. 'Need something?' he says in a gruff voice.");
                counter++;
                break;
            
            case 1: case 2: case 3:
                System.out.println("The sounds of hammer striking metal ring out in the air.");
                System.out.println("Bergoth nods to you as you walk in. 'Did you need something?'" + hero1.name);
                counter++;
                break;
                
            case 4:
                System.out.println("The sounds of hammer striking metal ring out in the air.");
                System.out.println("Bergoth gives you what you take to be his smile. 'Who is going to buy  my weapons if you don't make it back. Mind yourself out there,' he says.");
                break;
        }
    }
    
    public void sellSmithStuff()
    {
        System.out.println("I'll buy your weapons, armor, anything used in combat. But anything else you'd have better luck with Laurel. She'll take care of you.");
        inventory.showHeroInvSellWeaps(vendorGold, name);
        
        System.out.println("Would you like to sell me any other weapons?");
        System.out.println("Enter 0: for YES");
        System.out.println("Enter 1: for NO");
        int response3 = input.nextInt();
        
        if(response3 == 0)
        {
            sellSmithStuff();
        }
        else if(inventory.itemSold > 0)
        {
        
            inventory.showWeapon();
            inventory.showArmorHead();
            inventory.showArmorChest();
            inventory.showArmorFeet();
            inventory.itemSold = inventory.itemSold * 0;
            bergoth();
        }
        else
        {
            bergoth();
        }
        
    }
        
    
    
}
        
    