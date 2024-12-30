package com.bestfit.BestFit.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="exercise_type")
public class ExerciseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String name;

    @Enumerated(EnumType.STRING)
    private MuscleGroup primaryMuscleGroup;

    @ElementCollection
    @CollectionTable(name="secondary_muscle_group", joinColumns = @JoinColumn(name="exercise_type_id"))
    @Column(name="muscle_group")
    @Enumerated(EnumType.STRING)
    private List<MuscleGroup> secondaryMuscleGroups;

    private String videoUrl;

    public enum MuscleGroup {
        CHEST, BACK, CORE, LEGS, SHOULDERS, PECTORALIS, BICEPS, QUADRICEPS, TRICEPS, DELTOID, GLUTEUS,
    }

    public ExerciseType() {
    }

    public ExerciseType(String name, String primaryMuscleGroup, List<String> secondaryMuscleGroups, String videoUrl) {
        this.name = name;
        this.primaryMuscleGroup = setMuscleGroup(primaryMuscleGroup);

        this.secondaryMuscleGroups = new ArrayList<>();

        for (String group : secondaryMuscleGroups) {
            this.secondaryMuscleGroups.add(setMuscleGroup(group));
        }
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryMuscleGroup() {
        return primaryMuscleGroup.toString();
    }

    public MuscleGroup setMuscleGroup(String group) {

        switch(group.toLowerCase()) {
            case "chest":
                return MuscleGroup.CHEST;
            case "back":
                return MuscleGroup.BACK;
            case "core":
                return MuscleGroup.CORE;
            case "legs":
                return MuscleGroup.LEGS;
            case "shoulders":
                return MuscleGroup.SHOULDERS;
            case "pectoralis":
                return MuscleGroup.PECTORALIS;
            case "biceps":
                return MuscleGroup.BICEPS;
            case "quadriceps":
                return MuscleGroup.QUADRICEPS;
            case "triceps":
                return MuscleGroup.TRICEPS;
            case "deltoid":
                return MuscleGroup.DELTOID;
            case "gluteus":
                return MuscleGroup.GLUTEUS;
            default:
                return null;
        }
    }

    public List<String> getSecondaryMuscleGroups() {

        List<String> groups = new ArrayList<>();

        for (MuscleGroup group : secondaryMuscleGroups) {
            groups.add(group.toString());
        }

        return groups;
    }


    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseType exerciseType = (ExerciseType) o;

        if (!Objects.equals(id, exerciseType.id)) return false;
        return Objects.equals(name, exerciseType.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", primaryMuscleGroup=" + primaryMuscleGroup +
                ", secondaryMuscleGroups=" + secondaryMuscleGroups +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
