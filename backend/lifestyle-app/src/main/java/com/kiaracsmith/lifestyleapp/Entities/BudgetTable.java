package com.kiaracsmith.lifestyleapp.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="budget_table")
public class BudgetTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetId;
    
    /*@Column
    private String email;*/

    @ManyToOne
    @JoinColumn(name="email", nullable=false, referencedColumnName = "email")
    private UserDetails budgetTable;
    
    @OneToMany(mappedBy = "budgetTable")
    private Set<BudgetEntry> budgetEntry;

    @Column
    private int month;

    @Column
    private int year;

    @Column
    private boolean isCompleted;

    public Long getBudgetId() {
        return budgetId;
    }

   /* public String getEmail() {
        return email;
    }*/

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setBudgetTable(UserDetails budgetTable) {
        this.budgetTable = budgetTable;
    }
    
   /* public void setEmail(String email) {
        this.email = email;
    }*/

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

}
