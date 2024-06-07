package wrap.java_concepts.interfaceandabstract;

public abstract class Bird {
    String name;
    Bird(String name){
        this.name = name;
    }

    void makeSound(){
        System.out.println("Bird sound");
    }

    public String getName() {
        return name;
    }
}
