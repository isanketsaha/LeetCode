package StudyPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class test {


    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        for (int pile : piles) {
            if (high < pile)
                high = pile;
        }
        return bSearch(piles, h, 1, high);
    }

    public int bSearch(int[] piles, int h, int start, int end) {
        int cal = 0;
        int mid = (start + end) / 2;
        for (int pile : piles) {
            if (pile % mid == 0) {
                cal += (pile / mid);
            } else {
                cal += (pile / mid) + 1;
            }

        }
        if (cal == h) {
            return cal;
        }
        if (cal < h) {
            return bSearch(piles, h, start, mid - 1);
        } else {
            return bSearch(piles, h, mid + 1, end);
        }
    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2);
//        ListNode head = new ListNode(1);
//       head.next = listNode1;
//        ListNode listNode = new ListNode(3);
//        listNode.next = new ListNode(4);
//        listNode1.next = listNode;
//         new test().reorderList(head);
//        System.out.print(head);
//        List<List<Integer>> subsets = new test().subsets(new int[]{1, 2, 3});
        System.out.print(new test().convert("PAYPALISHIRING", 4));


    }

    public String convert(String s, int numRows) {
        char[][] list = new char[numRows][numRows/2];
        int row = 0 , col = 0;
        boolean isStraight = true;
        for(Character c : s.toCharArray()){
            list[row][col] = c ;
            if(isStraight){
                row++;
                if(numRows == row){
                    col++;
                    isStraight =  false;
                }
            }
            else{
                row--;
                col++;
            }
            if(col == 0){
                isStraight = true;
            }

        }

        System.out.println(list);
        return "";
    }


    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length; i++){

        }
        return result;
    }

    public int pivotIndex(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        int sumi = nums[i] , sumj =  nums[j];
        while(i<j){
            if(sumj == 0){
                return i;
            }
            else if(sumi == 0){
                return j;
            }
            else if(sumi < sumj){
                ++i;
                sumi += nums[i];
            }
            else if(sumi > sumj){
                --j;
                sumj += nums[j];
            }else if(sumi == sumj && i+1 != j){
                return i+1;
            }
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer ,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            map.put(nums1[i], i);
            result[i] = -1;
        }

        for(int j = 0 ; j < nums2.length ; j++){
            if(map.containsKey(nums2[j])){
                int index = j+1;
                while(nums2[j] > nums2[index]){
                    ++index;
                }
                result[map.get(nums2[j])] = nums2[index];

            }
        }
        return result;

    }

    public int[] plusOne(int[] digits) {
        String value = "";
        for(int j : digits){
            value += j;
        }
        long result = Long.valueOf(value) + 1;
        int[] arr = new int[String.valueOf(result).length()];
        int indexFromEnd = arr.length - 1;
        while(indexFromEnd >= 0){
            long j = result % 10;
            arr[indexFromEnd] = (int)j;
            indexFromEnd--;
            result = result/10;
        }
        return arr;
    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(0, nums.length ,nums, target);
    }

    public int searchInsert(int start , int end , int[] nums, int target) {
        if(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
              return  searchInsert(mid + 1, end ,nums, target);
            }else {
               return searchInsert(start, mid - 1 ,nums, target);
            }
        }
        return end < 0 ? start :  end;
    }


    public int strStr(String haystack, String needle) {

        for(int i=0 ; i < haystack.length() ; i++) {
            if(haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i+ needle.length()-1).equals(needle)){
                return i;
            }
        }
        return -1;
    }
    public boolean canJump(int[] nums) {
        Stack<String> stack = new Stack<>();
        stack.push(nums[0] + "#" + 0);
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            String[] split = pop.split("#");
            Integer prevIndex = Integer.valueOf(split[1]);
            for (int i = prevIndex; i < Math.min(Integer.valueOf(split[0]) + prevIndex, nums.length); i++) {
                int currentValue = nums[i];
                if ((currentValue + i + 1) - nums.length == 0) {
                    return true;
                } else if ((currentValue + i < nums.length - 1) && currentValue + i != 0) {
                    stack.push(nums[currentValue + i] + "#" + i);
                }
            }
        }
        return false;
    }

    public boolean canJump(int[] nums, int k) {
        if ((k + 1) - nums.length == 0) {
            return true;
        } else if (nums[k] > nums.length - 1 || (nums[k] + k > nums.length || nums[k] == 0)) {
            return false;
        }
        return canJump(nums, nums[k] + k);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        subsets(nums, list, sublist, 0);
        return list;
    }

    public void subsets(int[] nums, List<List<Integer>> list, List<Integer> sublist, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[index]);
        subsets(nums, list, sublist, index + 1);

        sublist.remove(sublist.size() - 1);
        subsets(nums, list, sublist, index + 1);

    }

    ListNode prev = null;

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        prev.next = null;
        reverse(slow);
        slow = head;
        ListNode tmp = null;
        while (prev != null) {
            if (tmp == null) {
                tmp = head.next;
                head.next = prev;

            } else {
                head.next = tmp;
                tmp = tmp.next;
                tmp.next = prev;
            }
            head = prev;
            prev = prev.next;
        }
        System.out.print(slow);
    }

    public ListNode reverse(ListNode node) {
        if (node.next == null) {
            prev = node;
            return node;
        } else {
            ListNode tmp = reverse(node.next);
            tmp.next = node;
            node.next = null;
            return node;
        }
    }

    public int characterReplacement(String s, int k) {
        int window = 1, maxWindow = 0;
        int index = 1;
        int prev = -1;
        int reset = k;
        char[] alpha = s.toCharArray();
        char matcher = alpha[0];
        while (index < s.length()) {
            if (alpha[index] == matcher) {
                window += 1;
            } else if (reset > 0) {
                reset -= 1;
                window += 1;
                prev = index;
            } else if (prev >= 0) {
                matcher = alpha[prev];
                index = prev;
                maxWindow = Math.max(window, maxWindow);
                window = 1;
                reset = k;
            } else {
                maxWindow = Math.max(window, maxWindow);
            }
            index += 1;
        }
        return Math.max(window, maxWindow);
    }
}
