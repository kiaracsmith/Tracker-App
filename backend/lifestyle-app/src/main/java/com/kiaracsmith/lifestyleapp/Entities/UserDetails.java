package com.kiaracsmith.lifestyleapp.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class UserDetails {
    
    @Id
    private String email;

    @OneToMany(mappedBy = "budgetTable")
    private Set<BudgetTable> budgetTable;

    @OneToMany(mappedBy = "habits")
    private Set<Habits> habits;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String password;

    @Column
    private boolean is_admin;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return is_admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public void setAdmin(boolean admin) {
        this.is_admin = admin;
    }

    
}
