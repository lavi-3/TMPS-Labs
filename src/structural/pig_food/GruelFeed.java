package structural.pig_food;

import java.util.ArrayList;
import java.util.List;

public class GruelFeed {
    private int price;

    public GruelFeed(int price) {
        this.price = price;
    }

    private List<Gruel> gruels = new ArrayList<>();

    public void showGruel(int quantity) {
        for(Gruel sh : gruels) {
            sh.eat(quantity);
        }
    }

    public void add(Gruel s){
        this.gruels.add(s);
    }

    public int getPrice() {
        return price * gruels.size();
    }

    public void clear(){
        System.out.println("Clear gruel");
        this.gruels.clear();
    }
}
