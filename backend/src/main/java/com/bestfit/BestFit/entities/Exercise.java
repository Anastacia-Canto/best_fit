package com.bestfit.BestFit.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private ExerciseType type;

    private int repetition;
    private double weight;
    private LocalTime interval;
    private LocalTime duration;


    public Exercise() {
    }

    public Exercise(ExerciseType type, int repetition, double weight, LocalTime interval, LocalTime duration) {
        this.type = type;
        this.repetition = repetition;
        this.weight = weight;
        this.interval = interval;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalTime getInterval() {
        return interval;
    }

    public void setInterval(LocalTime interval) {
        this.interval = interval;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        return type.equals(exercise.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "type=" + type +
                ", repetition=" + repetition +
                ", weight=" + weight +
                ", interval=" + interval +
                ", duration=" + duration +
                '}';
    }
}
