import java.util.Scanner;
import java.util.Random;

public class Intro
{
    Scanner input = new Scanner(System.in);
    Random dice = new Random();
    
    int counter = 0;
    int fatigue = 0;
    int monsterCounter = 0;
    int bloodCounter = 0;
    int monsterTextCheck = 0;
    int escapeCounter = 0;
    int escapeCheck = 0;
    String location;
    
    Hero hero1;
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void introToGame()
    {
        System.out.println("There was once a father...");
        Main.pause();
        System.out.println("A Mother...");
        Main.pause();
        System.out.println("And a very precious boy...");
        Main.pause();
        System.out.println("They lived in a simple house. And things were as they should be. Quiet. Peaceful...");
        Main.pause();
        System.out.println("But one day something terrible happened. The dark ones came...");
        Main.pause();
        System.out.println("And in their wake they left ruin. Destruction. And death.");
        Main.pause();
        
        System.out.println("Many years passed and the people of Illiad suffered.");
        Main.pause();
        
        System.out.println("You awake. The sun shines through the tree canopy above you and you shield your face. Your eyes feel heavy and your stomach grumbles.");
        Main.pause();
        System.out.println("You've been wandering for weeks, maybe months now. In the distance behind you echo the sounds of horses.");
        System.out.println("Suddenly you remember. You're being chased.");
        Main.pause();
        System.out.println("Your heart beats wildy. You pick a direction and start running. You glance down and realize there is blood on your hands. You stop and check yourself but find no wound. Bewildered, all you can do is run.");
        
        randomEncounter(pickDirection());
        rollForLocation();
        
        escapeCheck();
        
        
    }
     
    public void escapeCheck()
    {
        if(escapeCheck == 1)
        {
            System.out.println("You finally make it to the " + location + " and hide in a large fallen log.");
            Main.pause();
            System.out.println("Just as you take cover the sound of running creatures passes by, the silence only broken by their rhythmic march. You don't dare look for fear of being spotted.");
            Main.pause();
        }
        else
        {
            fatigueCheck();
            monsterCheck();
            randomEncounter(pickDirection());
            rollForLocation();
            escapeCheck();
        }
    }
    
    
    
    public int pickDirection()
    {
        if(counter == 0)
        {
            
            System.out.println("Enter 0: to head towards the Hills.");
            System.out.println("Enter 1: to head towards the Forest.");
            
            int response = input.nextInt();
            if(response == 0)
            {
                location = "Hills";
            }
            else
            {
                location = "Forest";
            }
          
            return response;
        
        }
        else
        {
            System.out.println("Enter 0: to continue.");
            System.out.println("Enter 1: to rest.");
            int response = input.nextInt();
            return response;
            
        }
        
        
    }
       
    public void randomEncounter(int value)
    {
        
        if(counter == 0)
        {
            if(value == 0)
            {
                System.out.println("You make your way towards the hills, weaving your way between the large pine trees that dot the landscape.");
                fatigue++;
                counter++;
            }
            else if(value == 1)
            {
                System.out.println("You make your way towards the forest. The incline before the tree line is steeper than you thought, and you have to stop to catch your breath.");
                System.out.println("You've only stopped for a moment when the sounds of your hunters echoes through the valley, and you force yourself to continue.");
                fatigue++;
                counter++;
            }
            else
            {}
            
        }
        else if (location == "Hills")
        {
            if(value == 0)
            {
                
                fatigue++;
                monsterCounter++;
            }
            else
            {
                System.out.println("You take a moment to catch your breath. The sounds of your pursuers grows louder. You know they're close. You cut your reprieve short and keep running.");
                fatigue = fatigue - 2;
                monsterCounter++;
            }
            
            
        }
        else
        {
            if(value == 0)
            {
                
                fatigue++;
                monsterCounter++;
            }
            else
            {
                System.out.println("You take a moment to catch your breath. The sounds of your pursuers grows louder. You know they're close. You cut your reprieve short and keep running.");
                fatigue = fatigue - 2;
                monsterCounter++;
            }
            
        }
        
        Main.pause();
    }
    
