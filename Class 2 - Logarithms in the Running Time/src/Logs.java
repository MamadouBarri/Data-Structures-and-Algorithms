public class Logs {

    public static <AnyType extends Comparable<? super AnyType>> int binarySearch(AnyType [] arr, AnyType x){
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
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-100, 1, 2, 3, 4, 5, 6, 10, 46};
        System.out.println( "Index: " + binarySearch(arr, -100));
    }
}
