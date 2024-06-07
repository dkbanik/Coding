package wrap.java_concepts.interfaceandabstract;

public class App {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.method0("abc");
        dog.method1("def");
        int size = Animal.size;
        System.out.println(size);

        System.out.println(dog.method2("ghi"));

        Bird bird1 = new Pigeon("pigeon", true);
        Bird bird3 = new Ostrich("ostrich", true);
         Bird bird2 = new Bird("peacock"){};

        bird1.makeSound();
        bird2.makeSound();
        bird3.makeSound();
    }
}
