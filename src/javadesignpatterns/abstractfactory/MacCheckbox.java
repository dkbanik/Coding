package javadesignpatterns.abstractfactory;

public class MacCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Checkbox painting in mac system ...");
    }
}
