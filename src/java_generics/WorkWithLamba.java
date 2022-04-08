package java_generics;


public class WorkWithLamba {
    public static void main(String[] args) {

        ShapeWithOneSide circle = new Circle(4);
        ShapeWithOneSideArea ops = ShapeWithOneSide::calculateArea;

        System.out.println("Area of "+circle+": "+ops.getArea(circle));

        ShapeWithOneSide square = new Square(4);
        ShapeWithOneSideArea ops1 = ShapeWithOneSide::calculateArea;
        System.out.println("Area of "+square+": " +ops1.getArea(square));


    }
}
