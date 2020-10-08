import java.util.Scanner;
public class QueueArrayDemo {
    Scanner scanner;
    public static void main(String[] args) {
        /*
        QueueArrayImpl<Integer> queue = new QueueArrayImpl<Integer>(5);

        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.display();
        */
        new QueueArrayDemo().queueLoop();
    }

    public void queueLoop() {
        int pushNum;
        scanner = new Scanner(System.in);
        System.out.println("Enter queue size: ");

        int size = scanner.nextInt();
        //QueueArrayImpl<Integer> queue = new QueueArrayImpl<Integer>(size);
        QueueLinkedListImpl<Integer> queue = new QueueLinkedListImpl<Integer>();

        String input = "0";

        while(!input.toLowerCase().trim().equals("exit")) {
            System.out.println("Options: \n\t1) Type an integer and hit enter to push that int to the queue\n\t2) Type \"pop\" to pop the first item in the queue\n\t3) Type \"exit\" and hit enter to end this loop\n");
            input = scanner.nextLine();
            if(input.trim().toLowerCase().equals("pop")) {
                System.out.println(queue.pop());
                queue.display();
                continue;
            }
            else if(input.trim().toLowerCase().equals("exit")) {
                scanner.close();
                break;
            }
            
            try {
                pushNum = Integer.parseInt(input.trim());
            }
            catch(Exception e) {
                System.out.println("Invalid Input! Please try again.\n\n");
                continue;
            }

            queue.push(pushNum);
            queue.display();
        }
    }
}
