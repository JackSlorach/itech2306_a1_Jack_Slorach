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
	            System.out.println("4. List Investors");
	            System.out.println("5. Declare Dividend");
	            System.out.println("6. Set up Vote");
	            System.out.println("7. Record Shareholder Vote");
	            System.out.println("8. Close Voting and Show Results");
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
	                case 4:
	                    listInvestors();
	                    break;
	                case 5:
	                    declareDividend();
	                    break;
	                case 6:
	                    setupVote();
	                    break;
	                case 7:
	                    recordVote();
	                    break;
	                case 8:
	                    endVoting();
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
		 // ===============================
		 // FUNCTION: List Investors (FR-5)
		 // ===============================
		 private void listInvestors() {
		     listCompanies(); // Select Company First
		     if (companies.isEmpty()) return;
		
		     System.out.print("Select a company: ");
		     int index = Integer.parseInt(input.nextLine()) - 1;
		
		     if (index < 0 || index >= companies.size()) {
		         System.out.println("Invalid selection.");
		         return;
		     }
		
		     Company selected = companies.get(index);
		     System.out.println("The following are the investors for the company: " + selected.getName());
		
		     selected.printInvestorList();
		 }
			// ===============================
			// FUNCTION: Declare Dividend (FR-6)
			// ===============================
			private void declareDividend() {
			    listCompanies(); // pick which company this is for
			    if (companies.isEmpty()) return;
		
			    System.out.print("Select a company: ");
			    int index = Integer.parseInt(input.nextLine()) - 1;
		
			    if (index < 0 || index >= companies.size()) {
			        System.out.println("Invalid selection.");
			        return;
			    }
		
			    Company selected = companies.get(index);
		
			    System.out.print("Enter dividend payment date (e.g. 5 May 2025): ");
			    String date = input.nextLine();
		
			    System.out.print("Enter dividend amount per share (e.g. 0.045): ");
			    double amount = Double.parseDouble(input.nextLine());
		
			    selected.declareDividend(date, amount);
			}
			// ===============================
			// FUNCTION: Set Up Vote (FR-7)
			// ===============================
			private void setupVote() {
			    listCompanies();
			    if (companies.isEmpty()) return;

			    System.out.print("Select a company: ");
			    int index = Integer.parseInt(input.nextLine()) - 1;

			    if (index < 0 || index >= companies.size()) {
			        System.out.println("Invalid selection.");
			        return;
			    }

			    Company selected = companies.get(index);

			    System.out.print("Enter voting topic/question: ");
			    String topic = input.nextLine();

			    selected.setVoteTopic(topic);
			    System.out.println("The vote topic is now set up for shareholders to vote on.");
			}
			// ===============================
			// FUNCTION: Record Vote (FR-8)
			// ===============================
			private void recordVote() {
			    listCompanies(); // Let user pick the company
			    if (companies.isEmpty()) return;

			    System.out.print("Pick a company to record votes for: ");
			    int index = Integer.parseInt(input.nextLine()) - 1;

			    if (index < 0 || index >= companies.size()) {
			        System.out.println("Not a valid option.");
			        return;
			    }

			    Company selected = companies.get(index);

			    // No open vote? Bail out.
			    if (selected.getCurrentVote() == null || !selected.getCurrentVote().isActive()) {
			        System.out.println("This company doesn't have an open vote right now.");
			        return;
			    }

			    selected.printInvestorList(); // Show the shareholders

			    System.out.print("Pick the investor (number): ");
			    int investorIndex = Integer.parseInt(input.nextLine()) - 1;

			    if (investorIndex < 0 || investorIndex >= selected.getInvestorCount()) {
			        System.out.println("Invalid shareholder pick.");
			        return;
			    }

			    Investor voter = selected.getInvestorByIndex(investorIndex);

			    // Already voted? Nothing more to do.
			    if (voter.getVote() != null) {
			        System.out.println("This shareholder's already voted.");
			        return;
			    }

			    // Prompt for vote
			    System.out.println("Voting topic: " + selected.getCurrentVote().getTopic());
			    System.out.print("Vote yes or no: ");
			    String response = input.nextLine().trim().toLowerCase();

			    // Record the vote — if it’s not yes or no, skip it
			    if (response.equals("yes")) {
			        voter.setVote(true);
			    } else if (response.equals("no")) {
			        voter.setVote(false);
			    } else {
			        System.out.println("Didn’t catch that. Vote must be 'yes' or 'no'.");
			        return;
			    }

			    System.out.println("Vote recorded for " + voter.getName() + ".");
			}
			// ===============================
			// FUNCTION: End Voting and Show Results (FR-9)
			// ===============================
			private void endVoting() {
			    listCompanies();
			    if (companies.isEmpty()) return;

			    System.out.print("Select a company to close voting for: ");
			    int index = Integer.parseInt(input.nextLine()) - 1;

			    if (index < 0 || index >= companies.size()) {
			        System.out.println("Invalid selection.");
			        return;
			    }

			    Company selected = companies.get(index);
			    Vote vote = selected.getCurrentVote();

			    // If there's no vote set up or it's already closed, we can't do anything
			    if (vote == null || !vote.isActive()) {
			        System.out.println("There's no open vote for this company.");
			        return;
			    }

			    // Count up the shares for yes/no votes
			    int yesVotes = 0;
			    int noVotes = 0;
			    int totalVotes = 0;

			    for (Investor i : selected.getInvestors()) {
			        Boolean voteValue = i.getVote();

			        if (voteValue != null) {
			            totalVotes += i.getSharesOwned();

			            if (voteValue) {
			                yesVotes += i.getSharesOwned();
			            } else {
			                noVotes += i.getSharesOwned();
			            }
			        }
			    }

			    // Calculate percentages (just based on those who actually voted)
			    double yesPercent = totalVotes == 0 ? 0 : (yesVotes * 100.0 / totalVotes);
			    double noPercent = totalVotes == 0 ? 0 : (noVotes * 100.0 / totalVotes);

			    System.out.println("\nVote results for topic: " + vote.getTopic());
			    System.out.println("Yes votes (by shares): " + yesVotes);
			    System.out.println("No votes (by shares): " + noVotes);
			    System.out.printf("Yes: %.1f%%   No: %.1f%%%n", yesPercent, noPercent);

			    vote.closeVote(); // lock it down so no more changes
			    System.out.println("Voting is now closed.");
			}

}
