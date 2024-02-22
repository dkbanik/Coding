package wrap.javadesignpatterns.proxy;

public class RealImage implements Image{

    RealImage(){
        loadImage();
    }
    @Override
    public void display() {
        System.out.println("Image showing");
    }

    private void loadImage(){
        System.out.println("Downloading image...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
