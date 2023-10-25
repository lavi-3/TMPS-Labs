package structural.glasure;

import java.util.ArrayList;
import java.util.List;

public class Glasure {
    private int price;

    public Glasure(int price) {
        this.price = price;
    }

    private List<GlasureTaste> glasureTastes = new ArrayList<>();

    public void showGlasure() {
        for(GlasureTaste sh : glasureTastes) {
            sh.eatable();
        }
    }

    public void add(GlasureTaste s){
        this.glasureTastes.add(s);
    }

    public int getPrice() {
        return price * glasureTastes.size();
    }

    public void clear(){
        System.out.println("Clear glasures");
        this.glasureTastes.clear();
    }
}
