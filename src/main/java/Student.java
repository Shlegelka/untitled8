public class Student {
    String name;
    String faculty;
    int age;

    public Student(String name, String faculty,int age) {
        this.name = name;
        this.faculty = faculty;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + faculty + " " + age;
    }

}
