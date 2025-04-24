package itech2306_a1_Jack_Slorach;

import java.util.ArrayList;

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

    // Add Investor if the share request is valid
    public boolean addInvestor(String name, int sharesRequested) {
        if (investors.size() >= 100) return false;
        if (sharesRequested < minShares || sharesRequested > maxShares || sharesRequested > availableShares)
            return false;

        Investor newInvestor = new Investor(name, sharesRequested);
        investors.add(newInvestor);
        availableShares -= sharesRequested;
        return true;
    }
    // Calculate total issued shares
    public int getTotalIssuedShares() {
        int total = 0;
        for (Investor i : investors) {
            total += i.getSharesOwned();
        }
        return total;
    }
}
