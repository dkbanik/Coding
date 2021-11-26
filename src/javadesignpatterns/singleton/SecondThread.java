package javadesignpatterns.singleton;

class SecondThread implements Runnable{

    @Override
    public void run() {
        //Singleton instance = Singleton.getInstance("bunts");
        SingletonModified instance = SingletonModified.getInstance("bunts");
        System.out.println(instance.value);
    }
}
