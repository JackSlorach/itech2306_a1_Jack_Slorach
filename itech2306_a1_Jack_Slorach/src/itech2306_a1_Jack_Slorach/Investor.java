package itech2306_a1_Jack_Slorach;
//===============================
//CLASS: Investor.java
//Represents a person who owns shares in a company
//===============================
public class Investor {
    private String name;
    private int sharesOwned;
    private double lastDividendAmount;
    private String lastDividendDate;
    private Boolean vote; // true = yes, false = no, null = hasn’t voted

    public Investor(String name, int sharesOwned) {
        this.name = name;
        this.sharesOwned = sharesOwned;
        this.vote = null;
    }

    public String getName() {
        return name;
    }

    public int getSharesOwned() {
        return sharesOwned;
    }
    // Used when dividends are paid
    public void setLastDividend(String date, double amount) {
        this.lastDividendDate = date;
        this.lastDividendAmount = amount;
    }
    // Record the shareholder's vote (true = yes, false = no, null = hasn't voted)
    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    // Used to check if they’ve already voted or not
    public Boolean getVote() {
        return vote;
    }
 // Get the date of the last dividend received
    public String getLastDividendDate() {
        return lastDividendDate;
    }

    // Get the amount of the last dividend received
    public double getLastDividendAmount() {
        return lastDividendAmount;
    }

}
