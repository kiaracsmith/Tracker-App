package com.kiaracsmith.lifestyleapp.Controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;

import com.kiaracsmith.lifestyleapp.Entities.BudgetTable;
import com.kiaracsmith.lifestyleapp.Entities.UserDetails;
import com.kiaracsmith.lifestyleapp.Service.AccountsServiceImpl;
import com.kiaracsmith.lifestyleapp.Service.BudgetTableServiceImpl;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BudgetTableController {
    
    @Autowired
    private BudgetTableServiceImpl budgetTableService;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AccountsServiceImpl accountsService;

    @GetMapping("/budgets/user/")
    @ResponseBody
    public ResponseEntity<List<BudgetTable>> getBudgetTablesByUser(@PathParam("email") String email) {
        List<BudgetTable> budgetTables = budgetTableService.findByEmail(email);
        
        if (budgetTables != null) {
            return new ResponseEntity<List<BudgetTable>>(budgetTables, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<BudgetTable>>(budgetTables, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/budgets/budget-entry")
    @ResponseBody
    public ResponseEntity<BudgetTable> getBudgetTableByEntry(@PathParam("budget_entry_id") Long budgetEntryId) {
        BudgetTable budgetTable = budgetTableService.findByBudgetEntry(budgetEntryId);

        if (budgetTable == null) {
            return new ResponseEntity<BudgetTable>(budgetTable, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<BudgetTable>(budgetTable, new HttpHeaders(), HttpStatus.OK);

        }
    }

    @PostMapping("/budgets/")
    @ResponseBody
    public Map<String,String> saveBudgetTable(@RequestParam("email") String email, @RequestParam("month") int month, @RequestParam("year") int year,
                                                @RequestParam("is_completed") boolean isCompleted) {
        UserDetails user = accountsService.findUserByEmail(email);

        if (user != null) {
            BudgetTable table = budgetTableService.findByEmailAndMonthAndYear(email, month, year);

            if (table == null) {
                BudgetTable budgetTable = new BudgetTable();
                budgetTable.setBudgetTable(user);
                budgetTable.setCompleted(isCompleted);
                budgetTable.setMonth(month);
                budgetTable.setYear(year);
                budgetTableService.saveBudgetTable(budgetTable);
                return Collections.singletonMap("Response", "Budget table saved");
            } else {
                return Collections.singletonMap("Response", "Budget table already exists for that user");
            }
            

        } else {
            return Collections.singletonMap("Response", "User does not exist");
        }

    }

    @PutMapping("/budgets/")
    @ResponseBody
    public ResponseEntity<BudgetTable> editBudgetTable(@RequestBody BudgetTable budgetTable){
        budgetTableService.saveBudgetTable(budgetTable);
        return new ResponseEntity<BudgetTable>(budgetTable, new HttpHeaders(), HttpStatus.OK);   
    }

    @DeleteMapping("/budgets/")
    @ResponseBody
    public Map<String,String> deleteBudgetTable(@RequestParam("email") String email, @RequestParam("month") int month, @RequestParam("year") int year,
                                                @RequestParam("is_completed") boolean isCompleted) {
        UserDetails user = accountsService.findUserByEmail(email);

        if (user == null) {
            return Collections.singletonMap("Response", "user email not found");
        } else {
            BudgetTable budgetTable = budgetTableService.findByEmailAndMonthAndYear(email, month, year);

            if (budgetTable == null) {
                return Collections.singletonMap("Response", "Budget Table not found");
            } else {
                budgetTableService.deleteBudgetTable(budgetTable);
                return Collections.singletonMap("Response", "Budget Table deleted");
            }
        }
    }


}
