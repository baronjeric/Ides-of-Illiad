import java.util.Scanner;

public class LocationMgr
{
    Hero hero1;
    Combat combat;
    Location1 loc1;
    Location2 loc2;
    
    public void passLocation1(Location1 loc1)
    {
        this.loc1 = loc1;
    }
    
    public void passLocation2(Location2 loc2)
    {
        this.loc2 = loc2;
    }
    
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void passCombat(Combat combat)
    {
        this.combat = combat;
    }

    public void locMgr()
    {
        switch(hero1.currentLoc)
        {    
            case 0:
                loc1.loc1();
                break;
                
            case 1:
                loc2.loc2();
                break;
        }
            
    }

}
