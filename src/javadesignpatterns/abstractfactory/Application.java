package javadesignpatterns.abstractfactory;

public class Application {
    Button button;
    Checkbox checkbox;

    Application(GUIFactory guiFactory){
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }

    void paint(){
        button.paint();
        checkbox.paint();
    }

}
