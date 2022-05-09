package javadesignpatterns.abstractfactory;

public class MyApp {

    private static Application configure(){
        GUIFactory guiFactory;
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")){
            guiFactory = new WindowsGUIFactory();
        }else{
            guiFactory = new MacGUIFactory();
        }
        return new Application(guiFactory);
    }

    public static void main(String[] args) {
        Application app = configure();
        app.paint();
    }
}
