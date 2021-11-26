package javadesignpatterns.singleton;

public class SingletonModified {
    private static volatile SingletonModified instance;
    public String value;

    private SingletonModified(String value){
        this.value=value;
    }

    public static SingletonModified getInstance(String value){
        SingletonModified local = instance;
        if(local != null){
            return local;
        }
        synchronized (SingletonModified.class){
            if(instance == null){
                instance = new SingletonModified(value);
            }
            return instance;
        }
    }
}
