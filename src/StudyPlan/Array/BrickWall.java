package StudyPlan.Array;

import java.util.ArrayList;
import java.util.List;

public class BrickWall {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        wall.add(a);
        wall.add(b);
        wall.add(c);
        a.add(1);
        b.add(1);
        c.add(1);
        int i = new BrickWall().leastBricks(wall);
        System.out.println(i);
    }

    public int leastBricks(List<List<Integer>> wall) {
        int leastWall = Integer.MAX_VALUE;
        List<Integer> integers = wall.get(0);
        int size = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        for (int i = 0; i < size; i++) {
            int obs = 0;
            for (List<Integer> w : wall) {
                int sum = 0;
                for (int win = 0; win < w.size(); win++) {
                    sum += w.get(win);
                    if (sum > i) {
                        ++obs;
                        break;
                    } else if (sum == i) {
                        break;
                    }
                }
            }
            leastWall = Math.min(leastWall, obs);
        }
        return leastWall;
    }

}
