package StudyPlan.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Can you solve it without sorting?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class KthLargest {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        System.out.print(kthLargest.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : nums)
            pq.offer(n);
        while (k > 0) {
            pq.poll();
            --k;
        }
        return  pq.poll();
    }
}
