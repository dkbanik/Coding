package wrap.javadesignpatterns.abstractfactory;

public class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.println("Button painting in windows system...");
    }
}
