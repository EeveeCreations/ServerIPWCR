package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "role_")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String role;


    public UserRole(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    public UserRole(String role) {
        this.role = role;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
