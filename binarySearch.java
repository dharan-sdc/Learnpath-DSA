package begL.smallP;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr= {-18,-12,0,2,3,67,78};
        int target=67;
        int ans = binsearch(arr, target);
        System.out.println(ans);
    }

     static int binsearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (target < arr[mid]) {
                end=mid-1;
            } else if (target > arr[mid]) {
                start=mid+1;
            }else return mid;
        }
        return -1;
    }

}
