package structural.hen_food;

public class Grain extends HenFeedType {
    public Grain(HenFeed c, int price) {
        super(c);
        this.price = price;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int additionPrice() {
        return henFeed.additionPrice() + price;
    }

}