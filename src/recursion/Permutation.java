package recursion;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str," ");
    }

    private static void findPermutations(String str, String result) {
        if(str.length() == 0){
            System.out.println(result);
            return;
        }
        for (int i=0;i<str.length();i++){
            String temp = str.substring(0, i) + str.substring(i + 1);
            findPermutations(temp, result+str.charAt(i));
        }
    }
}
