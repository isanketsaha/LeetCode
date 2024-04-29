package StudyPlan.Array;

public class MountainArray {

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray();
        boolean b = mountainArray.validMountainArray(new int[]{0, 1, 2, 4, 2, 1});
        System.out.println(b);
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length >= 3) {
            int mid = arr.length % 2 == 0 ? (arr.length / 2) - 1 : (arr.length / 2);
            for (int i = 0; i < arr.length - 1; i++) {
                if ((i <= mid - 1 && (arr[i] > arr[i + 1] || arr[i] == arr[i + 1])) || (i >= mid && (arr[i] < arr[i + 1] || arr[i] == arr[i + 1]))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
