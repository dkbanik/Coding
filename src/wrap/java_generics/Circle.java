package wrap.java_generics;

public class Circle extends ShapeWithOneSide implements Shape {

    public Circle(int sideLength) {
        super(sideLength);
    }

    @Override
    public double calculateArea() {
        return Math.PI*sideLength*sideLength;
    }

    @Override
    public double calculateParameter() {
        return Math.PI*2*sideLength;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
