package algorithms;

import utils.io.Print;


public class Sorting {

    /**
     * BubbleSort (S -> L)
     *
     * @param arr
     */
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i ++)
            for(int j = 0; j < n - i - 1; j ++)
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
    }

    /**
     *
     * never makes more than O(n) swap
     *
     */
    void selectionSort(int arr[]) {
        int n = arr.length, min = -1;
        for(int i = 0; i < n - 1; i ++){
            min = i;
            for(int j = i + 1; j < n; j ++)
                if(arr[j] < arr[min]){
                    min = j;
                }
            swap(arr, min, i);
        }
    }


     // Stable
     // O(n) with almost sorted array
    void insertionSort(int arr[]){
        int n = arr.length, key = -1, j = -1;
        for(int i = 1; i < n; i ++){
            key = arr[i];
            j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = key;
        }
    }
    // stable: true
    // best use case: list sort
    void mergeSort(int arr[]){
        mSort(arr, 0, arr.length - 1);
    }

    private void mSort(int arr[], int lo, int hi){
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2;

        // divide
        mSort(arr, lo, mid);
        mSort(arr, mid + 1, hi);

        // conquer
        merge(arr, lo, mid, hi);
    }

    private void merge(int arr[], int lo, int mid, int hi){

        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.arraycopy(arr, lo, arr1, 0, n1);
        System.arraycopy(arr, mid + 1, arr2, 0, n2);

        int i = 0, j = 0, k = lo;
        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                arr[k] = arr1[i];
                i ++;
            } else {
                arr[k] = arr2[j];
                j ++;
            }
            k ++;
        }

        if(i < n1) System.arraycopy(arr1, i, arr, k, n1 - i);
        if(j < n2) System.arraycopy(arr2, j, arr, k, n2 - j);
    }

    // best use case: array sort
    // stable: false
    void quickSort(int[] arr){
        qSort(arr, 0, arr.length - 1);
    }

    private void qSort(int[] arr, int lo, int hi){
        if(lo >= hi) return;

        // divide
        int p = partition(arr, lo, hi);

        // conquer
        qSort(arr, lo, p - 1);
        qSort(arr, p + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi, p = arr[hi];
        while(i < j){
            if(arr[i] > p){
                swap(arr, i, --j);
            } else {
                i ++;
            }
        }
        swap(arr, i, hi);
        return i;
    }


    private void swap(int[] arr, int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // Driver method to test above
    public static void main(String args[])
    {
        Sorting ob = new Sorting();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        Print.intArray(arr);

        arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        ob.selectionSort(arr);
        System.out.println("Sorted array");
        Print.intArray(arr);

        arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        ob.insertionSort(arr);
        System.out.println("Sorted array");
        Print.intArray(arr);

        arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        ob.mergeSort(arr);
        System.out.println("Sorted array");
        Print.intArray(arr);

        arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        ob.quickSort(arr);
        System.out.println("Sorted array");
        Print.intArray(arr);
    }
}
