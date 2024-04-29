package StudyPlan.Array;

public class NumberOfBalloons {

    public static void main(String[] args) {
        int i = new NumberOfBalloons().maxNumberOfBalloons("nlaebolko");
        System.out.print(i);
    }

    public int maxNumberOfBalloons(String text) {

        int[] lookup = new int[5];
        int count = Integer.MAX_VALUE;

        for (Character l : text.toCharArray()) {
            if ("balloon".contains(String.valueOf(l))) {
                int i = "balon".indexOf(l);
                lookup[i] += 1;
            }
        }
        for (int v : lookup) {
            count = Math.min(count, v);
        }
        return lookup[2] >= count * 2 && lookup[3] >= count * 2 ? count : Math.min(lookup[3] / 2, lookup[2] / 2);
    }
}
