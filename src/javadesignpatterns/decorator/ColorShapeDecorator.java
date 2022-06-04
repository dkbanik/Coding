package javadesignpatterns.decorator;

public class ColorShapeDecorator extends ShapeDecorator{
    ColorShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String getType() {
        return decoratedShape.getType();
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        drawColor(decoratedShape);
    }

    public void drawColor(Shape decoratedShape){
        System.out.println("Drawing default black color for type: "+decoratedShape.getType());
    }
}
