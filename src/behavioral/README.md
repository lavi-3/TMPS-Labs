# Author: Cozlov Valeria

----

# Topic: *Behavioral Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation

* Introduction

I decided to implement Strategy, Iterator, Observer and Command design patterns.
I created a java simulation of Simu. The administration can add students or import their info from files. Also, they
have some functionality over the student account.
The Iterator iterates the students were added. Observer notice the functions executed over the student account.

* Snippets from your files.

* Iterator:

```java
public interface Iterator
{
    // indicates whether there are more elements to
    // iterate over
    boolean hasNext();

    // returns the next element
    Object next();
}
```

* Observer:

```java
public class SimuUse implements Use {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    public SimuUse() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        if (!observers.contains(obj)) observers.add(obj);

    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal;
        if (!changed) return;
        observersLocal = new ArrayList<>(this.observers);
        this.changed = false;

        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.changed = true;
        notifyObservers();
    }

}
```

* Command:

```java
public class IntroductionTypeDeterminerUtil {

    public static SimuFunctions getIntroductionType(SimuFunctions simuFunctions) {
        if (simuFunctions.getClass().equals(ImportStrategy.class)) {
            return new ImportStrategy();
        } else {
            return new HandIntroductionStrategy();
        }
    }

}
```

* Strategy:

```java
public class SimuStock {
    List<Student> students;
    public SimuStock() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        this.students.remove(student);
    }
    public int calculateTotal() {
        return students.size();
    }
    public void introduce(IntroductionStrategy introductionStrategy) {
        introductionStrategy.introduction(calculateTotal());
    }
}

```

Main Class:

```java
public class Main {
    public static void main(String[] args) {
        //Strategy
        SimuStock simuStock = new SimuStock();

        Student student1 = new Student("1234", 10);
        Student student2 = new Student("5678", 40);

        simuStock.addStudent(student1);
        simuStock.addStudent(student2);

        //introduce by hand
        simuStock.introduce(new HandIntroductionStrategy("Serghei", "543"));

        //introduce importing file
        simuStock.introduce(new ImportStrategy("Session_1", "Other university", "12/15"));

        //Iterator
        StudentCollection studentCollection = new StudentCollection();
        studentCollection.addStudent("Valea", 123);
        studentCollection.addStudent("Jora", 321);
        StudentClass studentClass = new StudentClass(studentCollection);
        studentClass.printStudentsName();

        //Command
        //Creating the receiver object
        ImportStrategy importStrategy = new ImportStrategy();
        HandIntroductionStrategy handIntroductionStrategy = new HandIntroductionStrategy();
        SimuFunctions introductionType = IntroductionTypeDeterminerUtil.getIntroductionType(importStrategy);
        SimuFunctions introductionType1 = IntroductionTypeDeterminerUtil.getIntroductionType(handIntroductionStrategy);

        //creating command and associating with receiver
        Command setTeacher = new SetTeacher(introductionType);

        //Creating invoker and associating with Command
        FunctionalityInvoker invoker = new FunctionalityInvoker(setTeacher);

        //perform action on invoker object
        String transferInvoker = invoker.execute();

        Command groupTransfer = new GroupTransfer(introductionType);
        invoker = new FunctionalityInvoker(groupTransfer);
        String depositInvoker = invoker.execute();

        Command setMark = new SetMark(introductionType1);
        invoker = new FunctionalityInvoker(setMark);
        String paymentInvoker = invoker.execute();

        //Observer
        //create subject
        SimuUse simuUse = new SimuUse();
        SimuUse simuUse1 = new SimuUse();

        //create observers
        Observer importFileObserver = new IntroducerObserver("Import file observer ");
        Observer handIntroductionObserver = new IntroducerObserver("Hand introduction Observer ");


        //register observers to the subject
        simuUse.register(importFileObserver);
        simuUse1.register(handIntroductionObserver);


        //attach observer to subject
        importFileObserver.setSubject(simuUse);
        handIntroductionObserver.setSubject(simuUse1);

        //check if any update is available
        importFileObserver.update();
        handIntroductionObserver.update();

        //now send message to subject
        simuUse.postMessage(transferInvoker);
        simuUse1.postMessage(paymentInvoker);
    }
}
```

## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
In my code I managed to implement somehow 4 behavioral design patterns. Moreover, I managed not only to copy and use them,
but also to interconnect them.