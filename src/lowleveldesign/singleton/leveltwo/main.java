package lowleveldesign.singleton.leveltwo;
class SingletonLevelTwo{
    private static SingletonLevelTwo instance;
    private SingletonLevelTwo() {}

    public static SingletonLevelTwo getInstance(){
        if(instance == null)
            instance = new SingletonLevelTwo();
        return instance;
    }

    public void print(){
        System.out.println("Printing");
    }

}
public class main {
    public static void main(String[] args) {
        SingletonLevelTwo singletonLevelTwo = SingletonLevelTwo.getInstance();
        singletonLevelTwo.print();
    }
}
