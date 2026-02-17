package model;
import java.util.Date;
import java.util.Objects;

public class Loan {
    private Integer id;
    private Client client;
    private Item item;
    private Date loanDate;
    private Date returnDate;
    private Date expectedReturnDate;

    public Loan(Date expectedReturnDate, Date loanDate, Item item, Client client, Integer id) {
        this.id = id;
        this.client = client;
        this.item = item;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;

    }

    public Loan(Integer id, Client client, Item item, Date loanDate, Date returnDate, Date expectedReturnDate) {
        this.id = id;
        this.client = client;
        this.item = item;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    public Loan(Client client, Item item, Date loanDate, Date expectedReturnDate) {
        this.id = null;
        this.client = client;
        this.item = item;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    public Integer getLoan_id() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Item getItem() {
        return item;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(getLoan_id(), loan.getLoan_id());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getLoan_id());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", client=" + client +
                ", item=" + item +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", expectedReturnDate=" + expectedReturnDate +
                '}';
    }
}
