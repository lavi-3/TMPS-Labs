package creational;

import creational.singletone.School;
import creational.builder_prototype.Teacher;
import creational.factory.SchoolType;
import creational.factory.SchoolTypeFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        School school = School.getInstance();
        school.setName("Ion Creanga");
        School school1 = School.getInstance();
        System.out.println("School name is " + school.getName());
        Teacher teacher = new Teacher.TeacherBuilder()  // un teacher nou care prin teacherBuilder
                .setSchoolTeaches(new ArrayList<>())    // seteaza parametrii.
                .setSalary(200)
                .setSchool(school)
                .setFullName("Maria")
                .build();               // se iese si se returneaza teacherul

        SchoolTypeFactory schoolTypeFactory = new SchoolTypeFactory();
        SchoolType lyceum = schoolTypeFactory.chooseSchoolType("L"); // se repeta clasa factory
        SchoolType gymnasium = schoolTypeFactory.chooseSchoolType("G");
        SchoolType primarySchool = schoolTypeFactory.chooseSchoolType("P");
        teacher.schoolType(lyceum); // teacherul o sa poata sa predeie la L si la G
        teacher.schoolType(gymnasium);

        Teacher teacher2 = (Teacher) teacher.clone(); // toti parametrii de aici sunt clonati de prototype
        Teacher teacher3 = (Teacher) teacher.clone(); // de mai multe ori
        teacher3.schoolType(primarySchool);
        Teacher teacher4 = (Teacher) teacher.clone();
        teacher4.deleteObligation(lyceum);

        System.out.println(teacher2.getSchoolTeaches());
        System.out.println(teacher3.getSchoolTeaches());
        System.out.println(teacher4.getSchoolTeaches());
    }
}
