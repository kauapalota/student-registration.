package constructors;

public class Student {

    private static int nextId = 1; // contador global

    private int id;
    private String name;
    private String sex;

    public Student(String name,  String sex) {
        this.id = nextId++;  // gera ID automático
        this.name = name;
        this.sex = sex;
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
}