
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {

        // Ask how many elements to add
        // Use queue.add() to insert elements

    }

    // TODO 2: Display all elements in the Queue
    static void displayQueue() {

        // Display the contents of the Queue

    }

    // TODO 3: Generate all possible permutations
    static void generatePermutations() {

        // Ask how many elements should be selected (r)
        // Generate all possible arrangements
        // Display the total number of permutations

    }

    // TODO 4: Generate all possible combinations
    static void generateCombinations() {

        // Ask how many elements should be selected (r)
        // Generate all possible selections
        // Avoid duplicate combinations
        // Display the total number of combinations

    }
}
