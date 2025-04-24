package itech2306_a1_Jack_Slorach;

public class Investor {
    private String name;
    private int sharesOwned;
    private double lastDividendAmount;
    private String lastDividendDate;
    private Boolean vote; // true = yes, false = no, null = not voted

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
}
