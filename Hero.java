import java.util.Scanner;

public class Hero
{

    String attributes[]={"strength", "dexterity", "constitution"};
    int attributeValues[]={0,0,0};
    int totalAttrPoints = 45;
    int runningTotalPoints = 0;
 
    String characterAbil[]={"Damage", "attack", "hitPoints", "Armor Head", "Armor Chest", "Armor Feet"};
    int characterAbilInt[]={2,20,20,0,0,0};
    
    int level = 0;
    int experience = 0;
    int tempHP = 20;
    int currentLoc = 0;
    int gold = 0;
    String name;
    
    //Armor has multiple elements. Total defense will be the sum of these elements.
    
    int counter = 0;
    int counter2 = 0;
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);

    public void askAttributes()
    {
        for(counter = 0; counter<attributes.length; counter++)
        {
            System.out.println("How many points would you like to invest into " + attributes[counter] + "?");
            

            attributeCheck();
            
        }
        finalAttrCheck();
        counter = counter *0;
    }
    
    public void attributeCheck()
    {
        if(attributeValues[counter] >18 || attributeValues[counter] <10)
        {
            System.out.println("Attributes may only go as low as 10 and as high as 18");
            
           
            attributeValues[counter] = input.nextInt();
            attributeCheck();
            
        }
        else
        {
            runningTotalPoints = runningTotalPoints + attributeValues[counter];
            System.out.println("Points spent: " + runningTotalPoints);
            System.out.println("Points remaining: " + (totalAttrPoints - runningTotalPoints));
            counter2++;
        }
        
        
        
        
    }
    
    public void finalAttrCheck()
    {
        
        if(counter2 == 3 && runningTotalPoints != 45)
        {
            System.out.println("All points must be spent. Please rellocate your attribute points.");
            attributeValues[0] = 0;
            attributeValues[1] = 0;
            attributeValues[2] = 0;
            counter2 = 0;
            totalAttrPoints = 45;
            runningTotalPoints = 0;
            askAttributes();
        }
        
    }
    
    public void askName()
    {
        String response = input2.nextLine();
        this.name = response;
        Main.pause();
    }
   
    public void dmgHero(int amt)
    {
        tempHP = tempHP - amt;
    }
    
    public void changeLoc(int amt)
    {
        currentLoc = amt;
    }
    
    public void healHero(int amt)
    {
        if(characterAbilInt[2] < tempHP + amt)
        {
            tempHP = characterAbilInt[2];
            System.out.println("Your current HP is: " + tempHP +  " / " + characterAbilInt[2]);
        }
        else
        {
            tempHP = tempHP + amt;
            System.out.println("Your current HP is: " + tempHP +  " / " + characterAbilInt[2]);
        }
    }
        
    public void changeGold(int amt)
    {
        gold = gold + amt;
    }
        
    
    
}


        