package structural.fiilling;

public class CornCookie extends CookieType {
    public CornCookie(Sweets c, int price) {
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
        return sweets.additionPrice() + price;
    }

}