import java.util.Scanner;

public class Healer
{
    Hero hero1;
    LocationMgr loc1;
    Store store;
    Inventory inventory;
    int counter = 0;
    int healerCounter = 0;
    int storeCounter = 0;
    
    int itemPrice[]={30,80,150};
    int itemQty[]={0,0,0};
    String itemName[]={"Bandage", "Minor Healing Potion", "Healing Potion"};
    int vendorGold = 100;
    String name = "Laurel";
    
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
    
    public void laurelHeal()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter 1: Healing.");
        System.out.println("Enter 2: Do you have anything for sale?");
        System.out.println("Enter 3: I have to be going.");
        System.out.println("Etner 4: I'd like to sell a few things.");
        int response = input.nextInt();
        
        switch(response)
        {
            case 1:
                if(hero1.tempHP == hero1.characterAbilInt[2])
                {
                    System.out.println("'You look fine to me,' Laurel says without looking up from her book.");
                    laurelHeal();
                    break;
                }
                else
                {
                    if(healerCounter == 0)
                    {
                        System.out.println("'First times free. Next time it'll cost you,' she says as she gathers her healing supplies.");
                        System.out.println("Laurel carefully applies a poulstice to your wounds, all the while mumbling to herself.");
                        hero1.healHero(hero1.characterAbilInt[2] - hero1.tempHP);
                        healerCounter++;
                        Main.pause();
                        laurelHeal();
                        break;
                    }
                    else
                    {
                        System.out.println("'We don't work for free here. That'll be 5 gold coins paid before services rendered,' she says firmly, holding out her hand.");
                        System.out.println("Enter 0: for YES");
                        System.out.println("Enter 1: for NO");
                        int response2 = input.nextInt();
                        
                        if(response2 == 0)
                        {
                            if(hero1.gold < 5)
                            {
                                System.out.println("You do not have enough gold.");
                                laurelHeal();
                            }
                            else
                            {                                
                                hero1.gold = hero1.gold - 5;
                                System.out.println("Laurel carefully applies a poulstice to your wounds, all the while mumbling to herself.");
                                hero1.healHero(hero1.characterAbilInt[2] - hero1.tempHP);
                                System.out.println("You now have " + hero1.gold + " gold.");
                                Main.pause();
                                laurelHeal();
                            }
                        }
                        else
                        {
                            System.out.println("Then why are you wasting my time?");
                            laurelHeal();
                        }
                    }
                        
                }
            case 2:
                if(storeCounter == 0)
                {
                    storeCounter++;
                    store.addStoreInventoryConsumable(itemQty);
                    store.showInventory(itemName, itemQty, itemPrice);
                    if(store.qtyPurchased > 0)
                    {
                        inventory.addToInv(store.itemPurchased, store.qtyPurchased);
                    }
                    laurelHeal();
                    store.qtyPurchased = 0;
                    break;
                }
                else
                {
                    store.showInventory(itemName, itemQty, itemPrice);
                    if(store.qtyPurchased > 0)
                    {
                        inventory.addToInv(store.itemPurchased, store.qtyPurchased);
                    }
                    laurelHeal();
                    store.qtyPurchased = 0;
                    break;
                }   
            case 3:
                System.out.println("Laurel mutters under her breath and continues reading from her book.");
                loc1.locMgr();
                break;
            case 4:
                System.out.println("Laurel's eyes light up. 'I'll buy pretty much anything useful you have to sell. Anything but weapons and armor and such. Those you can sell to Bergoth, the Smithy just down the road.'");
                inventory.showHeroInvSellTradable(vendorGold, name);
                laurelHeal();
                
                
        }
    }
        
    
    public void introLaurel()
    {
        switch (counter)
        {
            case 0:
                System.out.println("You enter the shop that carries the musty smell of herbs and other drying plants that hang from the ceiling");
                System.out.println("An older woman with wispy white hair stares at you from across the room, an old book in her hands. 'What do you need, Stranger?' she asks.");
                counter++;
                break;
            
            case 1: case 2: case 3:
                System.out.println("You enter the shop that carries the musty smell of herbs and other drying plants that hang from the ceiling");
                System.out.println("Laurel looks up from her reading and nods. 'Did you need something, " + hero1.name + "?'");
                counter++;
                break;
                
            case 4:
                System.out.println("You enter the shop that carries the musty smell of herbs and other drying plants that hang from the ceiling");
                System.out.println("Laurel smiles at you and attends to you immediately, leaving her book on her sturdy rocking chair. 'You keep getting youreslf beat up out there, " + hero1.name + ", one day you're not going to come back!");
                break;
        }
    }
    

    
    
}
        
    