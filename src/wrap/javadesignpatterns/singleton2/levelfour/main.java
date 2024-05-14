package wrap.javadesignpatterns.singleton2.levelfour;

class SingletonLevelFour{

    private static SingletonLevelFour instance;
    private SingletonLevelFour(){
    }
    // double locking for faster access, only if thread enters sync block only then we need to create instance
    // ideally once instance is created, other threads dont need to go to L13 at all
    // issue is Thread A can partially create the instance in L16 but store it in cache memory
    // which Thread B can access (not stable instance)
    public static SingletonLevelFour getInstance(){
        if(instance == null) {
            synchronized (SingletonLevelFour.class){
                if(instance == null){
                    instance = new SingletonLevelFour();
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
