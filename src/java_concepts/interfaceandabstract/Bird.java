package java_concepts.interfaceandabstract;

public abstract class Bird {
    String name;
    Bird(){
        System.out.println("bird created");
    }
    Bird(String bird){
        this.name = bird;
    }

    void makeSound(){
        System.out.println("Bird sound");
    }
}
