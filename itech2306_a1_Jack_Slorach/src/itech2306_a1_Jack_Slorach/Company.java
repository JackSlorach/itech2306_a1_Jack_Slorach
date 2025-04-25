package itech2306_a1_Jack_Slorach;

import java.util.ArrayList;
import java.text.NumberFormat;
//===============================
//CLASS: Company.java
//Handles company setup, investors, shares, dividends, and votes
//===============================
public class Company {
    private String name;
    private int founderShares;
    private String founderName;
    private int availableShares;
    private double sharePrice;
    private int minShares;
    private int maxShares;

    private ArrayList<Investor> investors = new ArrayList<>();
    private Dividend currentDividend;
    private Vote currentVote;
    // Company setup happens here, and founder is auto-added as first investor
    public Company(String name, int founderShares, String founderName, int availableShares, double sharePrice, int min, int max) {
        this.name = name;
        this.founderShares = founderShares;
        this.founderName = founderName;
        this.availableShares = availableShares;
        this.sharePrice = sharePrice;
        this.minShares = min;
        this.maxShares = max;
        // Add the Founder as the First Investor
        investors.add(new Investor(founderName, founderShares));
    }

    public String getName() {
        return name;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public int getMinSharesPerInvestor() {
        return minShares;
    }

    public int getMaxSharesPerInvestor() {
        return maxShares;
    }

    // Attempts to add a new investor based on share rules
    public boolean addInvestor(String name, int sharesRequested) {
        if (investors.size() >= 100) return false;
        if (sharesRequested < minShares || sharesRequested > maxShares || sharesRequested > availableShares)
            return false;

        Investor newInvestor = new Investor(name, sharesRequested);
        investors.add(newInvestor);
        availableShares -= sharesRequested;
        return true;
    }
    // Totals all shares currently owned by investors
    public int getTotalIssuedShares() {
        int total = 0;
        for (Investor i : investors) {
            total += i.getSharesOwned();
        }
        return total;
    }
    // Shows list of investors and their ownership %
    public void printInvestorList() {
        int totalShares = getTotalIssuedShares();
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);

        for (int i = 0; i < investors.size(); i++) {
            Investor inv = investors.get(i);
            double percentage = (double) inv.getSharesOwned() / totalShares;
            System.out.printf(" %d. %s [%d shares, %.1f%%]%n", i + 1, inv.getName(), inv.getSharesOwned(), percentage * 100);
        }

        System.out.println("Total shares issued to shareholders: " + totalShares);
    }
    // Handles dividend declaration and payout report
    public void declareDividend(String date, double amountPerShare) {
        this.currentDividend = new Dividend(date, amountPerShare);
        double totalPaid = 0;
        NumberFormat money = NumberFormat.getCurrencyInstance();

        System.out.println("The following amounts will need to be paid to the investors:");
        for (Investor inv : investors) {
            double amount = inv.getSharesOwned() * amountPerShare;
            inv.setLastDividend(date, amount);
            totalPaid += amount;
            System.out.println("  " + money.format(amount) + " - " + inv.getName());
        }

        System.out.println("Total amount being paid: " + money.format(totalPaid));
    }
 // Sets the vote topic for this company and resets all shareholder votes
    public void setVoteTopic(String topic) {
        this.currentVote = new Vote(topic);

        // Clear all previous votes — fresh start for this topic
        for (Investor inv : investors) {
            inv.setVote(null);
        }
    }
 // Get current vote topic for the company
    public Vote getCurrentVote() {
        return currentVote;
    }

    // Returns how many investors are currently in this company
    public int getInvestorCount() {
        return investors.size();
    }

    // Grab a specific investor by their index (for voting, lookup, etc.)
    public Investor getInvestorByIndex(int index) {
        return investors.get(index);
    }
	 // Return the full investor list (used for vote tallying)
	    public ArrayList<Investor> getInvestors() {
	        return investors;
	    }

}
