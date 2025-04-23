package com.home.assignment.com.expense.tracker.Controller;

import com.home.assignment.com.expense.tracker.Service.ExpenseService;
import com.home.assignment.com.expense.tracker.Service.MonthlyExpenseReport;
import com.home.assignment.com.expense.tracker.UserEntiry.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/getExpensedata/{id}")
    public Expense getExpenseById(@PathVariable Long id){

        return expenseService.getExpenseDataById(id);
    }

    @GetMapping("/getallexpense")
    public List<Expense>  getAllExpense(){

        return expenseService.getAllExpenseData();
    }

    @PostMapping("/createExpense")
    public ResponseEntity<String> createExpense(@RequestBody  Expense expense){
        expenseService.createExpense(expense);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Expense Created Successfull");
    }

    @DeleteMapping("/deleteExpense/{id}")
    public ResponseEntity<String> deleteExpenseByid(@PathVariable  Long id){
        expenseService.deleteExpenseById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Expense deleted Successfull");

    }
    @PutMapping("/UpdateExpense/{id}")
    public Expense updateExpense(@RequestBody Expense expense,@PathVariable  Long id){

        return  expenseService.updateExpense(expense,id);
    }
    @GetMapping("/getTotalExp")
    public double getTotalExpense( @RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                   @RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){

        return expenseService.gettotalExpenseofGivenDateRange(startDate,endDate);
    }

    @GetMapping("/getdataByCategory")
    public double getExpenseBycatogry(@RequestParam Long id,@RequestParam String category){
        return expenseService.getExpenseByCategory(id,category);
    }

    @GetMapping("/monthlyReport")
    public ResponseEntity<MonthlyExpenseReport> getMonthlyExpenseReport(
            @RequestParam(name="userId" ) Long userId,
            @RequestParam int month,
            @RequestParam int year) {

        MonthlyExpenseReport report = expenseService.getMonthlyReport(userId, month, year);
        return ResponseEntity.ok(report);
    }

}
