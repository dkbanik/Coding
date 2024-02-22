package wrap.java_generics;

public class Square extends ShapeWithOneSide implements Shape{
    public Square(int sideLength) {
        super(sideLength);
    }

    @Override
    public double calculateArea() {
        return sideLength*sideLength;
    }

    @Override
    public double calculateParameter() {
        return 4*sideLength;
    }

    @Override
    public String toString() {
        return "Square";
    }
}
