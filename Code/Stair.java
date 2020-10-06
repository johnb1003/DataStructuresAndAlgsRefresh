import java.util.ArrayList;
public class Stair {
    int number;
    ArrayList<Integer> visited;

    public Stair(int number, ArrayList<Integer> path) {
        this.number = number;
        this.visited = new ArrayList<Integer>();
        this.visited.addAll(path);
        this.visited.add(this.number);
    }
}
