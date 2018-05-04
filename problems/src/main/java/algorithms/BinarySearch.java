package algorithms;

public class BinarySearch {


    private static int binarySearch(int[] arr, int target){

        int l = 0, r = arr.length - 1;
        while(l <= r){

            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;

        System.out.println(binarySearch(arr, x));
    }
}
