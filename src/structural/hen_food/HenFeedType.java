package structural.hen_food;

public abstract class HenFeedType {
    protected HenFeed henFeed;

    public HenFeedType(HenFeed henFeed){
        this.henFeed = henFeed;
    }

    abstract public int additionPrice();
}
