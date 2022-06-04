package java_concepts.interfaceandabstract;

public interface Animal {
    int size = 102;
    void method0(String str);
    default void method1(String str){
        System.out.println("Method 1 of Animal class "+str);
    }
    default void method3(String str){
        System.out.println(str);
    }

    default int method2(String str){
       return 10;
    }
}
