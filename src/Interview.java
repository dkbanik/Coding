public class Interview {

    /*
    * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
    *
    * */
    public static void main(String[] args) {
        int[] height1 = {4,2,0,3,2,5}; // 1,
        int[] height ={0,1,0,2,1,0,1,3,2,1,2,1};
        int i=0;
        int j=height.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax =Integer.MIN_VALUE;
        int sum=0;
        while(i <= j){
            leftMax = Math.max(leftMax, height[i]); //2
            rightMax = Math.max(rightMax, height[j]); // 1
            int min = Math.min(leftMax, rightMax); //1
            int diff = Math.abs(min-height[i]); // 1
            sum+=diff; // 3
            i++;
        }
        System.out.println("sum is" +sum);
    }


    /*
    * [13:29] Dhinesh Murugesan
You're tasked with analyzing sales data for a retail company. The sales data is stored in a list of sale records, where each record contains information about the product, its price, and the quantity sold. Your goal is to use Java 8 streams and lambda expressions to perform various analyses on this data.

Here's the scenario:

Calculate the total revenue generated from all sales.

Find the product that generated the highest revenue.

Find the average price of the products sold.
[13:29] Dhinesh Murugesan
import java.util.Arrays;

import java.util.List;

class SaleRecord {

    private String product;

    private double price;

    private int quantity;

    public SaleRecord(String product, double price, int quantity) {

        this.product = product;

        this.price = price;

        this.quantity = quantity;

    }

    public String getProduct() {

        return product;

    }

    public double getPrice() {

        return price;

    }

    public int getQuantity() {

        return quantity;

    }

}

public class SalesData {

    public static void main(String[] args) {

        List<SaleRecord> sales = Arrays.asList(

                new SaleRecord("Laptop", 1200.00, 5),

                new SaleRecord("Smartphone", 800.00, 10),

                new SaleRecord("Tablet", 400.00, 8),

                new SaleRecord("Headphones", 100.00, 20),

                new SaleRecord("Smartwatch", 300.00, 15)

        );

        // Perform analysis using Java 8 streams and lambda expressions

    }

}
*/


}
