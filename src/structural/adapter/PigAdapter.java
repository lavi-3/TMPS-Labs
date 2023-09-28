package structural.adapter;

import structural.pig.Pig;

public class PigAdapter implements HenActions {
    Pig pig;
    public PigAdapter(Pig pig) {
        this.pig = pig;
    }

    public void fly()
    {
        pig.run();
    }

    @Override
    public int displayFinalPrice() {
        return pig.finalPrice();
    }
}
