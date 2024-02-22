package wrap.javadesignpatterns.decorator;

public class BorderShapeDecorator extends ShapeDecorator{
    BorderShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        drawBorder(decoratedShape);
    }

    @Override
    public String getType() {
        return decoratedShape.getType();
    }

    void drawBorder(Shape decoratedShape){
        System.out.println("Drawing Border for Shape: " + decoratedShape.getType());
    }
}
