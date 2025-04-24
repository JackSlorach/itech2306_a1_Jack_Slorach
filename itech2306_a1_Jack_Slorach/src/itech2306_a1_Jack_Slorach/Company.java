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
        investors.add(new Investor(founderName, founderShares));
    }

    public String getName() {
        return name;
    }
}
