package com.kiaracsmith.lifestyleapp.Service;

import java.util.List;
import java.util.Optional;

import com.kiaracsmith.lifestyleapp.Entities.BudgetTable;

public interface BudgetTableService {
    
    public List<BudgetTable> findByEmail(String email);

    public BudgetTable findByBudgetEntry(Long id);

    public BudgetTable findByBudgetId(Long id);

    public BudgetTable findByEmailAndMonthAndYear(String email, int month, int year);

    public BudgetTable saveBudgetTable(BudgetTable budgetTable);

    public void deleteBudgetTable(BudgetTable budgetTable);
}
