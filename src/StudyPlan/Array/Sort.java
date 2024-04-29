package StudyPlan.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(6, 1, 4, 8, 2, 10, 12, 11));
        sort(integers);
        System.out.print(integers);
    }

    static void sort(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }

        Integer i = list.remove(list.size() - 1); //Keep removing the last element
        sort(list);
        merge(list, i); // merge when base case hit.
    }

    static void merge(List<Integer> list, int temp) {
        //add element when condition satisfy
        if (list.size() == 0 || temp >= list.get(list.size() - 1)) {
            list.add(temp);
            return;
        }
        Integer remove = list.remove(list.size() - 1); //else keep removing element.
        merge(list, temp);
        list.add(remove); //lastly add the removed.
    }

    static void sort(List<Integer> list, int start, int end) {
        if (list.size() == 1) {
            return;
        }
        int mid = (start + end) / 2;
        List<Integer> startList = list.subList(start, mid);
        List<Integer> endList = list.subList(mid + 1, end);
        sort(endList, start, mid);
        sort(list.subList(mid + 1, end), mid + 1, end);

        merge(startList, endList); // merge when base case hit.
    }

    static List<Integer> merge(List<Integer> start, List<Integer> end) {
        if (start.size() == 0) {
            return end;
        } else if (end.size() == 0) {
            return start;
        }
        return null;
    }

}
