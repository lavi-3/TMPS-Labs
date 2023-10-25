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
I created a java program where there is ice-cream and cookies and they have components represented in different types, then we adapt iceCream taste to cookie taste.

* Snippets from your files.

* Adapter:

```java
public class IceCreamAdapter implements CookieProprieties {
    IceCream iceCream;
    public IceCreamAdapter(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String taste() {
        return iceCream.taste();
    }

    @Override
    public int displayFinalPrice() {
        return iceCream.finalPrice();
    }
}
```

* Bridge:

```java
public abstract class CookieType {
    protected Sweets sweets;

    public CookieType(Sweets sweets){
        this.sweets = sweets;
    }

    abstract public int additionPrice();
}
```

* Composite:

```java
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
```

* Decorator:

```java
public class IceCreamDecorator implements IceCream {
    protected IceCream iceCream;

    public IceCreamDecorator(IceCream c) {
        this.iceCream = c;
    }

    @Override
    public String taste() {
        return "Ice cream is tasty!";
    }

    @Override
    public int finalPrice() {
        return this.iceCream.finalPrice();
    }

}
```

## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 structural design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.