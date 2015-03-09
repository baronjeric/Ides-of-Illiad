import java.lang.*;
import java.util.Random;
import java.util.Scanner;

public class Combat
{
    Hero hero1;
    LocationMgr loc1;
    Experience exp;
    Inventory inventory;
    Loot loot;
    LootLib lootLib;
    
    int itemConsumeCheck = 0;
    
    int monstAttack, monstDefense, monstHitPoints, monstDmg, monstXP, monstGold;
    String monstName;
    
    Random dice = new Random();
    
    Scanner input = new Scanner(System.in);
    
    //counter for attack to see if its the first time
    int counter = 0;
    int textCounterCheck = 0;
    
    public void passLootLib(LootLib lootLib)
    {
        this.lootLib = lootLib;
    }
    
    public void passLoot(Loot loot)
    {
        this.loot = loot;
    }
    
    public void passInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }
 
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void passLoc(LocationMgr loc1)
    {
        this.loc1 = loc1;
    }
    
    public void passExp(Experience exp)
    {
        this.exp = exp;
    }
  
    
    public void absorbMonst(int attack, int defense, int hitPoints, int dmg, int xp, int gold, String name)
    {
        monstAttack = attack;
        monstDefense = defense;
        monstHitPoints = hitPoints;
        monstDmg = dmg;
        monstXP = xp;
        monstName = name;
        monstGold = gold;

    }

    public void attack()
    {
       
        if(counter == 0)
        {
            System.out.println("You have encountered a " + monstName + " !");
            counter++;
            
            
            
        }
        else
        {
        }
        
        showHP();
        Main.pause();
        //run or fight?
        decisionCheck();
        
        //Hero swings
        int roll = dice.nextInt(19) + 1 + hero1.characterAbilInt[1];
        if(itemConsumeCheck == 1)
        {
            itemConsumeCheck = itemConsumeCheck * 0; //item gets consumed, hero skips rest of turn
        }

        else if(roll > monstDefense)
        {
            System.out.println("You scored a HIT!");
            int dmg = dice.nextInt(hero1.characterAbilInt[0])+1;
            System.out.println("You have done " + dmg + " damage!");
            monstHitPoints = monstHitPoints - dmg;
            checkMonst();
        }
        else
        {
            System.out.println("You MISSED!");
        }
        
        Main.pause();
        
        //monster swings
        int roll2= dice.nextInt(19) + 1 + monstAttack;
        if(roll > (hero1.characterAbilInt[3] + hero1.characterAbilInt[4] + hero1.characterAbilInt[5]))
        {
            System.out.println("The " + monstName + " scored a HIT!");
            int dmg = dice.nextInt(monstDmg)+1;
            System.out.println("The " + monstName + " did " + dmg + " damage.");
            hero1.dmgHero(dmg);
            checkHero();
        }
        else
        {
            System.out.println("The " + monstName + " MISSED!");
            attack();
        }
        
        
    }
    
    public void decisionCheck()
    {
        System.out.println("What would you like to do?");
        System.out.println("Enter 1: Attack");
        System.out.println("Enter 2: Run");
        System.out.println("Enter 3: Use Item");
        
        int response = input.nextInt();
        
        switch(response)
        {
            case 1:
                if(textCounterCheck == 0)
                {
                    System.out.println("You quell the fear in your belly and attack!");
                    textCounterCheck++;
                }
                else
                {
                    System.out.println("You attack!");
                }
                break;
                
            case 2:
                int roll2 = dice.nextInt(2)+1;
                if(roll2 == 1)
                {
                    System.out.println("You run before the " + monstName + " can get ahold of you!");
                    Main.pause();
                    counter = counter * 0;
                    textCounterCheck = textCounterCheck * 0;
                    loc1.locMgr();
                }
                else
                {
                    System.out.println("You try to escape but the monster is faster!");
                    int roll3= dice.nextInt(19) + 1 + monstAttack;
                    if(roll3 > (hero1.characterAbilInt[3] + hero1.characterAbilInt[4] + hero1.characterAbilInt[5]))
                    {
                        System.out.println("The " + monstName + " scored a HIT!");
                        int dmg = dice.nextInt(monstDmg)+1;
                        System.out.println("The " + monstName + " did " + dmg + " damage.");
                        hero1.dmgHero(dmg);
                        checkHero();
                    }
                    else
                    {
                        System.out.println("The " + monstName + " MISSED!");
                        attack();
                    }
                }
                    
                break;
            case 3:
                if(inventory.showHeroInvConsume() == 1)
                {   
                    itemConsumeCheck = 1;
                    break;
                }
                else
                {
                    decisionCheck();
                }
                
        }
    }
    
    
    
    public void checkMonst()
    {
        if(monstHitPoints < 1)
        {
            System.out.println("You killed the " + monstName + " !");
            Main.pause();
            System.out.println("You have gained " + monstXP + " experience points!");
            exp.addXP(monstXP);
            goldCheck();
            lootCheck();
            counter = counter * 0;
            textCounterCheck = textCounterCheck * 0;
            loc1.locMgr();
            
        }
        else
        {
            
        }
        
    }
    
    public void checkHero()
    {
        if(hero1.tempHP < 1)
        {
            System.out.println("You slump the ground defeated.");
            System.exit(0);
        }
        else
        {
            Main.pause();
            attack();
        }
    }
            
    public void showHP()
    {
        System.out.println("Your current HP is: " + hero1.tempHP +  " / " + hero1.characterAbilInt[2]);
    }
    
    public void goldCheck()
    {
        if(monstGold == 1)
        {
            int modifier = dice.nextInt(2)+1;
            int goldDrop = hero1.level * modifier + 2;
            hero1.changeGold(goldDrop);
            System.out.println("The " + monstName + " dropped " + goldDrop + " gold.");
            System.out.println("You now have: " + hero1.gold + " gold.");
            Main.pause();
            
            
            
        }
    }
    
    public void lootCheck()
    {
        System.out.println("You loot the monsters corpse and find the following items: ");
        
        Random dice = new Random();
        int roll = dice.nextInt(3)+1;
        loot.activateLoot(lootLib.alignIndexOfLoot(monstName), lootLib.alignIndexOfLoot2(monstName));
        
        switch(roll)
        {    
            case 1:
                inventory.addToInv(loot.monstDrop,1);
                checkPrintValue(loot.monstDrop);
                break;
                
             case 2:   
                inventory.addToInv(loot.monstDrop,1);
                inventory.addToInv(loot.monstDrop2,1);
                checkPrintValue(loot.monstDrop);
                checkPrintValue(loot.monstDrop2);
                break;
                
             case 3:
                inventory.addToInv(loot.monstDrop,1);
                inventory.addToInv(loot.monstDrop2,1);
                inventory.addToInv(loot.monstDrop3,1);
                checkPrintValue(loot.monstDrop);
                checkPrintValue(loot.monstDrop2);
                checkPrintValue(loot.monstDrop3);
                break;
                
             case 4:
                inventory.addToInv(loot.monstDrop,1);
                inventory.addToInv(loot.monstDrop2,1);
                inventory.addToInv(loot.monstDrop3,1);
                inventory.addToInv(loot.monstDrop4,1);
                checkPrintValue(loot.monstDrop);
                checkPrintValue(loot.monstDrop2);
                checkPrintValue(loot.monstDrop3);
                checkPrintValue(loot.monstDrop4);
                break;
            }
        Main.pause();    
    }
    
    public void checkPrintValue(String loot)
    {
        if(loot == "")
        {
        }
        else
        {
            System.out.println(loot);
        }
    }
 
        
    
}
        
  
       