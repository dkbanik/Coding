package wrap.javadesignpatterns.singleton2.levelsix;
class SingletonLevelSix{

    private static volatile SingletonLevelSix instance;
    private SingletonLevelSix(){
    }

    // L10 allows us to not query instance from main memory again, we store it in result
    // this helps in performance significantly
    public static SingletonLevelSix getInstance(){
        SingletonLevelSix result = instance;
        if(result == null) {
            synchronized (SingletonLevelSix.class){
                result = instance;
                if(result == null){
                    result = new SingletonLevelSix();
                }
            }
        }
        return result;
    }
    public void print(){
        System.out.println("Printing");
    }
}
public class main {
}
