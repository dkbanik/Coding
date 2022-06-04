package javadesignpatterns.decorator;

import java.io.*;

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
