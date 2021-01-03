package com.kiaracsmith.lifestyleapp.Repositories;

import com.kiaracsmith.lifestyleapp.Entities.Habits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("habitsRepository")
public interface HabitsRepository extends JpaRepository<Habits, Long> {
    
}
