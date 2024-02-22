package wrap.javadesignpatterns.decorator;

public class RedColor extends ColorShapeDecorator{

    RedColor(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        color();
    }

    public void color(){
        System.out.println("Drawing Red color for: "+decoratedShape.getType());
    }
}
