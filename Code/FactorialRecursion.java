import java.util.Scanner;
public class FactorialRecursion {
    // Factorial calculator
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        while(num > 0) {
            System.out.println("Factorial of "+num+" is "+new FactorialRecursion().factorial(num)+"\n");
            System.out.println("Fibonacci number "+num+" is "+new FactorialRecursion().fibonacci(num)+"\n\n");

            System.out.println("Enter a new number: ");
            num = scan.nextInt();
        }
    }

    public int factorial(int num) {
        if(num <= 1) {
            return 1;
        }
        else {
            return num * factorial(num-1);
        }
    }

    public int fibonacci(int num) {
        if(num <= 1) {
            return 0;
        }
        else if(num == 2) {
            return 1;
        }
        else {
            return fibonacci(num-1) + fibonacci(num-2);
        }
    }
}
