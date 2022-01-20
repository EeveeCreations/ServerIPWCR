package nl.ipwcr.server.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "web_user")
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passcode;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<UserRole> roles = new ArrayList<>();

    public WebUser(Long id, String name, String email, String passcode, Collection<UserRole> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passcode = passcode;
        this.roles = roles;
    }

    public WebUser(String name, String email, String passcode, Collection<UserRole> roles) {
        this.name = name;
        this.email = email;
        this.passcode = passcode;
        this.roles = roles;
    }

    public WebUser() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public Collection<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<UserRole> roles) {
        this.roles = roles;
    }
}
