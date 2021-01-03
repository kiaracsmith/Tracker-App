package com.kiaracsmith.lifestyleapp.Service;

import com.kiaracsmith.lifestyleapp.Entities.BudgetEntry;
import com.kiaracsmith.lifestyleapp.Repositories.BudgetEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetEntryService implements BudgetEntryServiceImpl {

    @Autowired
    private BudgetEntryRepository budgetEntryRepository;

    @Override
    public BudgetEntry findByBudgetEntryId(Long id) {        
        BudgetEntry entry = budgetEntryRepository.findByBudgetEntryId(id);

        return entry;
    }
}
