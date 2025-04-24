package itech2306_a1_Jack_Slorach;

import java.util.ArrayList;
import java.util.Scanner;

public class ShareRegistrySystem {

	// ===============================
	// Array List & Scanner Input
	// ===============================
	
	private ArrayList<Company> companies = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    // Main loop that runs the menu using switch case
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("=== Share Registry System ===");
            System.out.println("1. Add Company");
            System.out.println("2. List Companies");
            System.out.println("3. Add Investor");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    listCompanies();
                    break;
                case 3:
                    addInvestor();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please Try Again");
            }
        }
    }
    // ===============================
    // FUNCTION: Add Company (FR-2)
    // ===============================
    private void addCompany() {
        if (companies.size() >= 6) {
            System.out.println("You cannot add more than 6 companies.");
            return;
        }

        System.out.print("Company name: ");
        String name = input.nextLine();

        System.out.print("Founder's name: ");
        String founder = input.nextLine();

        System.out.print("Shares issued to founder: ");
        int founderShares = Integer.parseInt(input.nextLine());

        System.out.print("Additional shares available for investors: ");
        int additionalShares = Integer.parseInt(input.nextLine());

        System.out.print("Price per share: ");
        double sharePrice = Double.parseDouble(input.nextLine());

        System.out.print("Minimum shares per investor: ");
        int minShares = Integer.parseInt(input.nextLine());

        System.out.print("Maximum shares per investor: ");
        int maxShares = Integer.parseInt(input.nextLine());
        // Add Company to the Array List
        Company newCompany = new Company(name, founderShares, founder, additionalShares, sharePrice, minShares, maxShares);
        companies.add(newCompany);

        System.out.println("Company '" + name + "' has been added.");
    }
    // ===============================
    // FUNCTION: List Companies (FR-3)
    // ===============================
    private void listCompanies() {
        if (companies.isEmpty()) {
            System.out.println("No companies have been added yet.");
            return;
        }

        System.out.println("Companies managed by the system:");
        for (int i = 0; i < companies.size(); i++) {
            Company c = companies.get(i);
            System.out.printf("%d. %s [%d shares issued]%n", 
                i + 1, 
                c.getName(), 
                c.getTotalIssuedShares()
            );
        }
    }
    // ===============================
    // FUNCTION: Add Investor (FR-4)
    // ===============================
    private void addInvestor() {
        listCompanies(); // Lets Users Select a Company

        if (companies.isEmpty()) return;

        System.out.print("Select a company (number): ");
        int index = Integer.parseInt(input.nextLine()) - 1;

        if (index < 0 || index >= companies.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Company selected = companies.get(index);
        // Show Users The Share Offer Info
        System.out.printf("Share offer: $%.2f per share | Min: %d | Max: %d%n", 
            selected.getSharePrice(),
            selected.getMinSharesPerInvestor(),
            selected.getMaxSharesPerInvestor()
        );

        System.out.print("Investor name: ");
        String name = input.nextLine();

        System.out.print("How many shares would you like to purchase? ");
        int shares = Integer.parseInt(input.nextLine());
        // Add Invester to List if Valid
        boolean valid = selected.addInvestor(name, shares);

        if (valid) {
            System.out.println("Investor added successfully.");
        } else {
            System.out.println("Invalid share request or not enough available shares.");
        }
    }
}
