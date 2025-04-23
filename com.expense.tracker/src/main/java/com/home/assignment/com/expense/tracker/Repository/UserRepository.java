package com.home.assignment.com.expense.tracker.Repository;

import com.home.assignment.com.expense.tracker.UserEntiry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
