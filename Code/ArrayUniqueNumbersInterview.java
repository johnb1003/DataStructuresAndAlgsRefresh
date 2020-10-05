import java.util.ArrayList;
import java.util.HashSet;
public class ArrayUniqueNumbersInterview {

    // From an array of ints, return a list of ints that only occur once
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 6, 6, 7, 8, 10, 10};

        ArrayList<Integer> unique = uniqueNums(nums);

        System.out.println(unique.toString());
    }

    public static ArrayList<Integer> uniqueNums(int[] nums) {
        //HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        HashSet<Integer> uniqueNums = new HashSet<Integer>();
        for(int num : nums) {
            //Integer frequency = frequencies.get(num);
            if(!uniqueNums.remove(num)) {
                // new num
                uniqueNums.add(num);
            }
        }

        uniqueNums.forEach((e) -> {
            numbers.add(e);
        });
        return numbers;
    }
    
}
