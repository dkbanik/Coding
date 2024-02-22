package wrap.javadesignpatterns.proxy;

public class ProxyImage implements Image{
    RealImage image;
    @Override
    public void display() {
        if(image == null){
            image = new RealImage();
        }
        image.display();
    }
}
