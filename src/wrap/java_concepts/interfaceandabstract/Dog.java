package wrap.java_concepts.interfaceandabstract;

public class Dog implements Animal, Mammal{
    int size = 20;
    @Override
    public void method0(String str) {
        System.out.println("Hello Dog "+str);
    }

    @Override
    public void method1(String str) {
        System.out.println("Method 1 of Dog class "+str);
    }


}
