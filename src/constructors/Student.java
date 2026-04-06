package constructors;

public class Student {

    private static int nextId = 1; // contador global

    private int id;
    private String name;
    private String sex;
    private int age;
    private int dateOfBirth;

    public Student(String name, String sex, int dateOfBirth, int age) {
        this.id = nextId++;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateOfBirth(int age) {
        this.dateOfBirth = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Sex: %s | Age: %d",
                id, name, sex, age);
    }
}