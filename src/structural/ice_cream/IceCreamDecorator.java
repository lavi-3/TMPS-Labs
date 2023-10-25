package structural.ice_cream;

public class IceCreamDecorator implements IceCream {
    protected IceCream iceCream;

    public IceCreamDecorator(IceCream c) {
        this.iceCream = c;
    }

    @Override
    public String taste() {
        return "Ice cream is tasty!";
    }

    @Override
    public int finalPrice() {
        return this.iceCream.finalPrice();
    }

}
