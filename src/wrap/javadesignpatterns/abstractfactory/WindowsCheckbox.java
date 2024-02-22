package wrap.javadesignpatterns.abstractfactory;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("Checkbox painting in windows system ...");
    }
}
