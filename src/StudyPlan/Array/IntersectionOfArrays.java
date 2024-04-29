package StudyPlan.Array;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(args);
        IntersectionOfArrays ofArrays = new IntersectionOfArrays();
        ofArrays.intersect(new int[]{2,4,3,2,1},new int[]{9,6,8,7});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
       return nums1.length > nums2.length ?  find(nums1,nums2) : find(nums2,nums1);
    }

    public int[] find(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        for(int n : nums2){
            if(collect.remove((Integer) n)){
                list.add(n);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
