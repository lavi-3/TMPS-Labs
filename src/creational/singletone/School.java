package creational.singletone;

public class School {
    private static School school;
    private String name;

    private School() {
    }

    public static School getInstance() {
        if (school == null) {
            school = new School();
        }
        return school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
