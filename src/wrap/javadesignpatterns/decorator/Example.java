package wrap.javadesignpatterns.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\91801\\IdeaProjects\\Coding\\src\\javadesignpatterns\\decorator\\example.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
