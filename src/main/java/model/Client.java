package model;

import java.util.Objects;

public class Client {
    private Integer client_id;
    private String nickname;
    private String email;
    private Integer reputation;

    public Client(Integer client_id, String nickname, String email, Integer reputation) {
        this.client_id = client_id;
        this.nickname = nickname;
        this.email = email;
        this.reputation = reputation;
    }

    public Integer getClient_id() {
        return client_id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(client_id, client.client_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(client_id);
    }

    @Override
    public String toString() {
        return this.getClient_id() + " | " + this.getNickname();
    }
}
