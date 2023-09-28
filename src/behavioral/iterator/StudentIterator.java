package behavioral.iterator;

import behavioral.strategy.Student;

public class StudentIterator implements Iterator {
    Student[] students;

    int pos = 0;

    public StudentIterator(Student[] students) {
        this.students = students;
    }

    public Object next() {
        Student student = students[pos];
        pos += 1;
        return student;
    }

    public boolean hasNext() {
        if (pos >= students.length ||
                students[pos] == null)
            return false;
        else
            return true;
    }
}
