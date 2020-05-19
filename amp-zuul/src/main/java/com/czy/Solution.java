package com.czy;

import com.google.common.collect.ImmutableList;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.*;

/**
 * @author caizy
 * @date 2019/12/26 9:15
 **/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode  = new ListNode(0);
        ListNode curr = resultNode;
        int isTenEnough= 0;
        while (l1!=null || l2!=null){
            curr.next = new ListNode(0);
            int x = l1==null ? 0 :l1.val;
            int y = l2==null ? 0 :l2.val;
            int result = (x + y+isTenEnough)%10 ;
            isTenEnough = (x + y+isTenEnough)/10;
            curr.next.val += result;
            l1= l1 == null ? null : l1.next;
            l2= l2 == null ? null : l2.next;
            curr = curr.next;
        }
        if(isTenEnough > 0){
            curr.next = new ListNode(isTenEnough);
        }
        return resultNode.next;
    }

    public int lengthOfLongestSubstring(String s) {
        String largeStr = "";
        for(int j =0;j<s.length();j++) {
            StringBuilder stringBuilder = new StringBuilder();
            String testString = s.substring(j);
            for (int i = 0; i < testString.length(); i++) {
                char currChar = testString.charAt(i);
                if (stringBuilder.toString().indexOf(currChar) >= 0) {
                    if (largeStr.length() < stringBuilder.length()) {
                        largeStr = stringBuilder.toString();
                    }
                    stringBuilder = new StringBuilder().append(currChar);
                } else {
                    stringBuilder.append(currChar);
                }
            }
            if(largeStr.length() < stringBuilder.length()){
                largeStr = stringBuilder.toString();
            }
        }
        return largeStr.length();
    }


    public int lengthOfLongestSubstring2(String s) {
       int ans = 0 ,i=0,j=0;
       int n = s.length();
       Set<Character> set = new HashSet<>();
       while(i<n && j<n){
           if(!set.contains(s.charAt(j))){
               set.add(s.charAt(j++));
               ans = Math.max(ans,j-i);
           }else{
               set.remove(s.charAt(i++));
           }
       }
       return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public int getMaxSum(int[] v,int n) {
        int maxSum = 0;
        for(int i = 0;i<n;i++){
            maxSum += v[i];
        }
        int nextMaxSum = maxSum;
        for(int i = n;i<v.length;i++){
            nextMaxSum =  nextMaxSum - v[i-n]+v[i];
            maxSum = Math.max(nextMaxSum,maxSum);
        }
        return maxSum;
    }

    public int search(int[] nums, int target) {
        int i=0,j = nums.length -1;
        while(i<=j){
            int half = (i+j)/2;
            if(nums[half] == target) {
                return half;
            }
            if(nums[half] > target)  j = half-1;
            else i = half+1;
        }
        return -1;
    }

//    public int guessNumber(int n) {
//        int i=1,j=n;
//        while(i<=j){
//            int mid = i+(j-i)/2;
//            int result = guess(mid);
//            if(result == 0) return mid;
//            if(result < 0)  j = mid-1;
//            else i = mid+1;
//        }
//        return -1;
//    }

    public int mySqrt(int x) {
        long i=0,j = x;
        while(i<j){
            long half =(i+j+1)>>>1;
            long mul =half * half;
            if(mul > x)  j = half-1;
            else {
                i = half;
            }
        }
        return (int)i;
    }

    public void reverseString(char[] s) {
        if(s==null || s.length == 0 )return;
        print(0,s);
    }

    public void print(int index ,char[] s) {
        if(s.length <= index) return;
        print(index+1,s);
        System.out.print(s[index]);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null ) return null;
        return  swap(head);
    }
    public  ListNode swap(ListNode node){
        if(node.next !=null){
            ListNode next =node.next;
            if(next.next!=null)
                node.next=swap(next.next);
            else{
                node.next = null;
            }
            next.next = node;
            return next;
        }else{
            return node;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next =  new ListNode(2);
        l1.next.next =  new ListNode(3);
        l1.next.next.next =  new ListNode(4);
//        ListNode l2 = new ListNode(9);
//        l2.next =  new ListNode(9);
//        l2.next.next =  new ListNode(4);
//        ListNode result = solution.addTwoNumbers(l1,l2);

//        solution.lengthOfLongestSubstring2("asjrgapa");

//        int[] v = new int[]{-3, 3, 1, -3, 2, 4, 7};
//        int maxSum = solution.getMaxSum(v,3);
//        System.out.println(maxSum);

//        solution.lengthOfLongestSubstring3("abcaedfg");
//        int[] nums = new int[]{-1,0,3,5,9,12};
//        int target = 2;
//        System.out.println(solution.search(nums,target));
//        System.out.println(solution.mySqrt(2147395599));
//        solution.swapPairs(l1);
//        List<Integer> a  = new ArrayList<>();
//        User  user = new User();
//        user.setUserName("");
//        Optional<User> opt = Optional.ofNullable(user);
//        String userName = opt.map(User::getUserName).orElse(new String("123124"));
//
//        ImmutableList<String> immutableList = ImmutableList.of("1","3");
//        System.out.println(userName);
    }



}
