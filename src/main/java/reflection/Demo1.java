package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Example example = new Example(12, "Oliver");
        example.setNumber(14);
        int number = example.getNumber();
        String name = null;
        System.out.println(name + " " + number);
        Field field = example.getClass().getDeclaredField("name");
        field.setAccessible(true);
        name = (String) field.get(example);
        System.out.println(name + " " + number);
        Field[] fields = example.getClass().getFields();
        Field[] declaredFields = example.getClass().getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        System.out.println(Arrays.toString(fields));
        field.set(example, "Oliver");
        name = (String) field.get(example);
        System.out.println(name);


        Method[] method = example.getClass().getMethods();
        System.out.println(Arrays.toString(method));

        printData(example);

        System.out.println(Example.class.getName());

//        Example example1 = null;
//
//        Class clazz = Class.forName(Example.class.getName());
//        example1 = (Example) clazz.newInstance();
//        System.out.println(example1);

        Example example2 = null;

        Class clazz1 = Class.forName(Example.class.getName());
        Class[] params = {int.class, String.class};
        example2 = (Example) clazz1.getConstructor(params).newInstance(1, "Jack");
        System.out.println(example2);

        Field field1 = example2.getClass().getDeclaredField("name");
        field1.setAccessible(true);
        Object o = field1.get(example2);
        System.out.println(o.toString());

        Constructor[] constructors = clazz1.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parametrtypes = constructor.getParameterTypes();
            for (Class parametr : parametrtypes) {
                System.out.println(parametr.getName());
            }
        }


    }

    public static void printData(Object example) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = example.getClass().getDeclaredMethod("printData");
        method.setAccessible(true);
        method.invoke(example);
    }
}
