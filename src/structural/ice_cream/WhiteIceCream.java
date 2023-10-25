package structural.ice_cream;

import structural.glasure.Glasure;

public class WhiteIceCream implements IceCream {
    private String name;
    private int priceForKg;
    private Glasure glasure;

    public WhiteIceCream(String name, int priceForKg, Glasure glasure) {
        this.name = name;
        this.priceForKg = priceForKg;
        this.glasure = glasure;
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
        return getPriceForKg() + glasure.getPrice();
    }

    @Override
    public String taste() {
        return "Tasty Ice Cream!";
    }
}
