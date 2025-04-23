package com.home.assignment.com.expense.tracker.Repository;

import com.home.assignment.com.expense.tracker.UserEntiry.Expense;
import com.home.assignment.com.expense.tracker.UserEntiry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    Double getTotalExpenseBetweenDates(@Param("startDate") LocalDate startDate,
                                       @Param("endDate") LocalDate endDate);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId AND e.category = :category")
    Double getExpenseByCategoryAndUser(@Param("userId") Long userId, @Param("category") String category);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId AND MONTH(e.date) = :month AND YEAR(e.date) = :year")
    Double getMonthlyTotalExpense(@Param("userId") Long userId, @Param("month") int month, @Param("year") int year);

    @Query("SELECT e.category, SUM(e.amount) FROM Expense e WHERE e.user.id = :userId AND MONTH(e.date) = :month AND YEAR(e.date) = :year GROUP BY e.category")
    List<Object[]> getMonthlyCategoryBreakdown(@Param("userId") Long userId, @Param("month") int month, @Param("year") int year);


}
