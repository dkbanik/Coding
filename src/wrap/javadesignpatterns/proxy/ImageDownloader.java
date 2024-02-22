package wrap.javadesignpatterns.proxy;

public class ImageDownloader {
    public static void main(String[] args) {
        Image image = new ProxyImage();
        image.display();

        System.out.println("Displaying image immediately again from cache");
        image.display();

    }
}
