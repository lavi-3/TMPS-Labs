package structural.hen_food;

public class Corn extends HenFeedType {
    private int price;
    public Corn(HenFeed c, int price) {
        super(c);
        this.price = price;
    }

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