package javadesignpatterns.decorator;

public class App {
    public static void main(String[] args) {
        Shape circle = new Circle();
        //Rectangle rect = new Rectangle();

        Shape borderedCircle = new BorderShapeDecorator(circle);
        Shape coloredCircle = new ColorShapeDecorator(borderedCircle);
        Shape redColoredCircle = new RedColor(circle);
        coloredCircle.draw();
        System.out.println();
        redColoredCircle.draw();
    }
}
