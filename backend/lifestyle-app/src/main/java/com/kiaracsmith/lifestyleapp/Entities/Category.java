package com.kiaracsmith.lifestyleapp.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @OneToMany(mappedBy = "category")
    private Set<BudgetEntry> budgetEntry;
    
    @Column
    private String categoryName;

    public void setCategoryName(String name) {
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
