package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String passcode;
    private boolean isAdmin;



    public User(Long id, String name, String passcode, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.passcode = passcode;
        this.isAdmin = isAdmin;
    }

    public User(String name, String passcode, boolean isAdmin) {
        this.name = name;
        this.passcode = passcode;
        this.isAdmin = isAdmin;
    }
    public User() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
