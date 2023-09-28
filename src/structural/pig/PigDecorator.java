package structural.pig;

public class PigDecorator implements Pig {
    protected Pig pig;

    public PigDecorator(Pig c) {
        this.pig = c;
    }

    @Override
    public void run() {
        System.out.println("It cam run!");
    }

    @Override
    public int finalPrice() {
        return this.pig.finalPrice();
    }

}
