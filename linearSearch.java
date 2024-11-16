package begL.smallP;

public class linearSearch {
    public static void main(String[] args) {
        int[] nums = {23, 45, 21, 20, -3, 16, -11};
        int target = 45;
        int ans = lsearch1(nums, target);
        boolean ans1 = lsearch3(nums, target);
        int ans2 = lsearch2(nums, target);

        System.out.println(ans+"+"+  ans2 +"+"+ ans1);

    }

    static boolean lsearch3(int[] arr, int target) {
        for (int element : arr) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }

    static int lsearch2(int[] arr, int target) {
        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        return -1;
    }

    static int lsearch1(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int index =0;index<arr.length;index++) {
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        return -1;
    }
}
