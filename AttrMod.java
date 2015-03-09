public class AttrMod
{
    int val1 = 1;
    int val2 = 2;
    int val3 = 3;
    int val4 = 4;
    
    Hero hero1;
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    public void modifyAttr(Hero hero1)
    {
        for(int counter = 0; counter < hero1.attributes.length; counter++)
        {
            switch (hero1.attributeValues[counter])
            {
                
                case 12: case 13:
                    hero1.characterAbilInt[counter] += val1;
                    break;
                case 14: case 15:
                    hero1.characterAbilInt[counter] += val2;
                    break;
                case 16: case 17:
                    hero1.characterAbilInt[counter] += val3;
                    break;
                case 18:
                    hero1.characterAbilInt[counter] += val4;
                    break;    
            }
        }
        
        hero1.tempHP = hero1.characterAbilInt[2];
        
    }
}
