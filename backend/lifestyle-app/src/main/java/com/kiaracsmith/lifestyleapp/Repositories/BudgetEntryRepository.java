package com.kiaracsmith.lifestyleapp.Repositories;

import java.util.List;

import com.kiaracsmith.lifestyleapp.Entities.BudgetEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("budgetEntryRepository")
public interface BudgetEntryRepository extends JpaRepository<BudgetEntry, Long>{
    public BudgetEntry findByBudgetEntryId(Long id);
    
    public List<BudgetEntry> findByCategory_CategoryId(Long id);

    public List<BudgetEntry> findByBudgetTable_BudgetIdAndCategory_CategoryId(Long budgetId, Long categoryId);

    public List<BudgetEntry> findByBudgetTable_BudgetId(Long budgetId);

}
