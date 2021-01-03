package com.kiaracsmith.lifestyleapp.Service;

import java.util.List;
import java.util.Optional;

import com.kiaracsmith.lifestyleapp.Entities.BudgetTable;
import com.kiaracsmith.lifestyleapp.Repositories.BudgetTableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("budgetTableService")
public class BudgetTableServiceImpl implements BudgetTableService {
    
    @Autowired
    private BudgetTableRepository budgetTableRepository;

    @Override
    public List<BudgetTable> findByEmail(String email) {
        List<BudgetTable> bTable = budgetTableRepository.findByBudgetTable_Email(email);

        if (bTable != null) {
            return bTable;
        } else {
            return null;
        }
    }

    @Override
    public BudgetTable findByBudgetEntry(Long id) {
        BudgetTable budgetTable = budgetTableRepository.findByBudgetEntry_BudgetTable(id);

        if (budgetTable != null) {
            return budgetTable;
        } else {
            return null;
        }
    }

    @Override
    public BudgetTable saveBudgetTable(BudgetTable budgetTable) {
        budgetTableRepository.save(budgetTable);
        return budgetTable;
    }

    @Override
    public BudgetTable findByBudgetId(Long id) {
        BudgetTable budgetTable = budgetTableRepository.findByBudgetId(id);

        return budgetTable;
    }

    @Override
    public BudgetTable findByEmailAndMonthAndYear(String email, int month, int year) {
        BudgetTable table = budgetTableRepository.findByMonthAndYearAndBudgetTable_Email(month, year, email);

        return table;
    }

    @Override
    public void deleteBudgetTable(BudgetTable budgetTable) {
        budgetTableRepository.delete(budgetTable);
    }
}
