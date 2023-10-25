package structural.adapter;

import structural.fiilling.CookieType;

public class Cookie implements CookieProprieties {
    private CookieType cookieType;
    private int price;

    public Cookie(CookieType cookieType, int price) {
        this.cookieType = cookieType;
        this.price = price;
    }

    @Override
    public String taste() {
        return "Cookie Taste";
    }

    @Override
    public int displayFinalPrice() {
        return price + cookieType.additionPrice();
    }
}
