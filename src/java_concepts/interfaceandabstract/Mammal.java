package java_concepts.interfaceandabstract;

public interface Mammal {
    default void method1(String str){
        System.out.println("Method 1 of Mammal Class "+str);
    }
}
