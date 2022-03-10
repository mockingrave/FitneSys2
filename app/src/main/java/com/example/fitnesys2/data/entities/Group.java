package com.example.fitnesys2.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(tableName = "groups", indices = {@Index(value = {"name"}, unique = true)})
public class Group{

    @PrimaryKey()
    private int id;

    private String name;

}
