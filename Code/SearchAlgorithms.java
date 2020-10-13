import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
public class SearchAlgorithms {
    final static int MAX_CAPACITY = 20;
    final static int NUM_TESTS = 10;
    static int[] data;
    public static void main(String[] args) {

        fillRandomData();

        //displayData(data);

        System.out.println("Data size: "+MAX_CAPACITY+"\n");

        runTests();

        //System.out.println("Linear: "+ linearSearch(data, 9));

        //System.out.println("Binary: "+ binarySearch(data, 9));

        //System.out.println("Linear: "+ linearSearch(data, 9));
    }

    public static void fillRandomData() {
        data = new int[MAX_CAPACITY];

        ArrayList<Integer> nums = new ArrayList<Integer>(MAX_CAPACITY);
        for(int i=0; i<MAX_CAPACITY; i++) {
            nums.add(i);
        }

        for(int i=MAX_CAPACITY-1; i>=0; i--) {
            data[i] = nums.remove(randomInt(i));
        }
    }

    public static int randomInt(int i) {
        if(i == 0) {
            return 0;
        }
        else {
            return (int)(Math.floor(Math.random() * (i+1)));
        }
    }

    public static void displayData(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\n");
    }

    public static int linearSearch(int[] data, int target) {
        int steps = 0;
        for(int i=0; i<data.length; i++) {
            steps++;
            if(data[i] == target) {
                // Found!
                return steps;
            }
        }
        return 99999;
    }

    public static int binarySearchIterative(int[] data, int target) {
        int[] arr = Arrays.copyOf(data, data.length);
        Arrays.sort(arr);
        int steps = 0;
        boolean found = false;

        int mid=0, low=0, high=arr.length-1;

        while(!found) {
            if(low > high) {
                return 99999;
            }

            mid = low + ((high-low)/2);
            steps++;

            if(arr[mid] == target) {
                found = true;
                return steps;
            }
            else if(arr[mid] > target) {
                high = mid-1;
                continue;
            }
            else if(arr[mid] < target) {
                low = mid+1;
                continue;
            }
        }
        return steps;
    }

    public static int binarySearchRecursive(int[] data, int target) {
        int[] arr = Arrays.copyOf(data, data.length);
        Arrays.sort(arr);
        return recursiveSort(arr, target, 0);
    }

    public static int recursiveSort(int[] data, int target, int steps) {
        if(data.length < 2) {
            if(data[0] == target) {
                return steps;
            }
            else {
                return 99999;
            }
        }
        else {
            int mid = data.length / 2;
            steps++;
            if(data[mid] == target) {
                return steps;
            }
            else if(data[mid] < target) {
                return recursiveSort(Arrays.copyOfRange(data, mid+1, data.length), target, steps);
            }
            else {
                return recursiveSort(Arrays.copyOfRange(data, 0, mid), target, steps);
            }
        }
    }

    public static void runTests() {
        int linSteps=0;
        int binItSteps=0;
        int binRecSteps=0;
        int target;

        for(int i=0; i<NUM_TESTS; i++) {
            fillRandomData();
            target = (int)(Math.floor(Math.random() * (MAX_CAPACITY)));

            linSteps += linearSearch(data, target);
            binItSteps += binarySearchIterative(data, target);
            binRecSteps += binarySearchRecursive(data, target);
        }

        System.out.println("Linear Search Average Steps: " + ((double)linSteps / NUM_TESTS));
        System.out.println("Iterative Binary Search Average Steps: " + ((double)binItSteps / NUM_TESTS));
        System.out.println("Recursive Binary Search Average Steps: " + ((double)binRecSteps / NUM_TESTS));
    }
}
