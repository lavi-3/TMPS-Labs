package behavioral.iterator;

import behavioral.strategy.Student;

public class StudentClass {
    StudentCollection studentCollection;
    public StudentClass(StudentCollection studentCollection) {
        this.studentCollection = studentCollection;
    }

    public void printStudentsName() {
        Iterator iterator = studentCollection.createIterator();
        while (iterator.hasNext()) {
            Student n = (Student) iterator.next();
            System.out.println(n.getName());
        }
    }
}
