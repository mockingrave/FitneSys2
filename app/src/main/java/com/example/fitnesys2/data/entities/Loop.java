package com.example.fitnesys2.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = "loops",
        foreignKeys = {
                @ForeignKey(
                        entity = Workout.class,
                        parentColumns = "id",
                        childColumns = "workout_id",
                        onDelete = 5,
                        onUpdate = 5),
                @ForeignKey(
                        entity = Exercise.class,
                        parentColumns = "id",
                        childColumns = "exercise_id",
                        onDelete = 5,
                        onUpdate = 5)
        })
public class Loop{

    @PrimaryKey()
    private int id;

    private Integer workoutId;

    private Integer exerciseId;

    private Integer level;

    private Integer weight;

    private Integer time;

    private Integer reps;

    private String note;

}