    public void rollForLocation()
    {
        int roll5 = dice.nextInt(20)+1 + escapeCounter;
        if(roll5 > 20)
        {
            escapeCheck++;
        }
        else{
            int roll1 = dice.nextInt(9)+1;
            
            switch(roll1)
            {
                case 1:
                    System.out.println("You hear gutteral shouting in a strange toungue. You keep running and hope they haven't spotted you.");
                    break;
                case 2:   
                    System.out.println("You feel as if your heart is going to burst but something tells you if you stop you will die.");
                    break;
                case 3:        
                    System.out.println("Whatever is chasing you seems determined to keep pace. You do your best to take the most difficult path, still keeping the " + location + " in your sight.");
                    break;
                case 4:  
                    System.out.println("You want to remember why you're out here in the first place, why there's blood on your hands, and who is chasing you, but all you can do is run.");
                    break;
                case 5:    
                    System.out.println("The landscape rolls out before you and always you are followed by the sounds of your hunters.");
                    break;
                case 6:
                    System.out.println("The way is not easy. You feel every rock jutting into your feet. But the fear of the unknown keeps you going. You're getting closer to the Hills.");
                    break;
                case 7:
                    System.out.println("The " + location + " never seems to get any closer but you keep your eyes locked to the ground, ignoring the burning in your legs.");
                    break;
                case 8:
                    System.out.println("Despite the overwhelming feeling of exhaustion, your adrenaline keeps your legs moving.");
                    break;
                case 9:
                    System.out.println("Every step is more pain, and you can't draw enough breath. Still, you know to stop is to die.");
                    break;
                    
            }
            Main.pause(); 
        }
        escapeCounter++;
       
    }
    
    public void monsterEncounter()
    {
       
        if(monsterTextCheck == 0)
        {
            System.out.println("A dark figure appears in front of you, sword drawn. Its face is hidden by a cowel but its body is twice the size of a grown man.");
            System.out.println("Without seeing its face you feel like you know of its horror, but only vaguely, as if in a dream.");
            monsterTextCheck++;
  
        }
        else
        {
            System.out.println("The dark figure charges!");
            Main.pause();
        }
            
        System.out.println("Enter: 0 for RUN");
        int response = input.nextInt();
        
        int roll3 = dice.nextInt(4)+1;
        
        if(roll3 <= 2)
        {
            System.out.println("The dark figure lunges at you, but you dart away before he can harm you.");
            monsterTextCheck--;
            monsterCounter = monsterCounter * 0;
            
        }
        else
        {
            System.out.println("The dark figure lunges at you and you feel the sickening pain of metal piercing your skin.");
            bloodCounter++;
            deathCheck();
            monsterCounter = monsterCounter * 0;
            monsterEncounter();
        }
        
        
    }
    
    public void monsterCheck()
    {
        int roll2 = dice.nextInt(15)+1 + monsterCounter + fatigue;
        if(roll2 > 16)
        {
            monsterEncounter();
        }
    }
    
    public void fatigueCheck()
    {
        if(fatigue > 5)
        {
            System.out.println("You collapse in a heap on the ground, unable to continue. Desite the danger behind you, you cannot force yourself to continue without rest.");
            monsterCounter++;
            System.out.println("Your hunters are close enough now that you can hear their breathing, tired and ragged, like yours. You firm your resolve.");
            Main.pause();
            fatigue = fatigue * 0;
            monsterEncounter();
        }
    }
    
    public void deathCheck()
    {
        if(bloodCounter >= 3)
        {
            System.out.println("The image of the " + location + " blurs in the distance and you collapse to the ground, defeated.");
            Main.pause();
            System.exit(0);
        }
        else if(bloodCounter > 0)
        {
            System.out.println("You ignore the pain and ready yourself for another attack.");
            Main.pause();
        }
        else
        {}
            
        
    }
    
    public void introText()
    {
        System.out.println("After taking enough time to rest and waiting to see if your hunters would return, you continue deeper into the " + location + ".");
        System.out.println("Exhausted, and with no supplies, you only walk a short distance before you fall unconsious.");
        
        Main.pause();
        System.out.println(".....");
        Main.pause();
        System.out.println(".....");
        Main.pause();
        System.out.println(".....");
        Main.pause();
        
        System.out.println("You open your eyes to see a man standing over you.");
        Main.pause();
        System.out.println("'Who are you?' he asks softly.");
        Main.pause();
        System.out.println("You try to speak but only a croak escapes your lips. The man leaves your side and returns shortly holding a leather skin. 'Here, drink.'");
        Main.pause();
        System.out.println("You drink deeply. After you satiate your thirst you respond. 'My name is: ");
        Main.pause();
    }
    
