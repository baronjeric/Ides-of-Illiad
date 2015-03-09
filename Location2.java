import java.util.Scanner;

public class Location2
{
    Combat combat;
    Hero hero1;
    LocationMgr loc1;
    Healer healer;
    Smithy smithy;
    
    public void passSmithy(Smithy smithy)
    {
        this.smithy = smithy;
    }
    
    public void passHealer(Healer healer)
    {
        this.healer = healer;
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
 
    public void loc2()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Where would you like to go?");
        System.out.println("Enter 0: Mead Hall");
        System.out.println("Enter 1: Smith");
        System.out.println("Enter 2: Healer");
        System.out.println("Enter 3: Tower");
        System.out.println("Enter 4: Port");
        System.out.println("Enter 5: Rest");
        System.out.println("Enter 6: Town Exit");
        
        int response = input.nextInt();
        
        switch(response)
        {
            case 0:
                //meadhall stuff
                loc1.locMgr();
                break;

            case 1:
                smithy.introBergoth();
                smithy.bergoth();
                loc1.locMgr();
                break;
                
            case 2:
                healer.introLaurel();
                healer.laurelHeal();
                loc1.locMgr();
                break;
                
            case 3:
                //Tower stuff
                loc1.locMgr();
                break;
                
            case 4:
                 //Port stuff
                 loc1.locMgr();
                 break;
                 
            case 5:
                 System.out.println("Until next time, Hero!");
                System.exit(0);
                 break;
            case 6:
                 System.out.println("You make your way out of town and to the open grasslands that surround Vanguard");
                 hero1.changeLoc(0);
                 loc1.locMgr();
                 break;
        }
            
            
    }
}	