package behavioral;

import behavioral.command.IntroductionTypeDeterminerUtil;
import behavioral.command.introduction.SimuFunctions;
import behavioral.command.introduction.HandIntroductionStrategy;
import behavioral.command.introduction.ImportStrategy;
import behavioral.command.functionality.*;
import behavioral.iterator.StudentClass;
import behavioral.iterator.StudentCollection;
import behavioral.observer.SimuUse;
import behavioral.observer.IntroducerObserver;
import behavioral.observer.Observer;
import behavioral.strategy.Student;
import behavioral.strategy.SimuStock;

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

