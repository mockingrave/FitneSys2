package com.example.fitnesys2.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = "workouts")

public class Workout {

    @PrimaryKey()
    private int id;

    private Integer dayId;

    private Boolean isOver;

    private String note;

}
