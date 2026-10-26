import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Prompt the user first
        System.out.print("Enter your name: ");

        // 2. Declare a String variable and read the input
        String name = sc.nextLine();

        // 3. Print the final result
        System.out.println("Hello, " + name + "!");

        // Good practice: close the scanner when done
        sc.close();
    }
}