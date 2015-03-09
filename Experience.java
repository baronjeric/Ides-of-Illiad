import java.util.Random;

public class Experience
{
    int counter2 = 1;
    int levelUp[]={50,100,300,600,1000,1500,2100};
    int levels[]={1,2,3,4,5,6,7};
    int counter3 = 0;
    
    Hero hero1;
    
    Random dice = new Random();
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public int getXP()
    {
        System.out.println("Current total XP: " + hero1.experience);
        Main.pause();
        return hero1.experience;
    }
    
    public void addXP(int amt)
    {
        hero1.experience = hero1.experience + amt;
        getXP();
        experienceCheck();
    }
    
    public void experienceCheck()
    {
        for(int counter = 0; counter < levelUp.length; counter++)
        {
            if(hero1.experience > levelUp[counter] && counter2 == levels[counter])
            {
                hero1.level = levels[counter];
                levelUp();
                counter2++;
                counter3++;
                
            }
            else
            {}
        
        }
        if(counter3 > 0)
        {
            counter3--;
            Main.pause();
        }
        
        
    }
    
    public void levelUp()
    {
        int hitPointsUp = dice.nextInt(4)+1;
        hero1.characterAbilInt[2] = hero1.characterAbilInt[2] + hitPointsUp;
        System.out.println("You have gained a LEVEL!");
        System.out.println("Your current level is: " + hero1.level);
        Main.pause();
        System.out.println("Your HP has increased by " + hitPointsUp + " !");
        System.out.println("Your total HP is " + hero1.characterAbilInt[2] + " !");
        hero1.tempHP = hero1.characterAbilInt[2];
    }
    


}
