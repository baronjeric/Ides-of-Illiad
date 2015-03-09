import java.util.Scanner;

public class Location1
{
    Combat combat;
    Hero hero1;
    LocationMgr loc1;
    Inventory inventory;
    
    public void passInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    public void passLocMgr(LocationMgr loc1)
    {
        this.loc1 = loc1;
    }
    
    public void passCombat(Combat combat)
    {
        this.combat = combat;
    }
   
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
 
    public void loc1()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Where would you like to go?");
        System.out.println("Enter 0: Fields");
        System.out.println("Enter 1: Rest");
        System.out.println("Enter 2: Town");
        System.out.println("Enter 3: Use Inventory");
        System.out.println("Enter 4: Manage Weapons, Armor, and Wearable");
        
        int response = input.nextInt();
        
        switch(response)
        {
            case 0:
                FMonster monst1 = new FMonster(0,0,0,0,0,0,"");
                combat.absorbMonst(monst1.monstAttack, monst1.monstDefense, monst1.monstHitPoints, monst1.monstDmg, monst1.monstXP,monst1.goldCheck, monst1.monstName);
                combat.attack();
                loc1.locMgr();
                break;

            case 1:
                System.out.println("Until next time hero!");          
                System.exit(0);
                break;
                
            case 2:
                System.out.println("You enter the small outpost town of Vanguard, deep in the southern region of South Kelodr.");
                hero1.changeLoc(1);
                loc1.locMgr();
                break;
            case 3:
                inventory.showHeroInvConsume();
                loc1.locMgr();
                break;
            case 4:
                inventory.showWeapon();
                inventory.showArmorHead();
                inventory.showArmorChest();
                inventory.showArmorFeet();
                
                loc1.locMgr();
                break;
             
        }
            
            
    }
}	