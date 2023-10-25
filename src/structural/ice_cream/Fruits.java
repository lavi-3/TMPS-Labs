package structural.ice_cream;

public class Fruits extends IceCreamDecorator {

    private int addPrice;

    public Fruits(IceCream c, int addPrice) {
        super(c);
        this.addPrice = addPrice;
    }

    public int getAddPrice() {
        return addPrice;
    }

    public void setAddPrice(int addPrice) {
        this.addPrice = addPrice;
    }

    @Override
    public int finalPrice(){
        return super.finalPrice() + getAddPrice();
    }
}
