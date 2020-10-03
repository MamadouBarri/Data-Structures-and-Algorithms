import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListInterface {

    // O(N) version
    public static void removeEvens(List<Integer> lst) {

        Iterator<Integer> it = lst.iterator();

        while(it.hasNext())
        {
            if(it.next() % 2 == 0)
                it.remove();
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        removeEvens(nums);
        System.out.println("No even values: " + nums);
    }
}
