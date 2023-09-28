package structural;

import structural.adapter.Hen;
import structural.adapter.HenActions;
import structural.adapter.PigAdapter;
import structural.hen_food.*;
import structural.pig.FatPig;
import structural.pig.MeatPig;
import structural.pig.NormalPig;
import structural.pig.Pig;
import structural.pig_food.CornGruel;
import structural.pig_food.Gruel;
import structural.pig_food.GruelFeed;
import structural.pig_food.WheatGruel;

public class Main {
    public static void main(String[] args) {
        //Bridge
        HenFeedType henFeedType = new Grain(new DirtFeed(), 100);
        henFeedType.additionPrice();

        HenFeedType henFeedType1 = new Corn(new ClearFeed(), 200);
        henFeedType1.additionPrice();

        //Composite
        Gruel cornGruel = new CornGruel();
        Gruel cornGruel1 = new CornGruel();
        Gruel wheatGruel = new WheatGruel();
        GruelFeed gruelFeed = new GruelFeed(100);
        gruelFeed.add(cornGruel1);
        gruelFeed.add(cornGruel1);
        gruelFeed.add(wheatGruel);
        gruelFeed.showGruel(50);
        gruelFeed.clear();
        gruelFeed.add(cornGruel);
        gruelFeed.add(wheatGruel);
        gruelFeed.showGruel(20);

//        Decorator
        Pig meatPig = new MeatPig(new NormalPig("Vasile", 100, gruelFeed), 10);
        System.out.println(meatPig.finalPrice());

        Pig meatPig1 = new MeatPig(new FatPig(new NormalPig("Jora", 120, gruelFeed), 30), 20);
        System.out.println(meatPig1.finalPrice());

//        Adapter
        HenActions henActions = new Hen(henFeedType1, 100);
        HenActions pigAdapter = new PigAdapter(meatPig);
        System.out.println(henActions.displayFinalPrice());
        pigAdapter.fly();
    }
}
