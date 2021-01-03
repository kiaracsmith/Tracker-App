package com.kiaracsmith.lifestyleapp.Repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.kiaracsmith.lifestyleapp.Entities.BudgetEntry;
import com.kiaracsmith.lifestyleapp.Entities.BudgetTable;
import com.kiaracsmith.lifestyleapp.Entities.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("budgetTableRepository")
public interface BudgetTableRepository extends JpaRepository<BudgetTable, Long>{
    
   /* @Query(value="SELECT * FROM budget_table WHERE budget_id = ?1", nativeQuery = true)
    public BudgetTable findByBudgetTableId(Long Id);
    */
    /*@Query(value="SELECT * FROM budget_table WHERE is_completed = ?1 and email = ?2")
    public Optional<BudgetTable> findCompletedBudgetsFromUser(boolean completed, String email);
    */
    
    /**
     * Searches the budget tables and returns all budget tables connected to 
     * the given email
     *  
     * @param email
     * @return
     */
    public List<BudgetTable> findByBudgetTable_Email(String email);
    
    public BudgetTable findByBudgetId(Long id);

    public BudgetTable findByBudgetEntry_BudgetTable(Long id);

    public BudgetTable findByMonthAndYearAndBudgetTable_Email(int month, int year, String email);

    /*@Query(value="SELECT b.* FROM budget_table b WHERE budget_entry = ?1")
    public Optional<BudgetTable> findByBudgetEntry(Long budgetEntryId);
    */    
}

