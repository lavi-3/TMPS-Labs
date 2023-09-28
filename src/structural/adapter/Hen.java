package structural.adapter;

import structural.hen_food.HenFeedType;

public class Hen implements HenActions {
    private HenFeedType henFeedType;
    private int price;

    public Hen(HenFeedType henFeedType, int price) {
        this.henFeedType = henFeedType;
        this.price = price;
    }


    public void fly() {
        System.out.println("It can fly!!!");
    }

    @Override
    public int displayFinalPrice() {
        return price + henFeedType.additionPrice();
    }
}
