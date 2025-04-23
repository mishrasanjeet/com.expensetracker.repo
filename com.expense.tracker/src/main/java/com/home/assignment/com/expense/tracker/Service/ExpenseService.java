package com.home.assignment.com.expense.tracker.Service;

import com.home.assignment.com.expense.tracker.Repository.ExpenseRepository;
import com.home.assignment.com.expense.tracker.UserEntiry.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    //create the expense
    public void createExpense(Expense expense){
        expenseRepository.save(expense);
    }

    //getDataByID
    public Expense getExpenseDataById(Long id){

        return expenseRepository.findById(id).get();
    }

    public List<Expense> getAllExpenseData(){

        return expenseRepository.findAll();
    }

    //update the Expense
    public Expense updateExpense(Expense updatedExpense, Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setDate(updatedExpense.getDate());
        expense.setUser(updatedExpense.getUser());
        expense.setDescription(updatedExpense.getDescription());// Assuming expense has a User object

        return expenseRepository.save(expense);
    }

    public void deleteExpenseById(Long id){
        expenseRepository.deleteById(id);
    }

    public double gettotalExpenseofGivenDateRange(LocalDate startdate,LocalDate endDate){

        return expenseRepository.getTotalExpenseBetweenDates(startdate,endDate);

    }

    public double getExpenseByCategory(Long userID,String category){
        return expenseRepository.getExpenseByCategoryAndUser(userID,category);
    }

    public MonthlyExpenseReport getMonthlyReport(Long userId, int month, int year) {
        Double total = expenseRepository.getMonthlyTotalExpense(userId, month, year);
        List<Object[]> breakdown = expenseRepository.getMonthlyCategoryBreakdown(userId, month, year);

        Map<String, Double> breakdownMap = new HashMap<>();
        for (Object[] row : breakdown) {
            breakdownMap.put((String) row[0], (Double) row[1]);
        }

        MonthlyExpenseReport report = new MonthlyExpenseReport();
        report.setTotal(total != null ? total : 0.0);
        report.setCategoryBreakdown(breakdownMap);
        return report;
    }

}
