package com.example.fitnesys2.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "exercises",
        indices = {@Index(value = {"name"}, unique = true)},
        foreignKeys = @ForeignKey(
                entity = Group.class,
                parentColumns = "id",
                childColumns = "group_id",
                onDelete = 5,
                onUpdate = 5))
public class Exercise{

    @PrimaryKey()
    private int id;

    private Integer groupId;

    private String name;

    private String note;

}
