package wrap.javadesignpatterns.decorator;

public class Rectangle implements Shape{
    private String type;

    Rectangle(){
        setType();
    }
    @Override
    public void draw() {
        System.out.println("Draw: "+getType());
    }

    public void setType(){
        this.type = "rectangle";
    }
    @Override
    public String getType() {
        return this.type;
    }
}
