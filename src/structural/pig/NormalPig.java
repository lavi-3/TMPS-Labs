package structural.pig;

import structural.pig_food.GruelFeed;

public class NormalPig implements Pig {
    private String name;
    private int priceForKg;
    private GruelFeed gruelFeed;

    public NormalPig(String name, int priceForKg, GruelFeed gruelFeed) {
        this.name = name;
        this.priceForKg = priceForKg;
        this.gruelFeed = gruelFeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceForKg() {
        return priceForKg;
    }

    public void setPriceForKg(int priceForKg) {
        this.priceForKg = priceForKg;
    }

    @Override
    public int finalPrice() {
        return getPriceForKg() + gruelFeed.getPrice();
    }

    @Override
    public void run() {
        System.out.println("It can run!");
    }
}
