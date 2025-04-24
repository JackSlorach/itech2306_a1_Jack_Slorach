package itech2306_a1_Jack_Slorach;

public class Dividend {
    private String date;
    private double amountPerShare;

    public Dividend(String date, double amountPerShare) {
        this.date = date;
        this.amountPerShare = amountPerShare;
    }

    public String getDate() {
        return date;
    }

    public double getAmountPerShare() {
        return amountPerShare;
    }
}
