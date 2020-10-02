public class Logs
{

    // Binary Search Algorithm in O(logN) with sorted input
    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType [] arr, AnyType x)
    {
        int res = -1;
        int low = 0, high = arr.length - 1;
        while(low <= high)
        {
            // divide array
            int mid = (low + high) /2;

            // check if x in mid
            if(arr[mid].compareTo(x) < 0){
                low = mid + 1;
            } else if(arr[mid].compareTo(x) > 0){
                high = mid - 1;
            } else{
                return mid;
            }
        }
        return res;
    }

    // Computing GCD with Euclid's Algorithm
    public static long gcd(long m, long n)
    {
        while(n != 0)
        {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-100, 1, 2, 3, 4, 5, 6, 10, 46};
        System.out.println( "Binary Search: " + (binarySearch(arr, -100) == 0));
    }
}
