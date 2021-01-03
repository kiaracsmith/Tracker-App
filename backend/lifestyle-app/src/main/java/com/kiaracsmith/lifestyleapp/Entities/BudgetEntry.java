package com.kiaracsmith.lifestyleapp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name = "budget_entry")
public class BudgetEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long budgetEntryId;

    @ManyToOne
    @JoinColumn(name="categoryId", nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="budgetId", nullable=false)
    private BudgetTable budgetTable;

    /*@Column
    private Long budget_table_id;*/

    /*@Column
    private Long category_id;*/

    @Column
    private int amount;

    @Column
    private String name;

    @Column
    private int limit;

    public Long getBudgetEntryId() {
        return budgetEntryId;
    }

    /*public Long getBudgetTableId() {
        return budget_table_id;
    }

    public Long getCategory() {
        return category_id;
    }*/

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    /*public void setCategory(Long category) {
        this.category_id = category;
    }

    public void setBudgetTableId(Long budgetTableId) {
        this.budget_table_id = budgetTableId;
    }*/

    public void setName(String name) {
        this.name = name;
    }

 }
