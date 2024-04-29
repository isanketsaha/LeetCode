package StudyPlan.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> generate = pascalTriangle.generate(1);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (result.size() > 0) {
                    List<Integer> integers = result.get(result.size() - 1);
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(integers.get(j-1)+integers.get(j));
                    }
                } else {
                    row.add(1);
                }
            }
            result.add(row);

        }
        return result;
    }
}
