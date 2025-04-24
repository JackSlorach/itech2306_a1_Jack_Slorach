package itech2306_a1_Jack_Slorach;

import java.util.ArrayList;
import java.util.Scanner;

public class ShareRegistrySystem {
    private ArrayList<Company> companies = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add Company");
            System.out.println("2. List Companies");
            System.out.println("3. Add Investor");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    // Placeholder
                    break;
                case 2:
                    // Placeholder
                    break;
                case 3:
                    // Placeholder
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
