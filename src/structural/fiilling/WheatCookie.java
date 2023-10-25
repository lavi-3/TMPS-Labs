package structural.fiilling;

public class WheatCookie extends CookieType {
    private int price;
    public WheatCookie(Sweets c, int price) {
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
        return sweets.additionPrice() + price;
    }

}