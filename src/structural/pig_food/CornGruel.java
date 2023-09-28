package structural.pig_food;

public class CornGruel implements Gruel {

    @Override
    public void eat(int quantity) {
        System.out.println("Corn Gruel with quantity " + quantity);
    }

}
