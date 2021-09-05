package personExample;

public class Person {
    private String name;
    private int age;
    private Position position;

    public Person(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public Position getPosition() {
        return position;
    }

    private void printData() {
        System.out.println("Information: ");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("position: " + position.getMessage());
    }
}
