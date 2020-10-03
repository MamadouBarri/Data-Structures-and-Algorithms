import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {



    // Insertion sort: O(N^2)
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort(AnyType [] a) {
        int j;

        for(int p = 1; p < a.length;p++) {
            AnyType tmp = a[p];
            for(j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0;j--){
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void merge( AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd )
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftEnd  + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd)
        {
            if(a[leftPos].compareTo(a[rightPos]) < 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];
        }

        while(rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];

        while(leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];

        for(int i = 0; i < numElements; i++, rightEnd--){
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
    // Merge sort: O(NlogN)
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType [] a, AnyType[] temp , int low, int high) {

        // Base case
        if(low == high){
            return;
        }

        int mid = (low + high)/2;
        mergeSort(a, temp, low, mid);
        mergeSort(a, temp,mid + 1, high);
        merge(a ,temp, low, mid + 1, high);
    }


    public static void main(String [] args) {
        Integer[] arr = {13, -34, 2342, -3, 0};
        insertionSort(arr);
        System.out.println("Insertion sort: " + Arrays.toString(arr));
        arr = new Integer[]{13, -34, 2342, -3, 0};
        Integer[] temp = new Integer[5];
        mergeSort(arr, temp,0, arr.length - 1);
        System.out.println("Merge sort: " + Arrays.toString(arr));
    }
}
