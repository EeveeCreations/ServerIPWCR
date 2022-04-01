package nl.ipwcr.server.models;

import java.util.ArrayList;
import java.util.Collection;

public class NewWebUser {
    private String name;
    private String email;
    private String passcode;
    private Collection<UserRole> roles = new ArrayList<>();

    public NewWebUser(String name, String email, String passcode, Collection<UserRole> roles) {
        this.name = name;
        this.email = email;
        this.passcode = passcode;
        this.roles = roles;
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
}
