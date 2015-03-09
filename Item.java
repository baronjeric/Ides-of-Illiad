public class Item
{
    Hero hero1;
    
    //Check against this array when seeing if something is consumable. Check below for the effect.
    String consumableItems[]={"Bandage", "Minor Healing Potion", "Healing Potion"};
    
    //Sellable Items - Check against this array when trying to sell.
    String tradableItems[]={"Teeth", "Wyrm Scale", "Wyrm Tooth", "Small Perl", "Emerald", "Small Emerald", "Small Diamond", "Dimaond", "Fur", "Rat Tail", "Meat",
        "Fairy Dust", "Sprite Wings", "Crystal Shard", "Bandage", "Minor Healing Potion", "Healing Potion"};
    int tradableItemsSell[]={1,10,5,4,20,12,50,80,3,5,1,6,5,8,1,3,5};
    
    //Sellable Items - Weapons
    String sellableWeapons[]={"Dagger", "Short Sword", "Long Sword", "Bastard Sword", "Spear", "Battle Axe", "Leather Hat", 
        "Leather Helmet", "Iron Helm", "Scaled Helm", "Steel Helm", "Plate Helm", "Blouse", "Leather Jerkin", "Iron Mail", "Scale Mail", "Steel Mail", "Plate Mail",
        "Simple Boots", "Leather Boots", "Iron Plated Boots", "Scale Boots", "Steel Plated Boots", "Plated Boots"};
    int sellableWeaponsAmt[]={3,5,10,22,35,42,2,5,8,10,13,15,1,3,7,30,65,1,3,5,7,10,15};    
        
    
    //Check against this array when calcuating attack
    String weapons[]={"Dagger", "Short Sword", "Long Sword", "Bastard Sword", "Spear", "Battle Axe"};
    int weaponsDmg[]={1,2,3,4,5,6};
    
    //Check against this array when calcuating armor
    String armorHead[]={"Leather Hat", "Leather Helmet", "Iron Helm", "Scaled Helm", "Steel Helm", "Plate Helm"};
    int armorHeadProt[]={0,1,2,3,4,5};
    
    //Check against this array when calcuating armor
    String armorChest[]={"Blouse", "Leather Jerkin", "Iron Mail", "Scale Mail", "Steel Mail", "Plate Mail"};
    int armorChestProt[]={0,2,4,6,7,10};
    
    //Check against this array when calcuating armor
    String armorFeet[]={"Simple Boots", "Leather Boots", "Iron Plated Boots", "Scale Boots", "Steel Plated Boots", "Plated Boots"};
    int armorFeetProt[]={0,1,2,3,4,5};
    
        
    
    public void passHero(Hero hero1)
    {
        this.hero1 = hero1;
    }
    
    
    public void useBandage()
    {
        hero1.healHero(3);
        System.out.println("The Bandage heals you for 3 HP.");
    }
    
    public void useMinorHealingPotion()
    {
        hero1.healHero(8);
        System.out.println("The minor healing potion heals you for 8 HP.");
    }
    
    public void useHealingPotion()
    {
        hero1.healHero(18);
        System.out.println("The Healing Potion heals you for 18 HP.");
    }
    
    public void itemMgr(String itemName)
    {

        switch (itemName)
        {
            case "Bandage":
                useBandage();
                break;
            case "Minor Healing Potion":
                useMinorHealingPotion();
                break;
            case "Healing Potion":
                useHealingPotion();
                break;
                
        }
        
    }
}

 