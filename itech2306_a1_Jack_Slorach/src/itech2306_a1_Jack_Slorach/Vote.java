package itech2306_a1_Jack_Slorach;

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

    public void closeVote() {
        this.active = false;
    }
}
