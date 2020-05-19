package com.czy;

import java.util.*;

/**
 * @author caizy
 * @date 2019/12/26 9:16
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void main(String[] args) {
        String s = "aab";
        Map<Character,Integer> characterSet = new HashMap<Character, Integer>();
        int max = 0;
        int startIndex = 0;
        for(int i = 0 ;i < s.length();i++){
            Character temp = s.charAt(i);
            Integer lastIndex = characterSet.get(temp);
            if(lastIndex!=null){
                max = Math.max( i-startIndex,max);
                startIndex =Math.max(lastIndex.intValue()+1,startIndex);
            }
            characterSet.put(temp,i);
        }
        System.out.println(Math.max(max, s.length()-startIndex));
    }
}
