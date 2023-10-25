package structural;

import structural.adapter.Cookie;
import structural.adapter.CookieProprieties;
import structural.adapter.IceCreamAdapter;
import structural.fiilling.*;
import structural.ice_cream.Caramel;
import structural.ice_cream.Fruits;
import structural.ice_cream.IceCream;
import structural.ice_cream.WhiteIceCream;
import structural.glasure.ChocolateGlasure;
import structural.glasure.Glasure;
import structural.glasure.GlasureTaste;
import structural.glasure.MarmeladGlasure;

public class Main {
    public static void main(String[] args) {
        //Bridge
        CookieType cookieType = new CornCookie(new WhiteChocolate(), 100);
        cookieType.additionPrice();

        CookieType cookieType1 = new WheatCookie(new DarkChocolate(), 200);
        cookieType1.additionPrice();

        //Composite
        GlasureTaste marmeladGlasure = new MarmeladGlasure();
        GlasureTaste marmeladGlasure1 = new MarmeladGlasure();
        GlasureTaste chocolateGlasure = new ChocolateGlasure();
        Glasure glasure = new Glasure(100);
        glasure.add(marmeladGlasure1);
        glasure.add(marmeladGlasure1);
        glasure.add(chocolateGlasure);
        glasure.showGlasure();
        glasure.clear();
        glasure.add(marmeladGlasure);
        glasure.add(chocolateGlasure);
        glasure.showGlasure();

//        Decorator
        IceCream iceCream = new Caramel(new WhiteIceCream("Joc", 100, glasure), 10);
        System.out.println(iceCream.finalPrice());

        IceCream caramel = new Caramel(new Fruits(new WhiteIceCream("Plombir", 120, glasure), 30), 20);
        System.out.println(caramel.finalPrice());

//        Adapter
        CookieProprieties cookieProprieties = new Cookie(cookieType1, 100);
        CookieProprieties iceCreamAdapter = new IceCreamAdapter(iceCream);
        System.out.println(cookieProprieties.displayFinalPrice());
        System.out.println(iceCreamAdapter.taste());
    }
}
