package wrap.javadesignpatterns.decorator;

public abstract class ShapeDecorator implements Shape{
    Shape decoratedShape;

    ShapeDecorator(Shape shape){
        this.decoratedShape = shape;
    }
    @Override
    public void draw() {
        this.decoratedShape.draw();
    }

}
