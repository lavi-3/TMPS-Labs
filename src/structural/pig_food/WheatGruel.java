package structural.pig_food;

public class WheatGruel implements Gruel {
    @Override
    public void eat(int quantity) {
            System.out.println("Wheat Gruel of quantity " + quantity);
    }

}
