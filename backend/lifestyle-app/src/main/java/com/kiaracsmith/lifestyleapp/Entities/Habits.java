package com.kiaracsmith.lifestyleapp.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="habits")
public class Habits {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long habit_id;
    
    @ManyToOne
    @JoinColumn(name="email", nullable=false)
    private UserDetails habits;

    @Column
    private String name;

    @Column
    private boolean in_progress;

    @Column
    private int repeat;

    @Column
    private int overall_progress;

    /*@Column
    private String email;*/

    public Long getHabitId() {
        return habit_id;
    }

    public String getName() {
        return name;
    }

    public boolean isInProgress() {
        return in_progress;
    }

    public int getRepeat() {
        return repeat;
    }

    public int getOverallProgress() {
        return overall_progress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void setOverallProgress(int overallProgress) {
        this.overall_progress = overallProgress;
    }
    
    public void setInProgress(boolean inProgress) {
        this.in_progress = inProgress;
    }

}
