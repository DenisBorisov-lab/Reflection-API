package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example {
    private int number;
    private String name = "Steven";
    public String city = "привет";

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public Example(int number, String name) {
        this.number = number;
        this.name = name;
    }

    private void printData(){
        System.out.println(number + " " + name);
    }
}
