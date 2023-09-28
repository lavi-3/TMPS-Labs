package behavioral.iterator;


import behavioral.strategy.Student;

public class StudentCollection implements Collection
{
    static final int maxStudentsPerSession = 10;
    int numberOfStudent = 0;
    Student[] students;

    public StudentCollection()
    {
        students = new Student[maxStudentsPerSession];
    }

    public void addStudent(String str, int idnp)
    {
        Student student = new Student(str, idnp);
        if (numberOfStudent >= maxStudentsPerSession)
            System.err.println("Full");
        else
        {
            students[numberOfStudent] = student;
            numberOfStudent = numberOfStudent + 1;
        }
    }

    public Iterator createIterator()
    {
        return new StudentIterator(students);
    }
}