# Author: Cozlov Valeria

----

# Topic: *Structural Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

* Introduction

I decided to implement Adapter, Bridge, Composite and Decorator design patterns.
I created a java program where there is are Pigs and Hens and they have food represented in different types, then we adapt pig to hen.

* Snippets from your files.

* Adapter:

```java
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
```

* Bridge:

```java
public abstract class HenFeedType {
    protected HenFeed henFeed;

    public HenFeedType(HenFeed henFeed){
        this.henFeed = henFeed;
    }

    abstract public int additionPrice();
}
```

* Composite:

```java
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
```

* Decorator:

```java
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
```

Main class:

```java
 public class Main {
    public static void main(String[] args) {
        //Bridge
        HenFeedType henFeedType = new Grain(new DirtFeed(), 100);
        henFeedType.additionPrice();

        HenFeedType henFeedType1 = new Corn(new ClearFeed(), 200);
        henFeedType1.additionPrice();

        //Composite
        Gruel cornGruel = new CornGruel();
        Gruel cornGruel1 = new CornGruel();
        Gruel wheatGruel = new WheatGruel();
        GruelFeed gruelFeed = new GruelFeed(100);
        gruelFeed.add(cornGruel1);
        gruelFeed.add(cornGruel1);
        gruelFeed.add(wheatGruel);
        gruelFeed.showGruel(50);
        gruelFeed.clear();
        gruelFeed.add(cornGruel);
        gruelFeed.add(wheatGruel);
        gruelFeed.showGruel(20);

//        Decorator
        Pig meatPig = new MeatPig(new NormalPig("Vasile", 100, gruelFeed), 10);
        System.out.println(meatPig.finalPrice());

        Pig meatPig1 = new MeatPig(new FatPig(new NormalPig("Jora", 120, gruelFeed), 30), 20);
        System.out.println(meatPig1.finalPrice());

//        Adapter
        HenActions henActions = new Hen(henFeedType1, 100);
        HenActions pigAdapter = new PigAdapter(meatPig);
        System.out.println(henActions.displayFinalPrice());
        pigAdapter.fly();
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 structural design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.