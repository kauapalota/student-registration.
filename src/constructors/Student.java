package constructors;
import java.time.LocalDate;
import java.time.Period;
public class Student {

    private static int nextId = 1; // contador global

    private int id;
    private String name;
    private String sex;
    private int age;
    private LocalDate dateOfBirth;

    public Student(String name, String sex, LocalDate dateOfBirth) {
        this.id = nextId++;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
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