package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Loan {
    private Integer id;
    private Client client;
    private Item item;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate expectedReturnDate;


    public Loan(){}

    public Loan(Client client, Item item, LocalDate expectedReturnDate) {
        this.id = null;
        this.client = client;
        this.item = item;
        this.loanDate = LocalDate.now();
        this.returnDate = null;
        this.expectedReturnDate = expectedReturnDate;
    }

    public Loan(Integer id, Client client, Item item, LocalDate loanDate, LocalDate returnDate, LocalDate expectedReturnDate) {
        this.id = id;
        this.client = client;
        this.item = item;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
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

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
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
