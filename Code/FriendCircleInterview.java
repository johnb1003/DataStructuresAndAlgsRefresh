import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
public class FriendCircleInterview {
    // Given adjacency matrix of friendships (2-way), return list of friend circles.
    public static void main(String[] args) {
        int[][] friendsArr = {
            {1, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 1}
        };

        ArrayList<ArrayList> friendCircles = new FriendCircleInterview().getCircles(friendsArr);

        friendCircles.forEach( (circle) -> {
            System.out.print("Circle: [  ");
            for(int i=0; i<circle.size(); i++) {
                System.out.print(circle.get(i) + "  ");
            }
            System.out.println("]\n\n");
        });
    }

    public ArrayList<ArrayList> getCircles(int[][] arr) {
        //System.out.println("arr.length: "+arr.length);
        ArrayList<Integer> unvisited = new ArrayList<Integer>();
        for(int i=0; i< arr.length; i++) {
            unvisited.add(i);
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<ArrayList> circles = new ArrayList<ArrayList>();

        queue.addLast(unvisited.remove(0));
        int currFriend;
        while(!unvisited.isEmpty() || !queue.isEmpty()) {
            ArrayList<Integer> circle = new ArrayList<Integer>();
            while(!queue.isEmpty()) {
                //System.out.println("queue: " + printQueue(queue));
                currFriend = queue.removeFirst();
                //System.out.println("currFriend: " + currFriend);
                if(!visited.contains(currFriend)) {
                    circle.add(currFriend);

                    for(int i=0; i<arr[currFriend].length; i++) {
                        //System.out.println("Row: "+currFriend+ "\tColumn: "+i+"\tValue: "+ arr[currFriend][i]);
                        if(i != currFriend && arr[currFriend][i] == 1 && !visited.contains(i)) {
                            //System.out.println(queue.size());
                            //System.out.println("ADD");
                            queue.addLast((Integer) i);
                            //System.out.println(queue.size());
                        }
                    }
                }
                visited.add(currFriend);
                unvisited.remove((Integer)currFriend);
            }
            circles.add(circle);
            if(visited.size() != arr.length) {
                queue.addLast(unvisited.remove(0));
            }
        }

        return circles;
    }

    public String printQueue(LinkedList<Integer> l) {

        LinkedList<Integer> list = (LinkedList) l.clone();

        String str = "[";
        
        while(!list.isEmpty()) {
            str += list.remove() + " ";
        }
        
        str += "]";
        return str;
    }
}
