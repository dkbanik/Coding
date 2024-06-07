package wrap.java_concepts.interfaceandabstract;

public class Ostrich extends Bird{
    boolean canRun;
    Ostrich(String name, boolean canRun) {
        super(name);
        this.canRun = canRun;
    }

    @Override
    void makeSound() {
        System.out.println("Ostrich sound");
    }
}
