package wrap.functionalinterface;

public interface FuncInterfaceDefaultStatic {
    void abstractmethod();
    default void defaultMethod(){
        System.out.println("Default implementation");
    }
    static void staticMethod(){
        System.out.println("utility/helper method for the interface");
    }
}
