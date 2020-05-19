package com.czy;

/**
 * 最长回文字符创
 *
 * @author caizy
 * @date 2020/5/18 14:05
 **/
public class Palindrome {

    public String longestPalindrome(String s) {
        int start =0,end=0 ,oldLength = 0;
        for(int i = 1;i<s.length();i++){
            int newStart = i-1;
            int newEnd = i+1;
            int loop = check(s,newStart,newEnd);
            int length =loop <= 0 ? 0 : loop * 2 +1;
            if(length > oldLength){
                start = i-loop;
                end = i+loop+1;
                oldLength = length;
            }
            newStart = i-1;
            newEnd = i;
            loop = check(s,newStart,newEnd);
            length =loop <= 0 ? 0 : loop * 2;
            if(length > oldLength){
                start = i-loop;
                end = i+loop;
                oldLength = length;
            }
        }
        if(start!=end){
            return s.substring(start,end);
        }else{
            return "";
        }
    }

    private int check(String s,int start,int end){
        if(start < 0 || end == s.length()){
            return 0;
        }
        if(s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            return check(s,start,end) +1;
        }else{
            return  0;
        }
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.longestPalindrome("cbbd"));
        System.out.println(palindrome.longestPalindrome("babad"));
        System.out.println(palindrome.longestPalindrome("aba"));
        System.out.println(palindrome.longestPalindrome("bb"));
        System.out.println(palindrome.longestPalindrome("a"));

    }
}
