import java.util.ArrayList;
import java.util.Stack;
public class StairCaseInterview {

    // Staircase - How many different ways(paths) can you get to top of stairs if at each step you can go up one stair or two stairs?
    public static void main(String[] args) {
        int topStep = 5;

        int maxStep = 3;

        Stack<Stair> stairs = new Stack<Stair>();
        stairs.add(new Stair(0, new ArrayList<Integer>()));

        int pathCount = 0;

        while(!stairs.empty()) {
            Stair currStep = stairs.pop();

            if(currStep.number == topStep) {
                // Top step!!
                pathCount++;
                System.out.println(currStep.visited.toString());
                continue;
            }
            else {

                for(int i=1; i<=maxStep; i++) {
                    int newStep = currStep.number + i;
                    if(newStep <= topStep) {
                        stairs.add(new Stair(newStep, currStep.visited));
                    }
                }
            }
        }
        System.out.println("Path count: "+pathCount);
    }
    
}
