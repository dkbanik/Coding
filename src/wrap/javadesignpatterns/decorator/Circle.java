package wrap.javadesignpatterns.decorator;

public class Circle implements Shape{
    private String type;

    Circle(){
        setType();
    }
    @Override
    public void draw() {
        System.out.println("Draw: "+getType());
    }

    public void setType(){
        this.type = "circle";
    }
    @Override
    public String getType() {
        return type;
    }
}
