# Reflection-API
## Рефлексия - это механизм языка, который исследовать данные о данной программе во время её выполнения. Рефлексия позволяет узнавать информацию о полях, методах, конструкторах класса. 

## Создание конструктора м помощью рефлексии:
```java
@SneakyThrows
public Person createConstructor() {
    Class<?> clazz = Class.forName(Person.class.getName());
    Class[] params = {String.class, int.class, Position.class};
    return (Person) clazz.getConstructor(params).newInstance("Steve", 16, Position.Middle);
}
```

1. ***ClassLoader*** - является тем, кто отвечает за загрузку классов из JVM. Нужно заставить его загрузить и получить
описание нашего класса в виде переменной типа ***Class***.
Для этой задаче существует метод ***forName(String)*** куда мы передаём название класса, описание которого нам требуется.

2. Далее мы создаём массив типа ***Class*** для того, чтобы поместить в него типы данных, которые будут передаваться в конструктор.

3. Получив массив типа ***Class***, мы должны вызвать метод ***getConstructor()*** у переменной типа ***Class***;

4. Получив переменную типа ***Class***, мы вызываем метод ***NewInstance()*** и передать в него данные, которые хотели бы
передать в конструктор. Сам ***NewInstance*** вернёт ***Object***, созданный по
тому самому объекту описания.

### Get полей

```java
@SneakyThrows
    public static void getName() {
        Field field = person.getClass().getDeclaredField("name");
        field.setAccessible(true);
        String name = field.get(person).toString();
        System.out.println();
        System.out.println("his name is " + name);
    }
```

1. Чтобы получить поля, нужно нам класса, мы должны использовать метод ***getFields()***, этот метод вернёт все поля класса.
В данном случае нам это не подойдёт, так как нужное нам поле приватное, поэтому можно использовать метод ***getDeclaredFields()***,
 этот метод также возвращает все поля класса только теперь private и protected. В аргументы этого метода можно передать название поля, 
которое мы хотим получить ***getDeclaredFields(String)***.
2. Когда мы получили объект типа Field со ссылкой на name, следует использовать метод setAccessible(true), он позволяет 
работать с приватным полем.
3. Теперь осталось только использовать метод ***get(Object)*** в аргументы которого мы должны отправить экземпляр нашего
класса и привести итоговый результат к типу переменной.

### Set полей
```java
@SneakyThrows
    public static void setAge(int age) {
        Field field = person.getClass().getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, age);
        System.out.println();
        System.out.println("Happy birthday, now you are " + person.getAge());
    }
```
Всё то же самое только теперь мы используем метод ***set(Object, value)***, где Object - это экземпляр класса,
а value - значение которое мы хоти присвоить.

### Вызов методов
```java
@SneakyThrows
    public static void printData() {
        Method method = person.getClass().getDeclaredMethod("printData");
        method.setAccessible(true);
        method.invoke(person);
    }
```

1. С помощью метода ***getDeclaredMethod(String)*** мы получаем объект типа Method, где String - это название нужного
нам метода.
2. Далее мы осуществляем доступ к приватному методу с помощью метода ***setAccessible(true)***.
3. Для вызова объекта ***Method*** используем метод ***invoke(Object, Args)***, где ***Object*** - экземпляр класса,
а ***Args*** - аргументы метода