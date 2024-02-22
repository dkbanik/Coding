package wrap.lowleveldesign.singleton.levelfive;
class SingletonLevelFive{

    private static volatile SingletonLevelFive instance;
    private SingletonLevelFive(){
    }

    // using volatile stores the instance in main memory so picking from cache wont happen
    public static SingletonLevelFive getInstance(){
        if(instance == null) {
            synchronized (SingletonLevelFive.class){
                if(instance == null){
                    instance = new SingletonLevelFive();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println("Printing");
    }
}

public class main {
    public static void main(String[] args) {

    }
}
