public class ArrayInterviewQuestion {

    // Question:
    // Find longest sequence of 1's in array of 1's and 0's with one flip (flip = change one 0 to a 1)

    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1};

        System.out.println(longestSequence(arr));
    }

    public static int longestSequence(int[] arr) {
        int lastStreak = 0;
        int currStreak = 0;
        int maxStreak = 0;

        for(int i=0; i<arr.length; i++) {
            int num = arr[i];
            if(num == 1) {
                currStreak++;
            }
            else if(num == 0) {
                if(currStreak + lastStreak + 1 > maxStreak) {
                    maxStreak = currStreak + lastStreak + 1;
                }
                lastStreak = currStreak;
                currStreak = 0;
            }
        }

        return Math.max(maxStreak, currStreak + lastStreak + 1);
    }
}