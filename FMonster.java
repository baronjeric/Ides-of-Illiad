public class FMonster extends Monster
{
    String monstDrop;
    
   
    
    public FMonster(int attack, int defense, int hitPoints, int dmg, int XP, int gold, String name)
    {
        super(attack, defense, hitPoints, dmg, XP, gold, name);
        
        int roll = dice.nextInt(monstLib.fMonst.length);
        
        monstAttack = monstLib.fMonstAttack[roll];
        monstDefense = monstLib.fMonstDefense[roll];
        monstHitPoints = monstLib.fMonstHitPoints[roll];
        monstDmg = monstLib.fMonstDmg[roll];
        monstXP = monstLib.fMonstXP[roll];
        monstName = monstLib.fMonst[roll];
        goldCheck = monstLib.fMonstGold[roll];
       
    }
             
    
}