    public void introText2()
    {
        System.out.println("'" + hero1.name + "? That's an odd name. Haven't heard of you around here.'");
        Main.pause();
        
        System.out.println("'You look like a figher. What do you do?'");
        Main.pause();
        
        hero1.askAttributes();
        Main.pause();
        
        System.out.println("Interesting. What's your business around these parts? Not everyday I come across a stranger passed out here in the wild land.");
        
        
        System.out.println("Enter 0: 'I don't know.'");
        System.out.println("Enter 1: 'None of your business.'");
        
        int response = input.nextInt();
        
        switch(response)
        {
            case 0:
                System.out.println("The man nods, 'Whatever you say, " + hero1.name + ". I can appreciate a man who keeps his cards close.");
                Main.pause();
                break;
            case 1:
                System.out.println("'That's an interesting way to talk to someone that's helping you.'");
                Main.pause();
                System.out.println("'I suppose every man has a right to his silence.'");
                Main.pause();
                break;
                                
        }
        
        System.out.println("'Myself, I'm a tinker,' and he gestures to the pack by the fire. 'That pack is my livelihood. I was on my way back from Vanguard, the old outpost.'");
        Main.pause();
        System.out.println("'Not much of a town anymore, but there's still some good folk there. Don't cause any trouble and they'll trade with you. They're used to strangers like you.'");
        Main.pause();
 
    }
    
    public void introText3()
    {
        System.out.println("Enter 0: 'What else is around here.'");
        System.out.println("Enter 1: 'Whats Vanguard like?.'");
        System.out.println("Enter 2: 'Thanks for the help. I'll be going now.'");
        System.out.println("Enter 3: 'Where are you headed to?'");
        System.out.println("Enter 4: 'What do you have for sale?'");
      
        int response1 = input.nextInt();
        
        switch(response1)
        {
            case 0:
                System.out.println("The tinker scratches his head. 'The thing is, there really isn't anything for days, weeks even. It's why I was wondering where you came from.");
                System.out.println("And why you're out here with no supplies.'");
                Main.pause();
                System.out.println("Most folk only come and go from the port. In the old times, maybe a trade caravan from Carahal, over the mountains.'");
                System.out.println("'Apart from Vanguard itself, the surrounding " + location + " are filled with strange beasts and the occasional bandit.'");
                Main.pause();
                System.out.println("'Best to avoid them altogether.'");
                Main.pause();
                introText3();
                break;
            case 1:
                System.out.println("'Vanguard is a nice place. Good people there. Sturdy folk that you won't find in the bigger cities. They've seen tough times and they're still here.'");
                Main.pause();
                System.out.println("'Bergoth's the Smith. Fine weapons he has. Quiet man, but he's trustworthy.'");
                Main.pause();
                System.out.println("'Laurel's a healer. She's fixed me up a few times over the years. Sells trinkets on the side. She can be tough on the outside but she's a good woman.'");
                Main.pause();
                System.out.println("'Other than that, it's really just a small community. Some farm. Others fish. They congregate in the mead hall to swap stories. You can stop by there for a drink.'");
                Main.pause();
                introText3();
                break;
            case 2:
                System.out.println("Good luck, " + hero1.name + ". May the gods smile on you, lad.");
                Main.pause();
                System.out.println("'Maybe our paths will cross again.'");
                Main.pause();
                System.out.println("The tinker let's you stay a while longer as he packs his things and puts out the fire. He tips his hat to you and walks into the " + location + " without a backward glance."); 
                Main.pause();
                break;
            case 3:
                System.out.println("'I live out here, in the wild land. I'll travel around but I always come back here for a season. It's nice and quiet.'");
                Main.pause();
                System.out.println("'There's a peace out here you won't find in a crowded city.'");
                Main.pause();
                introText3();
                break;
            case 4:
                System.out.println("'This and that,' he says, watching you carefully. 'It's not really important since you don't have any money. And yes, I checked.'");
                break;
      
        }
        
        
    }
}
        
