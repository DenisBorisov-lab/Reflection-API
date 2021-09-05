package personExample;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

    private static Person person;

    public static void main(String[] args) {
        Demo demo = new Demo();
        person = demo.createConstructor();
        printData();
        getName();
        setAge(17);
    }

    @SneakyThrows
    public Person createConstructor() {
        Class<?> clazz = Class.forName(Person.class.getName());
        Class[] params = {String.class, int.class, Position.class};
        return (Person) clazz.getConstructor(params).newInstance("Steve", 16, Position.Middle);
    }

    @SneakyThrows
    public static void printData(){
        Method method = person.getClass().getDeclaredMethod("printData");
        method.setAccessible(true);
        method.invoke(person);
    }

    @SneakyThrows
    public static void getName(){
        Field field = person.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String name = field.get(person).toString();
        System.out.println();
        System.out.println("his name is " + name);
    }

    @SneakyThrows
    public static void setAge(int age){
        Field field = person.getClass().getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, age);
        System.out.println();
        System.out.println("Happy birthday, now you are " + person.getAge());
    }

}