package lowleveldesign.singleton.levelone;
class SingletonLevelOne{
    private static final SingletonLevelOne instance = new SingletonLevelOne();

    private SingletonLevelOne(){}

    public static SingletonLevelOne getInstance(){
        return instance;
    }

    public void print(){
        System.out.println("Printing");
    }
}
public class main {
    public static void main(String[] args) {
        SingletonLevelOne singletonLevelOne = SingletonLevelOne.getInstance();
        singletonLevelOne.print();
    }
}
