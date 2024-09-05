package laboratoryactivity1;

//This Java program demonstrates how to use an Object array that can store both numbers and strings. 
//It lets users input elements into the array, shows the elements in reverse order, 
//and filters out the numeric elements to display them in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class ObjectArray {
    // ObjectArray to hold both numeric and string elements
    private String[] arr;

    // Initializing using a constructor the array based on the given size
    public ObjectArray(int size) {
        arr = new String[size];
    }

    // To populate the array with user input
    public void populateArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + arr.length + " elements:");
        String input = scanner.nextLine();
        String[] elements = input.split(",\\s*");
        if (elements.length != arr.length) {
            System.out.println("Error: Number of elements entered does not match the array size.");
            return;
        }
        System.arraycopy(elements, 0, arr, 0, arr.length);
    }

    // To display the elements in reverse order
    public void displayReverseOrder() {
        System.out.print("Reverse Order: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Filter numeric elements, sort them, and display them in ascending order
    public void displayAscendingOrder() {
        // Sort elements based on the numeric part
        Arrays.sort(arr, (a, b) -> {
            int numA = Integer.parseInt(a.split(" ")[0]);
            int numB = Integer.parseInt(b.split(" ")[0]);
            return Integer.compare(numA, numB);
        });

        // Display sorted elements
        System.out.print("Ascending Order: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Create an instance of ObjectArray with the specified size
        ObjectArray objectArray = new ObjectArray(size);

        // Populate the array with elements
        objectArray.populateArray();

        // Display elements in reverse order
        objectArray.displayReverseOrder();

        // Display numeric elements in ascending order
        objectArray.displayAscendingOrder();
    }
}

