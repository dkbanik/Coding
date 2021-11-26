package javadesignpatterns.singleton;

public class SingleThread {
    public static void main(String[] args) {
        Singleton first = Singleton.getInstance("deb");
        Singleton sec = Singleton.getInstance("bunt");

        System.out.println(first.value);
        System.out.println(sec.value);
    }
}
