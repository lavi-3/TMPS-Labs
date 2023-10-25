package structural.fiilling;

public abstract class CookieType {
    protected Sweets sweets;

    public CookieType(Sweets sweets){
        this.sweets = sweets;
    }

    abstract public int additionPrice();
}
