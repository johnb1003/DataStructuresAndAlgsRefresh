import java.util.ArrayList;
import java.util.Arrays;
public class SortingAlgorithms {
    final static int MAX_CAPACITY = 1000;
    final static int NUM_TESTS = 10;
    static int[] data;

    public static void main(String[] args) {
        fillRandomData();
        runTests();
    }

    public static int[] bubbleSort(int[] arr) {
        int temp;
        for(int i=arr.length-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                // out of order
                if(arr[j] > arr[j+1]) {
                    // swap
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int minIndex;
        int temp;
        for(int i=0; i<arr.length-1; i++) {
            minIndex=i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static int[] quickSort(int[] arr) {
        return recursiveQuickSort(arr, 0, arr.length-1);
    }

    public static int[] recursiveQuickSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int pivot = arr[mid];
        int leftProbe=low, rightProbe=high;
        int temp;

        // Partition values around pivot (all smaller values to the left of pivot, bigger vlues to the right of pivot)
        while(leftProbe <= rightProbe) {
            // Find value left of pivot that is greater than pivot value
            while(arr[leftProbe] < pivot) {
                leftProbe++;
            }
            // Find value right of pivot that is less than pivot value
            while(arr[rightProbe] > pivot) {
                rightProbe--;
            }
            // Swap if probes are still on correct sides of pivot
            if(leftProbe <= rightProbe) {
                temp = arr[leftProbe];
                arr[leftProbe] = arr[rightProbe];
                arr[rightProbe] = temp;
                leftProbe++;
                rightProbe--;
            }
        }

        if(low < rightProbe) {
            arr = recursiveQuickSort(arr, low, rightProbe);
        }

        if(high > leftProbe) {
            arr = recursiveQuickSort(arr, leftProbe, high);
        }
        
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        return recursiveMergeSort(arr, arr.length);
    }

    public static int[] recursiveMergeSort(int[] arr, int len) {
        if(len < 2) {
            return arr;
        }

        int mid = len / 2;
        int[] left = new int[mid];
        int leftIndex = 0;
        int[] right = new int[len-mid];
        int rightIndex = 0;

        for(int i=0; i<len; i++) {
            if(i < mid) {
                left[leftIndex++] = arr[i];
            }
            else {
                right[rightIndex++] = arr[i];
            }
        }
        left = recursiveMergeSort(left, mid);
        right = recursiveMergeSort(right, len-mid);
        return merge(left, right, arr, mid, len-mid);
    }

    // [ 1, 2, 3, 0 ]
    // [1, 2] [3, 0]
    // [1] [2] [3] [0]
    // [1, 2] [0, 3]
    // [ 0, 1, 2, 3 ]

    public static int[] merge(int[] left, int[] right, int[] arr, int leftLen, int rightLen) {
        int leftProbe=0, rightProbe=0, i = 0;

        while(leftProbe < leftLen && rightProbe < rightLen) {
            if(left[leftProbe] < right[rightProbe]) {
                arr[i++] = left[leftProbe++];
            }
            else {
                arr[i++] = right[rightProbe++];
            }
        }

        while(leftProbe < leftLen) {
            arr[i++] = left[leftProbe++];
        }

        while(rightProbe < rightLen) {
            arr[i++] = right[rightProbe++];
        }

        return arr;
    }

    public static int[] heapSort(int[] arr) {
        int heapSize = arr.length;

        // Sort array into max-heap
        // i=(heapSize/2)-1  corresponds to indices that are not in bottom row --> save time by only comparing nodes that have children
        for(int i=(heapSize/2)-1; i>=0; i--) {
            arr = heapify(arr, heapSize, i);
        }

        for(int i=heapSize-1; i>=0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Trickle down new root with heapify
            arr = heapify(arr, i, 0);
        }

        return arr;
    }

    public static int[] heapify(int[] arr, int heapSize, int root) {
        int max = root;
        int leftChild = 2*root + 1;
        int rightChild = 2*root + 2;

        if(leftChild < heapSize && arr[leftChild] > arr[max]) {
            max = leftChild;
        }

        if(rightChild < heapSize && arr[rightChild] > arr[max]) {
            max = rightChild;
        }

        if(max != root) {
            int temp = arr[root];
            arr[root] = arr[max];
            arr[max] = temp;

            arr = heapify(arr, heapSize, max);
        }

        return arr;
    }

    public static boolean verifySort(int[] arr) {
        //displayData(arr);
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
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

    public static void runTests() {
        System.out.println("\nSORTING TIME TESTS");
        System.out.println("Data size: "+ MAX_CAPACITY +"\t\tNumber of trials: "+ NUM_TESTS +"  \n");

        long startTime;
        long finishTime;
        long bubbleSortTime=0, selectionSortTime=0, quickSortTime=0, mergeSortTime=0, heapSortTime=0;

        int[] sorted;

        for(int i=0; i<NUM_TESTS; i++) {
            fillRandomData();

            startTime = System.nanoTime();
            sorted = bubbleSort(data.clone());
            finishTime = System.nanoTime();
            bubbleSortTime += finishTime - startTime;
            if(!verifySort(sorted)) {
                System.out.println("\n\n!!! INCORRECT BUBBLE SORT !!!\n\n");
            }

            startTime = System.nanoTime();
            sorted = selectionSort(data.clone());
            finishTime = System.nanoTime();
            selectionSortTime += finishTime - startTime;
            if(!verifySort(sorted)) {
                System.out.println("\n\n!!! INCORRECT SELECTION SORT !!!\n\n");
            }
            
            startTime = System.nanoTime();
            sorted = quickSort(data.clone());
            finishTime = System.nanoTime();
            quickSortTime += finishTime - startTime;
            if(!verifySort(sorted)) {
                System.out.println("\n\n!!! INCORRECT QUICK SORT !!!\n\n");
            }
            
            startTime = System.nanoTime();
            sorted = mergeSort(data.clone());
            finishTime = System.nanoTime();
            mergeSortTime += finishTime - startTime;
            if(!verifySort(sorted)) {
                System.out.println("\n\n!!! INCORRECT MERGE SORT !!!\n\n");
            }
            
            startTime = System.nanoTime();
            sorted = heapSort(data.clone());
            finishTime = System.nanoTime();
            heapSortTime += finishTime - startTime;
            if(!verifySort(sorted)) {
                System.out.println("\n\n!!! INCORRECT HEAP SORT !!!\n\n");
            }
        }


        System.out.println("TIMES (nanoseconds):");
        System.out.println("\nAverage Bubble Sort Time: " + (bubbleSortTime/NUM_TESTS));
        System.out.println("\nAverage Selection Sort Time: " + (selectionSortTime/NUM_TESTS));
        System.out.println("\nAverage Quick Sort Time: " + (quickSortTime/NUM_TESTS));
        System.out.println("\nAverage Merge Sort Time: " + (mergeSortTime/NUM_TESTS));
        System.out.println("\nAverage Heap Sort Time: " + (heapSortTime/NUM_TESTS));
        System.out.println("");
    }
}
