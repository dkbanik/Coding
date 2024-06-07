package wrap.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionPackageUsage {
    public static void main(String[] args) {
        // implementation of the method
        // func now holds an instance of an implementation of MyFunctionalInterface
        MyFunctionalnterface func = () -> System.out.println("my interface");
        // calling the method
        func.anyName();

        // implementing the method
        MyFuncInterface2 fun2 = () -> 1;
        System.out.println("fun2 value is "+fun2.whatsInAName());

        // implementation can be anything which takes String & returns boolean
        // parameter can be anything that we define in Predicate but return is always boolean
        //Predicate<String> isEmpty = String::isEmpty;
        // or
         Predicate<String> isEmpty = (str) -> str.isEmpty();
        System.out.println(isEmpty.test("")); // true

        // here consumer takes String as paramter and returns void
        // implementation can be anything but return should be void
        // parameter can be anything that we define but return should be void
        Consumer<String> print = s -> {
            System.out.println(s+"jit");
            System.out.println(s+"jeet");
        };
        print.accept("debo"); // prints debojit \n debojeet

        // as name suggest , its a function which can take any param and return any value
        Function<String, Integer> length = s -> s.length();
        /*
        *  public Integer length(String s){ return s.length();}
        * */
        System.out.println(length.apply("Hello")); // 5

        // this is opp of consumer, while consumer takes anything but returns void
        // supplier takes nothing but return any object
        Supplier<String> supplier = () -> "hello supplier";
        System.out.println(supplier.get());

        // takes in 2 param of same type and return of same type eg: int -> int, int
        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println(sum.apply(2, 3)); // 5

        /*
        *   default method are implemented methods in interface, it helps backward compatibility
        *   like forEach in List interface is a default method, which can be used by all classes that implements List interface
        *   abstact method needs to be implemented by subclasses so we cant add a new abstract method later
        *   static method are helped method for which we dont need an instance of the interface
        *   Comparator interface has several static method like comparing, reverse order, etc
        * */
        FuncInterfaceDefaultStatic func2 = () -> System.out.println(" default static use");
        func2.abstractmethod();
        func2.defaultMethod();
        FuncInterfaceDefaultStatic.staticMethod();
    }
}
