package javadesignpatterns.abstractfactory;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}