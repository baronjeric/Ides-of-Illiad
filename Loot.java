import java.util.Random;
import java.util.ArrayList;

public class Loot
{
    String monstDrop = "";
    String monstDrop2 = "";
    String monstDrop3 = "";
    String monstDrop4 = "";
    
     public void activateLoot(int monstArray[], String monstArray2[])
    {
        ArrayList<Integer> monsterIndexWeight = new ArrayList<Integer>();
        ArrayList<String> monsterIndexName = new ArrayList<String>();
        
        
        
        int sum = 0;   
        //what is the total sum of all the weights???
        for(int i = 0; i < monstArray.length; i++)
        {
            sum = monstArray[i] + sum;
        }
        
        
        //put a single index value of 1 in an integer arraylist for each of those weights
        for(int x = 0; x < sum; x++)
        {
            monsterIndexWeight.add(1);
            
            
        }
        
        //for as long as the arraylist of original weights was
        for(int z = 0; z < monstArray.length; z++)
        {
            int x = monstArray[z];
            for(int a = 0; a < x; a++)
            {
                monsterIndexName.add(monstArray2[z]); //add the name of that corresponding index as many times as equal to the weight
            }

            
        }
        
        Random dice = new Random();
        int roll = dice.nextInt(sum);
        int roll2 = dice.nextInt(sum);
        int roll3 = dice.nextInt(sum);
        int roll4 = dice.nextInt(sum);
        
        
        
            
        monstDrop = monsterIndexName.get(roll);
        monstDrop2 = monsterIndexName.get(roll2);
        monstDrop3 = monsterIndexName.get(roll3);
        monstDrop4 = monsterIndexName.get(roll4);
        
       

        
        

    }
    
        
       
    }
    
 
    
    
