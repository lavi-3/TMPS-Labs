package structural.adapter;

import structural.ice_cream.IceCream;

public class IceCreamAdapter implements CookieProprieties {
    IceCream iceCream;
    public IceCreamAdapter(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String taste() {
        return iceCream.taste();
    }

    @Override
    public int displayFinalPrice() {
        return iceCream.finalPrice();
    }
}
