package multithreading.printjob;

public class Printer {
    synchronized public void printDocuments(int num, String name){
        for(int i=0;i<num;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing copies of document "+ name + "#"+i);
        }
    }
}
