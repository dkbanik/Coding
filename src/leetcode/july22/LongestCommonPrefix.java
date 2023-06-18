package leetcode.july22;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefixV2(String[] strs) {
        int len = strs.length;
        String shortestString = strs[0];
        for(String str : strs){
            if(str.length() < shortestString.length()){
                shortestString = str;
            }
        }

        int shortestStrLen = shortestString.length();
        int i = 0;
        String longestPrefix = "";
        int longestPrefixLen = 0;
        int j = i+1;
        while(i<shortestStrLen && j<=shortestStrLen){
            String subString = shortestString.substring(i,j);
            int count = 0;
            for(String str : strs){
                if(str.contains(subString)){
                    count++;
                }
            }
            // all the strings contains the substring, we need update our longest prefix
            if(count == len){
                if(subString.length() > longestPrefixLen){
                    longestPrefix = subString;
                    longestPrefixLen = subString.length();
                }
            } else{
                i++;
            }
            j++;
        }
        return longestPrefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String shortestString = strs[0];
        for(String str : strs){
            if(str.length() < shortestString.length()){
                shortestString = str;
            }
        }

        int shortestStrLen = shortestString.length();
        int j = 1;
        String longestPrefix = "";
        int longestPrefixLen = 0;
        while(j<=shortestStrLen){
            String subString = shortestString.substring(0,j);
            int count = 0;
            for(String str : strs){
                if(str.startsWith(subString)){
                    count++;
                }
            }
            // all the strings startswith the substring, we need update our longest prefix
            if(count == len){
                if(subString.length() > longestPrefixLen){
                    longestPrefix = subString;
                    longestPrefixLen = subString.length();
                }
            } else{
                return longestPrefix;
            }
            j++;
        }
        return longestPrefix;
    }
}
