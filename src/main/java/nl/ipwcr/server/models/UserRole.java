package nl.ipwcr.server.models;

import javax.persistence.*;

@Entity
@Table(name = "role_")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;


    public UserRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
