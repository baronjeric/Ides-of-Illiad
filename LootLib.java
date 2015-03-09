import java.util.ArrayList;

public class LootLib
{
   
   //comprehensive list of monsters in the entire game ------------------------------------------------------------------------------------------------------------------------------------
   String comprehensiveMonstList[]={"Giant Rat", "Wandering Vagabound","Rabid Dog", "Sprite","Small Wyrm",
   "Cave Troll", "Orc Scout", "Horned Beetle", "Diseased Lunatic","Red Wyrm"};

   //Fields Monsters ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   String giantRat[]={"Meat","Fur", "Rat Tail", "Teeth", ""};
   int giantRatWeight[]={1,2,1,5,2};
   
   String wanderingVagabound[]={"Dagger","Leather Helmet", "Minor Healing Potion", "Bandage", "Small Ruby",""};
   int wanderingVagaboundWeight[]={50,50,10,4,1,2};
   
   String rabidDog[]={"Leather Boots", "Fur", "Teeth", "Meat",""};
   int rabidDogWeight[]={15,3,3,2,10};
   
   String sprite[]={"Fairy Dust", "Sprite Wings", "Crystal Shard", ""};
   int spriteWeight[]={10,15,20,1};
   
   String smallWyrm[]={"Wyrm Scale", "Wyrm Tooth", "", "Small Perl", "Emerald"};
   int smallWyrmWeight[]={12,5,1,8,15};
   
   
   //Total Array of Weights and Drops ----------------------------------------------------------------------------------------------------------------------------------------------------
   String [] arrayOfAllMonsterWeight [] = {giantRat, wanderingVagabound, rabidDog, sprite, smallWyrm};
   int [][] arrayOfAllMonsterWeightInt = new int [][] { giantRatWeight, wanderingVagaboundWeight, rabidDogWeight, spriteWeight, smallWyrmWeight};
   
   
   int holder = 0;
   
   //what monster are we using? (monstName1) based on that, return the array of item drops and item weights accordingly
    public int[] alignIndexOfLoot(String monstName1)
   {
       for(int i = 0; i<comprehensiveMonstList.length; i++)
       {
           if(monstName1 == comprehensiveMonstList[i])
           {
               holder = i;
               break;
            }
           
        }
        
       return arrayOfAllMonsterWeightInt[holder];

   }
   
    public String[] alignIndexOfLoot2(String monstName1)
   {
       for(int i = 0; i<comprehensiveMonstList.length; i++)
       {
           if(monstName1 == comprehensiveMonstList[i])
           {
               holder = i;
               break;
            }
           
        }
        
       return arrayOfAllMonsterWeight[holder];

   }
   
   
    
    
}
    
        
        
    
    
    
