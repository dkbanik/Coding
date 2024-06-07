package wrap.java_concepts.interfaceandabstract;

public class Pigeon extends Bird {
    boolean canFly;
    Pigeon(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
    }
    @Override
    void makeSound(){
        System.out.println("Pigeon sound");
    }
}
