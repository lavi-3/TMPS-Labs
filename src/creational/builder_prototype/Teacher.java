package creational.builder_prototype;

import creational.singletone.School;
import creational.factory.SchoolType;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Cloneable {
    private List<String> schoolTeaches;
    private String fullName;
    private int salary;
    private School school;

    public Teacher(TeacherBuilder builder) {            //constructor are ca parametru "teacher Builder"
        this.schoolTeaches = builder.schoolTeaches;     // el scoate elementele din builder (dat in main)
        this.fullName = builder.fullName;               // si le da la parametrii din connstructorul teacher
        this.salary = builder.salary;
        this.school = builder.school;
    }

    public void schoolType(SchoolType schoolType) {
        schoolTeaches.add(schoolType.teacherSchool());
    }

    public void deleteObligation(SchoolType schoolType) {
        schoolTeaches.remove(schoolType.teacherSchool());
    }

    public List<String> getSchoolTeaches() {
        return schoolTeaches;
    }

    public String getFullName() {
        return fullName;
    }

    public School getSchool() {
        return school;
    }

    public int getSalary() {
        return salary;
    }
// o functie cu care initializam obiectul, creand o copie, copiind elementele din clasa initiala.
    @Override
    public Object clone() {
        List<String> tempOblig = new ArrayList<String>(this.getSchoolTeaches());
        String tempFullName = this.getFullName();
        int tempSalary = this.getSalary();
        School tempDepartment = this.getSchool();
        return new TeacherBuilder()
                .setSalary(tempSalary)
                .setSchool(tempDepartment)
                .setSchoolTeaches(tempOblig)
                .setFullName(tempFullName)
                .build();
    }

    public static class TeacherBuilder { // obiectul constructorului de baza
        private List<String> schoolTeaches;
        private String fullName;
        private int salary;
        private School school;

        public TeacherBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this; // returneaza la constr de baza
        }
// se seteaza full name-ul care il are cu un full name care il dam noi
        public TeacherBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public TeacherBuilder setSchoolTeaches(List<String> schoolTeaches) {
            this.schoolTeaches = schoolTeaches;
            return this;
        }

        public TeacherBuilder setSchool(School school) {
            this.school = school;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        } // incheie procesul, care seteaza elemente,
                                                                    // returneaza obiectul Teacher cu toate
                                                                    // caracteristicile date
    }
}
