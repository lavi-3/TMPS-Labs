package structural.pig;

public class MeatPig extends PigDecorator {
    private int addPrice;

    public MeatPig(Pig c, int addPrice) {
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
    public int finalPrice() {
        return super.finalPrice() + getAddPrice();
    }
}
