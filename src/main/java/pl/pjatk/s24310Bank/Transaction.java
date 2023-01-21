package pl.pjatk.s24310Bank;

public class Transaction {

    private Client client;
    private Status status;
    private double amount;

    public Transaction(Client client, Status status, double amount) {
        this.client = client;
        this.status = status;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "client=" + client +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}
