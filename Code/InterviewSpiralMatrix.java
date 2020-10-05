public class InterviewSpiralMatrix {

    public static void main(String[] args) {

        // Print 2D array following a clockwise spiiral pattern
        // Assume each row is same length

        int[][] arr = {
            {1, 2, 3, 4}, 
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        spiralMatrix(arr);
    }

    public static void spiralMatrix(int[][] arr) {
        if(arr.length < 1) {
            return;
        }

        System.out.println(arr[0].length-1);
        System.out.println(arr.length-1);

        int rowFirst = 0;
        int rowLast = arr[0].length-1;
        int colFirst = 0;
        int colLast = arr.length-1;

        int numPrinted = 1;
        int direction = 0;
        while(numPrinted > 0) {
            // right
            if(direction == 0) {
                numPrinted = printRight(arr, rowFirst, colFirst, colLast);
                rowFirst++;
                direction = 1;
            }
            // down
            else if(direction == 1) {
                numPrinted = printDown(arr, colLast, rowFirst, rowLast);
                colLast--;
                direction = 2;
            }
            // left
            else if(direction == 2) {
                numPrinted = printLeft(arr, rowLast, colLast, colFirst);
                rowLast--;
                direction = 3;
            }
            // up
            else if(direction == 3) {
                numPrinted = printUp(arr, colFirst, rowLast, rowFirst);
                colFirst++;
                direction = 0;
            }
        }
    }

    public static int printRight(int[][] arr, int row, int start, int end) {
        int numPrinted = 0;
        for(int i=start; i <= end; i++) {
            System.out.print(arr[row][i] + " ");
            numPrinted++;
        }
        return numPrinted;
    }

    public static int printLeft(int[][] arr, int row, int start, int end) {
        int numPrinted = 0;
        for(int i=start; i >= end; i--) {
            System.out.print(arr[row][i] + " ");
            numPrinted++;
        }
        return numPrinted;
    }

    public static int printDown(int[][] arr, int col, int start, int end) {
        int numPrinted = 0;
        for(int i=start; i <= end; i++) {
            System.out.print(arr[i][col] + " ");
            numPrinted++;
        }
        return numPrinted;
    }

    public static int printUp(int[][] arr, int col, int start, int end) {
        int numPrinted = 0;
        for(int i=start; i >= end; i--) {
            System.out.print(arr[i][col] + " ");
            numPrinted++;
        }
        return numPrinted;
    }
}