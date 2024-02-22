package wrap.java_concepts.interfaceandabstract;

public class App {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.method0("abc");
        dog.method1("def");
        int size = Animal.size;
        System.out.println(size);

        System.out.println(dog.method2("ghi"));

        Bird bird1 = new Pigeon();
        Bird bird = new Bird("peacock"){};

        bird.makeSound();
    }
}
