package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

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
