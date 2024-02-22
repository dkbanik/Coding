package wrap.javadesignpatterns.singleton;

public class FirstThread implements Runnable {

    @Override
    public void run() {
        //Singleton.getInstance fails as two tries to access simultaneously
        //Singleton instance = Singleton.getInstance("deb");
        SingletonModified instance = SingletonModified.getInstance("deb");
        System.out.println(instance.value);
    }
}
