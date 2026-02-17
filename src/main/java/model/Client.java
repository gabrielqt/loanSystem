package model;

import java.util.Objects;

public class Client {
    private Integer id;
    private String nickname;
    private String email;
    private Integer reputation;

    public Client(){}

    public Client(Integer id, String nickname, String email, Integer reputation) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.reputation = reputation;
    }

    public Client(String nickname, String email, Integer reputation) {
        this.id = null;
        this.nickname = nickname;
        this.email = email;
        this.reputation = reputation;
    }

    public Integer getClient_id() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return this.getClient_id() + " | " + this.getNickname();
    }
}
