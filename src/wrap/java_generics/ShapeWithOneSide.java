package wrap.java_generics;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class ShapeWithOneSide implements Shape{
    public int sideLength;

    public ShapeWithOneSide(int sideLength){
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        throw new NotImplementedException();
    }

    @Override
    public double calculateParameter() {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }
}
