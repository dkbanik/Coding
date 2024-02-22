package wrap.topinterviewmedium.slidingwindow;
/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MaxVowels {
    public static void main(String[] args) {
        String s ="leetcode"; int k=3;
        int vowels = 0;
        int maxVowels = Integer.MIN_VALUE;
        int i=0; int j=0; int len=0;
        while(j < s.length()){
            while(len < k){
                if(isVowel(s.charAt(j))){
                    vowels++;
                }
                j++;len++;
            }
            maxVowels=Math.max(maxVowels,vowels);
            if(isVowel(s.charAt(i))){
                vowels--;
            }
            i++;len--;
        }
        System.out.println("vowels "+maxVowels);
    }

    public static boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
