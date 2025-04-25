package itech2306_a1_Jack_Slorach;
//===============================
//CLASS: Vote.java
//Represents a voting topic and status
//===============================
public class Vote {
    private String topic;
    private boolean active;

    public Vote(String topic) {
        this.topic = topic;
        this.active = true;
    }

    public String getTopic() {
        return topic;
    }

    public boolean isActive() {
        return active;
    }

    // Marks the vote as finished — after this, no more votes can be recorded
    public void closeVote() {
        this.active = false;
    }

}
