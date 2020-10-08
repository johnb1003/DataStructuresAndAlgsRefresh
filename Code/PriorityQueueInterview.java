import java.util.PriorityQueue;
import java.util.ArrayList;
public class PriorityQueueInterview {
    // Get K top rated movies from a list of ratings.
    public static void main(String[] args) {
        int[] movieRatings = {3, 4, 5, 2, 4, 5, 1, 1, 2};
        int k = 3;

        ArrayList<Integer> topKRatings = new PriorityQueueInterview().kTopRated(movieRatings, k);
        topKRatings.forEach(element -> {
            System.out.print(element+" ");
        });
        System.out.println("");
    }

    public ArrayList<Integer> kTopRated(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int rating : arr) {
            queue.add(rating);
            if(queue.size() > k) {
                // Remove smallest
                queue.poll();
            }
        }

        ArrayList<Integer> topKRatings = new ArrayList<Integer>(queue);

        return topKRatings;
    }
}
