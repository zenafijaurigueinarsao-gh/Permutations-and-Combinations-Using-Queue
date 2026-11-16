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
            System.out.println("[6] Dequeue Two Elements");
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
 
                case 6:
                    dequeueTwo();
                    break;
 
                default:
                    System.out.println("Invalid choice!");
            }
 
        } while (choice != 5);
    }
 
    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {
 
        System.out.print("How many elements to add? ");
        int n = input.nextInt();
 
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            queue.add(input.next());
        }
 
        System.out.println("Elements enqueued.");
    }
 
    // TODO 2: Display all elements in the Queue
    static void displayQueue() {
 
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
 
        System.out.println("Queue: " + queue);
        System.out.println("Front element: " + queue.peek());
    }
 
    static void dequeueTwo() {
 
        for (int i = 0; i < 2; i++) {
            if (queue.isEmpty()) {
                System.out.println("Queue is empty. Nothing more to dequeue.");
                break;
            }
            System.out.println("Dequeued: " + queue.poll());
        }
 
        System.out.println("Queue now: " + queue);
    }
 
    static String[] toArray() {
        String[] items = new String[queue.size()];
        int i = 0;
        for (String s : queue) {
            items[i++] = s;
        }
        return items;
    }
 
    static int readR(int n, String verb) {
        System.out.print("\nEnter number of elements to " + verb + ": ");
        int r = input.nextInt();
        System.out.println();
 
        if (r < 1 || r > n) {
            System.out.println("Invalid number. Must be between 1 and " + n + ".");
            return -1;
        }
        return r;
    }
 
    static String build(int[] path, String[] items) {
        StringBuilder sb = new StringBuilder();
        for (int p : path) {
            sb.append(items[p]);
        }
        return sb.toString();
    }
 
    // TODO 3: Generate all possible permutations
    static void generatePermutations() {
 
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
 
        String[] items = toArray();
        System.out.println("Queue: " + queue);
 
        int r = readR(items.length, "arrange");
        if (r == -1) return;
 
        Queue<int[]> work = new LinkedList<>();
        work.add(new int[0]);
 
        int count = 0;
 
        while (!work.isEmpty()) {
            int[] path = work.poll();
 
            if (path.length == r) {
                System.out.println(build(path, items));
                count++;
                continue;
            }
 
            for (int i = 0; i < items.length; i++) {
                boolean used = false;
                for (int p : path) {
                    if (p == i) {
                        used = true;
                        break;
                    }
                }
                if (used) continue;
 
                int[] next = new int[path.length + 1];
                System.arraycopy(path, 0, next, 0, path.length);
                next[path.length] = i;
                work.add(next);
            }
        }
 
        System.out.println("\nTotal Permutations: " + count);
    }
 
    // TODO 4: Generate all possible combinations
    static void generateCombinations() {
 
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Add elements first.");
            return;
        }
 
        String[] items = toArray();
        System.out.println("Queue: " + queue);
 
        int r = readR(items.length, "select");
        if (r == -1) return;
 
        Queue<int[]> work = new LinkedList<>();
        work.add(new int[0]);
 
        int count = 0;
 
        while (!work.isEmpty()) {
            int[] path = work.poll();
 
            if (path.length == r) {
                System.out.println(build(path, items));
                count++;
                continue;
            }
         
            int start = path.length == 0 ? 0 : path[path.length - 1] + 1;
 
            for (int i = start; i < items.length; i++) {
                int[] next = new int[path.length + 1];
                System.arraycopy(path, 0, next, 0, path.length);
                next[path.length] = i;
                work.add(next);
            }
        }
 
        System.out.println("\nTotal Combinations: " + count);
    }
}
 
