public class Main
{
    public static void main(String args[])
    {
        Hero hero1 = new Hero();
        Intro intro = new Intro();
        Experience exp = new Experience();
        AttrMod mod = new AttrMod();
        MonsterLib monstLib = new MonsterLib();
        LocationMgr loc1 = new LocationMgr();
        Combat combat = new Combat();
        Location1 location1 = new Location1();
        Location2 location2 = new Location2();
        Healer healer = new Healer();
        Store store = new Store();
        Inventory inventory = new Inventory();
        Item item = new Item();
        Loot loot = new Loot();
        LootLib lootLib = new LootLib();
        Smithy smithy = new Smithy();
        
        loc1.passHero(hero1);
        loc1.passCombat(combat);
        loc1.passLocation1(location1);
        loc1.passLocation2(location2);
        
        location1.passCombat(combat);
        location1.passHero(hero1);
        location1.passLocMgr(loc1);
        location1.passInventory(inventory);

        location2.passCombat(combat);
        location2.passHero(hero1);
        location2.passLocMgr(loc1);
        location2.passHealer(healer);
        location2.passSmithy(smithy);
        
        exp.passHero(hero1);
        
        mod.passHero(hero1);
        
        combat.passHero(hero1);
        combat.passLoc(loc1);
        combat.passExp(exp);
        combat.passInventory(inventory);
        combat.passLoot(loot);
        combat.passLootLib(lootLib);

        healer.passHero(hero1);
        healer.passLocationMgr(loc1);
        healer.passStore(store);
        healer.passInventory(inventory);
        
        smithy.passHero(hero1);
        smithy.passLocationMgr(loc1);
        smithy.passStore(store);
        smithy.passInventory(inventory);
        
        item.passHero(hero1);
        
        inventory.passItem(item);
        inventory.passHero(hero1);
        
        store.passHero(hero1);
        
        intro.passHero(hero1);
        
        
        intro.introToGame();
        intro.passHero(hero1);
        intro.introText();
        hero1.askName();
        intro.introText2();
        intro.introText3();
        
        mod.modifyAttr(hero1);

        loc1.locMgr();

        
        
       
    }
    
    public static void pause()
    {
        System.out.println("");
        try    
        {
            Thread.sleep(1800);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
       
    }
    
    public static void pauseCust(int time)
    {
        System.out.println("");
        try    
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
}

        