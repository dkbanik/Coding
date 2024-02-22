package wrap.lowleveldesign.singleton.levelthree;
class SingletonLevelThree {
    private static SingletonLevelThree instance;
    private SingletonLevelThree(){
    }

    // this is slow as everytime it acquires lock
    public static synchronized SingletonLevelThree getInstance(){
        if(instance == null) instance = new SingletonLevelThree();
        return instance;
    }
    public void print(){
        System.out.println("Printing");
    }
}
public class main {
    public static void main(String[] args) {
        SingletonLevelThree singletonLevelThree = SingletonLevelThree.getInstance();
        singletonLevelThree.print();
    }
}
