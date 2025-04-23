package com.home.assignment.com.expense.tracker.UserEntiry;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
     private double amount;
    private String description;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private LocalDate date = LocalDate.now();
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense(Long id, double amount, String description, String category, LocalDate date,User user) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
        this.user=user;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
