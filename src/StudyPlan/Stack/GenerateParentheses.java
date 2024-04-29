package StudyPlan.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> objects = new ArrayList<>();
         generate(objects, n, 0, 0, "");
        System.out.println(objects);
        return null;
    }

    public void generate(ArrayList<String> objects, int n, int open, int closed, String s) {
        if (s.length() == n * 2) {
            System.out.printf("Adding = %s", s);
            objects.add(s);
            return;
        }
            System.out.printf("Start = %s , End = %s \n", open, closed);
            if (open < n) {
                generate(objects, n, open + 1, closed, s+"(");
            }
            if (closed < open) {
                generate(objects, n, open, closed + 1, s+")");
            }

//        if (open < n) {
//            generate(res, n, open+1, closed, s+"(");
//        }
//        if (closed < open) {
//            generate(res, n, open, closed+1, s+")");
//        }

    }
}
