package wrap.topinterviewmedium.twopointers;
//https://www.youtube.com/watch?v=EdR3V5DBgyo
//https://www.youtube.com/watch?v=m18Hntz4go8
public class TrappingRainwater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));

    }

    public static int trap(int[] height){
        int i=0;int j = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;
        while(i<j){
            if(height[i] <= height[j]){
                //maxleft
                maxLeft = Math.max(maxLeft, height[i]);
                water+=(maxLeft-height[i]);
                i++;
            }
            else{
                //maxRight
                maxRight = Math.max(maxRight, height[j]);
                water+=(maxRight-height[j]);
                j--;
            }
        }
        return water;

    }
}
