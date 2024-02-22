package wrap.javadesignpatterns.abstractfactory;

public class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Button painting in mac system...");
    }
}
